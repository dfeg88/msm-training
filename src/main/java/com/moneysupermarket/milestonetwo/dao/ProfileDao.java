package com.moneysupermarket.milestonetwo.dao;

import static com.mongodb.client.model.Filters.eq;

import java.util.Optional;

import org.bson.Document;

import com.moneysupermarket.milestonetwo.data.MongoConnection;
import com.moneysupermarket.milestonetwo.models.Profile;
import com.mongodb.Block;

public class ProfileDao implements GenericDao<Profile> {
    private static final String DOCUMENT_PROFILE = "profile";

    private Block<Document> printBlock = document -> System.out.println(document.toJson());

    private MongoConnection mongoConnection;

    public ProfileDao(MongoConnection mongoConnection) {
        this.mongoConnection = mongoConnection;
    }

    public void save(Profile profile) {
        mongoConnection.getDbCollection().insertOne(new Document(DOCUMENT_PROFILE, profile));
    }

    public void getAll() {
        mongoConnection.getDbCollection().find().forEach(printBlock);
    }

    public void getLastTenProfiles() {
        mongoConnection.getDbCollection().find().skip((int) mongoConnection.getDbCollection().countDocuments() - 10).forEach(printBlock);
    }

    public void getProfilesWithCarMakeBmw() {
        mongoConnection.getDbCollection().find(eq("profile.car.make", "BMW")).forEach(printBlock);
    }

    public Optional<Profile> get(String id) {
        return null;
    }

    public void delete(Profile profile) {

    }

}
