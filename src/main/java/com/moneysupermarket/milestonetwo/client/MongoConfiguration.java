package com.moneysupermarket.milestonetwo.client;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.moneysupermarket.milestonetwo.dao.CsvDao;
import com.moneysupermarket.milestonetwo.models.Profile;
import com.moneysupermarket.milestonetwo.util.FileUtil;

public class MongoConfiguration {

    private static final String COLLECTION_PROFILES = "profiles";

    public static void mongoTestConfig() throws IOException {
        MongoClient mongoClient = MongoClients.create();

        CodecRegistry pojoCodecRegistry =
            fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoDatabase database = mongoClient.getDatabase("test")
            .withCodecRegistry(pojoCodecRegistry);

        MongoCollection<Document> collection = database.getCollection("profiles");
        collection.drop();

        List<Profile> profiles;

        CsvDao csvDao = new CsvDao(new FileReader(FileUtil.getCsvFile("MOCK_DATA")));
        profiles = csvDao.getProfilesFromCSV();

        List<Document> documents = new ArrayList<>();

        profiles.forEach(profile -> {
            documents.add(new Document(COLLECTION_PROFILES, profile));
            System.out.println("Added " + profile.getCustomer().getFirstName() + " " +
                profile.getCustomer().getLastName() + " to DB");
        });

        collection.insertMany(documents);

        mongoClient.close();

    }

}
