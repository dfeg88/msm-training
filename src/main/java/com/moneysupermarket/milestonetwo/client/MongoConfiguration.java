package com.moneysupermarket.milestonetwo.client;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.io.IOException;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MongoConfiguration {
    private static final String DATABASE = "msm-training";
    private static final String COLLECTION = "profiles";

    private MongoClient mongoClient;
    private CodecRegistry pojoCodecRegistry;
    private MongoCollection<Document> dbCollection;
    private MongoDatabase database;

    public MongoConfiguration() throws IOException {
        createMongoClient();
        initPojoCodecRegistry();
        database = mongoClient.getDatabase(DATABASE)
            .withCodecRegistry(pojoCodecRegistry);

        dbCollection = database.getCollection(COLLECTION);
    }

    private void createMongoClient() {
        mongoClient = MongoClients.create();
    }

    private void initPojoCodecRegistry() {
        pojoCodecRegistry =
            fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
    }

}
