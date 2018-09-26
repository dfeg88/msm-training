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

    private MongoCollection<Profile> mongoCollection;

    public ProfileDao(MongoCollection mongoCollection) {
        this.mongoCollection = mongoCollection;
    }

    public void save(Profile profile) {
        mongoCollection.insertOne(profile);
    }

    public List<Profile> getAll() {
        List<Profile> profiles = new LinkedList<>();
        mongoCollection.find().forEach((Block<? super Profile>) profile -> profiles.add(profile));
        return profiles;
    }

    public List<Profile> getLastTenProfiles() {
        List<Profile> profiles = new LinkedList<>();
        mongoCollection.find().skip((int) mongoCollection.countDocuments() - 10).forEach((Block<? super Profile>) profile -> profiles.add(profile));
        return profiles;
    }

    public List<Profile> getProfilesByCarMake(String carMake) {
        List<Profile> profiles = new LinkedList<>();
        mongoCollection.find(eq("car.make", carMake)).forEach((Block<? super Profile>) profile -> profiles.add(profile));
        return profiles;
    }

    public List<Profile> getProfilesByPostcode(String postcode) {
        List<Profile> profiles = new LinkedList<>();
        mongoCollection.find(regex("address.postcode", "^(?i)"+Pattern.quote(postcode))).forEach((Block<? super Profile>) profile -> profiles.add(profile));
        return profiles;
    }

}
