package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.models.Address;
import com.moneysupermarket.milestonetwo.models.Car;
import com.moneysupermarket.milestonetwo.models.Customer;
import com.moneysupermarket.milestonetwo.models.Profile;
import com.mongodb.client.MongoCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProfileDaoTest {

    private ProfileDao underTest;
    private List<Profile> profiles = new LinkedList<>();

    @Mock
    MongoCollection<Profile> mongoCollection;

    @Mock
    private Profile profile;

    @BeforeEach
    void setUp() {
        underTest = new ProfileDao(mongoCollection);
    }

    @Test
    void save() {
        underTest.save(profile);
        verify(mongoCollection).insertOne(profile);
    }

    @Test
    void getAll() {
        profiles.add(new Profile(
                new Address("test1", "test1", "test1", "test1", "test1"),
                new Car("E57 VKD", "Ford", "Focus", 2.4),
                new Customer("Dan", "Fegan")
        ));

        when(underTest.getAll()).thenReturn(profiles);
        Assertions.assertNotNull(underTest.getAll());
//        verify(mongoCollection).find();
    }

    @Test
    void getLastTenProfiles() {
    }

    @Test
    void getProfilesByCarMake() {
    }

    @Test
    void getProfilesByPostcode() {
    }
}