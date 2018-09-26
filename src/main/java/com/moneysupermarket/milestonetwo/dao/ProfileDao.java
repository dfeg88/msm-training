package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.models.Profile;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;

public class ProfileDao implements GenericDao<Profile> {

    private Block<Profile> printBlock = document -> System.out.println(document);
    private List<Profile> profiles = new LinkedList<>();

    private MongoCollection<Profile> mongoCollection;

    public ProfileDao(MongoCollection mongoCollection) {
        this.mongoCollection = mongoCollection;
    }

    public void save(Profile profile) {
        mongoCollection.insertOne(profile);
    }

    public List<Profile> getAll() {
        getDocumentIterable().forEach((Block<? super Profile>) profile -> profiles.add(profile));
        return profiles;
    }

    private FindIterable<Profile> getDocumentIterable() {
        return mongoCollection.find();
    }

    public List<Profile> getLastTenProfiles() {
        getDocumentIterable().skip((int) mongoCollection.countDocuments() - 10).forEach((Block<? super Profile>) profile -> profiles.add(profile));
        return profiles;
    }

    public List<Profile> getProfilesByCarMake(String carMake) {
        mongoCollection.find(eq("car.make", carMake)).forEach((Block<? super Profile>) profile -> profiles.add(profile));
        return profiles;
    }

    public List<Profile> getProfilesByPostcode(String postcode) {
        mongoCollection.find(regex("address.postcode", "^(?i)"+Pattern.quote(postcode))).forEach((Block<? super Profile>) profile -> profiles.add(profile));
        return profiles;
    }

}
