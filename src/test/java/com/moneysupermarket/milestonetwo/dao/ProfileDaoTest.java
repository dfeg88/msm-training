package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.models.Profile;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProfileDaoTest {

    private static final String CAR_MAKE = "BMW";

    private ProfileDao underTest;

    @Mock
    private FindIterable<Profile> profileFindIterable;

    @Mock
    MongoCollection<Profile> mongoCollection;

    @Mock
    private Profile profile;

    @Mock
    private List<Profile> profileList;

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
        when(mongoCollection.find()).thenReturn(profileFindIterable);
        assertNotNull(underTest.getAll());
    }

    @Test
    void getLastTenProfiles() {
        when(mongoCollection.countDocuments()).thenReturn(11L);
        when(mongoCollection.find()).thenReturn(profileFindIterable);
        when(profileFindIterable.skip(anyInt())).thenReturn(profileFindIterable);
        when(profileFindIterable.into(anyList())).thenReturn(profileList);

        assertThat(underTest.getLastTenProfiles()).isEqualTo(profileList);
    }

    @Test
    void getProfilesByCarMake() {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        when(mongoCollection.find(any(Bson.class))).thenReturn(profileFindIterable);
        when(profileFindIterable.into(anyList())).thenReturn(profileList);

        underTest.getProfilesByCarMake(CAR_MAKE);

        verify(mongoCollection).find(eq("car.make", captor.capture()));
    }

    @Test
    void getProfilesByPostcode() {
        when(mongoCollection.find(any(Bson.class))).thenReturn(profileFindIterable);
        when(profileFindIterable.into(anyList())).thenReturn(profileList);

        assertNotNull(underTest.getProfilesByPostcode("SK11"));
    }
}