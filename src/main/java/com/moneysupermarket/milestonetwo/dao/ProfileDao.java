package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.data.MongoConnection;
import com.moneysupermarket.milestonetwo.models.Profile;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import java.util.Optional;
import java.util.regex.Pattern;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;

public class ProfileDao implements GenericDao<Profile> {

    private Block<Profile> printBlock = document -> System.out.println(document);

    private MongoCollection<Profile> mongoCollection;

    public ProfileDao(MongoCollection mongoCollection) {
        this.mongoCollection = mongoCollection;
    }

    public void save(Profile profile) {
        mongoCollection.insertOne(profile);
    }

    public void getAll() {
        getDocumentIterable().forEach(printBlock);
    }

    public FindIterable<Profile> getDocumentIterable() {
        return mongoCollection.find();
    }

    public void getLastTenProfiles() {
        getDocumentIterable().skip((int) mongoCollection.countDocuments() - 10).forEach(printBlock);
    }

    public void getProfilesByCarMake(String carMake) {
        mongoCollection.find(eq("car.make", carMake)).forEach(printBlock);
    }

    public void getProfilesByPostcode(String postcode) {
        mongoCollection.find(regex("address.postcode", "^(?i)"+Pattern.quote(postcode))).forEach(printBlock);
    }

    public Optional<Profile> get(String id) {
        return null;
    }

    public void delete(Profile profile) {

    }

}
