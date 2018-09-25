package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.data.MongoConnection;
import com.moneysupermarket.milestonetwo.models.Profile;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;

import java.util.Optional;
import java.util.regex.Pattern;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;

public class ProfileDao implements GenericDao<Profile> {

    private Block<Profile> printBlock = document -> System.out.println(document);

    private MongoConnection<Profile> mongoConnection;

    public ProfileDao(MongoConnection mongoConnection) {
        this.mongoConnection = mongoConnection;
    }

    public void save(Profile profile) {
        mongoConnection.getDbCollection().insertOne(profile);
    }

    public void getAll() {
        getDocumentIterable().forEach(printBlock);
    }

    public FindIterable<Profile> getDocumentIterable() {
        return mongoConnection.getDbCollection().find();
    }

    public void getLastTenProfiles() {
        getDocumentIterable().skip((int) mongoConnection.getDbCollection().countDocuments() - 10).forEach(printBlock);
    }

    public void getProfilesByCarMake(String carMake) {
        mongoConnection.getDbCollection().find(eq("car.make", carMake)).forEach(printBlock);
    }

    public void getProfilesByPostcode(String postcode) {
        mongoConnection.getDbCollection().find(regex("address.postcode", "^(?i)"+Pattern.quote(postcode))).forEach(printBlock);
    }

    public Optional<Profile> get(String id) {
        return null;
    }

    public void delete(Profile profile) {

    }

}
