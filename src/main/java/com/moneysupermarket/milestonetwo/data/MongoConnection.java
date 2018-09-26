package com.moneysupermarket.milestonetwo.data;

import com.moneysupermarket.milestonetwo.models.Address;
import com.moneysupermarket.milestonetwo.models.Profile;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Getter
@Setter
public class MongoConnection<T> {
    private MongoClient mongoClient;
    private CodecRegistry pojoCodecRegistry;
    private MongoCollection<T> dbCollection;
    private MongoDatabase database;
    private MongoProperties mongoProperties;

    public MongoConnection(MongoProperties mongoProperties) {
        mongoClient = MongoClients.create();
        this.mongoProperties = mongoProperties;

        // enable pojo to be passed in to Document object
        pojoCodecRegistry =
            fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        database = mongoClient.getDatabase(mongoProperties.getDatabase())
            .withCodecRegistry(pojoCodecRegistry);
    }

    public MongoCollection<Address> createAddressCollection() {
        return database.getCollection(mongoProperties.getCollection(), Address.class);
    }

    public MongoCollection<Profile> createProfileCollection() {
        return database.getCollection(mongoProperties.getCollection(), Profile.class);
    }

    public void dropDatabase() {
        database.drop();
    }
}
