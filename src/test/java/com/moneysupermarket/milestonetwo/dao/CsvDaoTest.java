package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.models.Address;
import com.moneysupermarket.milestonetwo.models.Car;
import com.moneysupermarket.milestonetwo.models.Customer;
import com.moneysupermarket.milestonetwo.models.Profile;
import com.moneysupermarket.milestonetwo.util.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CsvDaoTest {

    private CsvDao csvDao;
    private FileUtil fileUtil = new FileUtil();


    @BeforeEach
    void setUp() throws FileNotFoundException {
        csvDao = new CsvDao(new FileReader(fileUtil.getCsvFile("TEST_DATA")));
    }

    @Test
    @DisplayName("CSV Test File Contains Expected Profile")
    void shouldCheckThatCsvFileContainsASpecificRecord() throws IOException {
        Profile expectedProfile = new Profile(
            new Address("8", "Roxbury", "Haukipudas", "Keda", "SK11 3ED"),
            new Car("1G6DG577580960863","BMW","Z4",28.8),
            new Customer("Kate", "Osgerby")
        );

        List<Profile> actualProfile = csvDao.getProfilesFromCSV();
        assertThat(actualProfile).contains(expectedProfile);
    }

    @Test
    @DisplayName("List should not contain profile that does not exist")
    void shouldNotContainProfileThatIsNotInList() throws IOException {
        Profile expectedProfile = new Profile(
                new Address("8", "Roxbury", "Haukipudas", "Keda", "SK11 3ED"),
                new Car("1G6DG577580960863","BMW","Z4",28.8),
                new Customer("Kate", "DDDDD")
        );

        List<Profile> actualProfile = csvDao.getProfilesFromCSV();
        assertThat(actualProfile).doesNotContain(expectedProfile);
    }

    @Test
    void shouldThrowIOException() {
        Assertions.assertThrows(IOException.class, () -> csvDao.getProfilesFromCSV());
    }


}
