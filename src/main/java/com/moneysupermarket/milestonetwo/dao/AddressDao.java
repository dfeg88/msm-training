package com.moneysupermarket.milestonetwo.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moneysupermarket.milestonetwo.data.MongoConnection;
import com.moneysupermarket.milestonetwo.models.Address;
import com.mongodb.Block;
import org.bson.Document;

import java.io.IOException;

import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;

public class AddressDao {
    private static final String ADDRESS_PROFILE = "address";
    private Block<Document> printBlock = document -> System.out.println(document.toJson());

    private MongoConnection mongoConnection;

    public AddressDao(MongoConnection mongoConnection) {
        this.mongoConnection = mongoConnection;
    }

    public void saveAddress(Document document) throws IOException {
        Address address = new ObjectMapper()
            .readValue(document.get("profile", Document.class)
                .get("address", Document.class).toJson(), Address.class);

        mongoConnection.getDbCollection().insertOne(
            new Document(ADDRESS_PROFILE, address)
        );
    }

    public void getAddresses() {
        mongoConnection.getDbCollection()
            .find()
            .projection(fields(include("address")))
            .forEach(printBlock);
    }

}
