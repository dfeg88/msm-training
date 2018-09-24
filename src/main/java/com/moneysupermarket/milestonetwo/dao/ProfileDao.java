package com.moneysupermarket.milestonetwo.dao;

import java.util.Optional;

import org.bson.Document;

import com.moneysupermarket.milestonetwo.data.MongoConnection;
import com.moneysupermarket.milestonetwo.models.Profile;
import com.mongodb.Block;

public class ProfileDao implements GenericDao<Profile> {
    private static final String DOCUMENT_PROFILE = "profile";

    private MongoConnection mongoConnection;

    public ProfileDao(MongoConnection mongoConnection) {
        this.mongoConnection = mongoConnection;
    }

    public void save(Profile profile) {
        mongoConnection.getDbCollection().insertOne(new Document(DOCUMENT_PROFILE, profile));
    }

    public void getAll() {
        Block<Document> printBlock = document -> System.out.println(document.toJson());
        mongoConnection.getDbCollection().find().forEach(printBlock);
    }

    public Optional<Profile> get(String id) {
        return null;
    }

    public void delete(Profile profile) {

    }

}
