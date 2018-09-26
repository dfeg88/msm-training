package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.models.Profile;
import com.mongodb.client.MongoCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProfileDaoTest {

    private ProfileDao underTest;

    @Mock
    MongoCollection<Profile> mongoCollection;

    @Mock
    private Profile profile;

    @Mock
    private List<Profile> profiles;

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
//        when(underTest.getAll()).thenReturn(profiles);
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