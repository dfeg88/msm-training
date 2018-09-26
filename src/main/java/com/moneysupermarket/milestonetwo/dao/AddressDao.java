package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.models.Address;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import java.util.Optional;

public class AddressDao implements GenericDao<Address> {
    private Block<Address> printBlock = document -> System.out.println(document);

    private MongoCollection<Address> mongoCollection;

    public AddressDao(MongoCollection<Address> mongoCollection) {
        this.mongoCollection = mongoCollection;
    }

    public void save(Address address) {
        mongoCollection.insertOne(address);
    }

    public void getAll() {
        getAddresses().forEach(printBlock);
    }

    private FindIterable<Address> getAddresses() {
        return mongoCollection.find();
    }

    public Optional<Address> get(String id) {
        return null;
    }

    public void delete(Address address) {

    }
}
