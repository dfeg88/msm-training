package com.moneysupermarket.milestonetwo.dao;

import java.io.IOException;

import org.bson.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moneysupermarket.milestonetwo.data.MongoConnection;
import com.moneysupermarket.milestonetwo.models.Address;

public class AddressDao {
    private static final String ADDRESS_PROFILE = "address";

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

}
