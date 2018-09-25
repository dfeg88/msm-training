package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.data.MongoConnection;
import com.moneysupermarket.milestonetwo.models.Address;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;

import java.util.Optional;

public class AddressDao implements GenericDao<Address> {
    private Block<Address> printBlock = document -> System.out.println(document);

    private MongoConnection<Address> mongoConnection;

    public AddressDao(MongoConnection mongoConnection) {
        this.mongoConnection = mongoConnection;
    }

    public void save(Address document) {
        mongoConnection.getDbCollection().insertOne(document);
    }

    public void getAll() {
        getAddresses().forEach(printBlock);
    }

    public FindIterable<Address> getAddresses() {
        return mongoConnection.getDbCollection().find();
    }

    public Optional<Address> get(String id) {
        return null;
    }

    public void delete(Address address) {

    }
}
