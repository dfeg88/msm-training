package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.models.Address;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import java.util.List;

public class AddressDao implements GenericDao<Address> {
    private Block<Address> printBlock = System.out::println;

    private MongoCollection<Address> mongoCollection;

    public AddressDao(MongoCollection<Address> mongoCollection) {
        this.mongoCollection = mongoCollection;
    }

    public void save(Address address) {
        mongoCollection.insertOne(address);
    }

    public List<Address> getAll() {
        getAddresses().forEach(printBlock);
        return null;
    }

    private FindIterable<Address> getAddresses() {
        return mongoCollection.find();
    }
}
