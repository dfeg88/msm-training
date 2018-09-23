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

    private MongoClient mongoClient;
    private CodecRegistry pojoCodecRegistry;
    private MongoCollection<Document> dbCollection;

    public MongoConfiguration() throws IOException {
        mongoTestConfig();
    }

    public void mongoTestConfig() throws IOException {
        mongoClient = MongoClients.create();

        pojoCodecRegistry =
            fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoDatabase database = mongoClient.getDatabase("test")
            .withCodecRegistry(pojoCodecRegistry);

        dbCollection = database.getCollection("profiles");
    }

}
