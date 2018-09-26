package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.models.Profile;
import com.mongodb.client.MongoCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProfileDaoTest {

    private ProfileDao underTest;

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