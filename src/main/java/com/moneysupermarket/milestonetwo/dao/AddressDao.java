package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.models.Address;
import com.mongodb.Block;
import com.mongodb.client.MongoCollection;

import java.util.LinkedList;
import java.util.List;

public class AddressDao implements GenericDao<Address> {
    private List<Address> addresses = new LinkedList<>();

    private MongoCollection<Address> mongoCollection;

    public AddressDao(MongoCollection<Address> mongoCollection) {
        this.mongoCollection = mongoCollection;
    }

    public void save(Address address) {
        mongoCollection.insertOne(address);
    }

    public List<Address> getAll() {
        mongoCollection.find().forEach((Block<? super Address>) address -> addresses.add(address));
        return addresses;
    }
}
