package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.data.MongoConnection;
import com.moneysupermarket.milestonetwo.models.Address;
import com.moneysupermarket.milestonetwo.models.Profile;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;

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
