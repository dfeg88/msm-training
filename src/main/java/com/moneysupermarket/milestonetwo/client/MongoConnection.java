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
public class MongoConnection {
    private static final String DATABASE = "msm-training";
    private static final String COLLECTION = "profiles";

    private MongoClient mongoClient;
    private CodecRegistry pojoCodecRegistry;
    private MongoCollection<Document> dbCollection;
    private MongoDatabase database;

    public MongoConnection() {
        mongoClient = MongoClients.create();

        // enable pojo to be passed in to Document object
        pojoCodecRegistry =
            fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        database = mongoClient.getDatabase(DATABASE)
            .withCodecRegistry(pojoCodecRegistry);

        dbCollection = database.getCollection(COLLECTION);
        dbCollection.drop(); // while testing milestone two part one
    }
}
