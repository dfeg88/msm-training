import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import dao.CsvDao;
import models.Address;
import models.Car;
import models.Customer;
import models.Profile;
import util.FileUtil;

@ExtendWith(MockitoExtension.class)
public class CsvDaoTest {

    private CsvDao csvDao;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        csvDao = new CsvDao(new FileReader(FileUtil.getCsvFile("TEST_DATA")));
    }

    @Test
    void shouldReadProfilesFromCsvAndReturnAListOfProfiles() throws IOException {
        Profile expectedProfile = new Profile(
            new Address("0", "Monica", "Maswarah", "Xujiaqiao", ""),
            new Customer("Joana", "Dewitt"),
            new Car("3GTU2YEJ3DG534882","Chevrolet","SSR",51.2)
        );

        List<Profile> actualProfile = csvDao.getProfilesFromCSV();

        MatcherAssert.assertThat(actualProfile, contains(expectedProfile));
    }
}
