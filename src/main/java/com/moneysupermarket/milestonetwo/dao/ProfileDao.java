package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.models.Profile;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;
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
        return mongoCollection
                .find()
                .into(new ArrayList<>());
    }

    public List<Profile> getLastTenProfiles() {
       return mongoCollection
               .find()
               .skip((int) mongoCollection.countDocuments() - 10)
               .into(new ArrayList<>());
    }

    public List<Profile> getProfilesByCarMake(String carMake) {
        return mongoCollection
                .find(eq("car.make", carMake))
                .into(new ArrayList<>());
    }

    public List<Profile> getProfilesByPostcode(String postcode) {
        return mongoCollection
                .find(regex("address.postcode", "^(?i)"+Pattern.quote(postcode)))
                .into(new ArrayList<>());
    }

}
