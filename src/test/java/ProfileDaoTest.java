import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProfileDao;
import models.Customer;
import models.Profile;

@ExtendWith(MockitoExtension.class)
public class ProfileDaoTest {

    private ProfileDao profileDao;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private Profile profile;

    @Mock
    private Customer customer;

    @BeforeEach
    void setUp() {
        profileDao = new ProfileDao(objectMapper);
    }

    @Test
    @DisplayName("Save profile to .json file")
    void save_shouldSaveProfileToFile() throws IOException {
        when(profile.getCustomer()).thenReturn(customer);
        when(customer.getFirstName()).thenReturn("Dan");
        when(customer.getLastName()).thenReturn("F");
        profileDao.save(profile);
        verify(objectMapper).writeValue(any(File.class), eq(profile));
    }

    @Test
    void save_shouldThrowNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> profileDao.save(null));
    }
}