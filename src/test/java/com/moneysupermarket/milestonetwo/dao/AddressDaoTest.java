package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.models.Address;
import com.mongodb.client.MongoCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AddressDaoTest{

    private AddressDao underTest;

    @Mock
    private MongoCollection<Address> mongoCollection;

    @Mock
    private Address address;

    @BeforeEach
    void setUp() {
        underTest = new AddressDao(mongoCollection);
    }

    @Test
    void test_save_shouldWriteAddressesToDatabase() {
        underTest.save(address);
        verify(mongoCollection).insertOne(address);
    }

    @Test
    void getAll() {
    }
}