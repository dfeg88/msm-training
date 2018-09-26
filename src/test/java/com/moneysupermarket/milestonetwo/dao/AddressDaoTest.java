package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.data.MongoConnection;
import com.moneysupermarket.milestonetwo.data.MongoProperties;
import com.moneysupermarket.milestonetwo.models.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class AddressDaoTest{

    private AddressDao addressDao;

    @Mock
    private MongoConnection mongoConnection;

    @Mock
    private Address address;

    @BeforeEach
    void setUp() {
        MongoProperties mongoProperties = MongoProperties.builder()
                .collection("addresses")
                .database("msm-training-test")
                .build();

        mongoConnection = new MongoConnection(mongoProperties, Address.class);
    }

    @AfterEach
    void tearDown() {
        mongoConnection.getMongoClient().close();
    }

    @Test
    void test_save_shouldWriteAddressesToDatabase() {
        Assertions.assertNotNull(mongoConnection.getDatabase());
        Assertions.assertNotNull(mongoConnection.getDbCollection());

    }

    @Test
    void getAll() {
    }
}