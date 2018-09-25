package com.moneysupermarket.milestonetwo.data;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Getter
@Setter
public class MongoConnection {
    private MongoClient mongoClient;
    private CodecRegistry pojoCodecRegistry;
    private MongoCollection<Document> dbCollection;
    private MongoDatabase database;

    public MongoConnection(MongoProperties mongoProperties) {
        mongoClient = MongoClients.create();

        // enable pojo to be passed in to Document object
        pojoCodecRegistry =
            fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        database = mongoClient.getDatabase(mongoProperties.getDataBase())
            .withCodecRegistry(pojoCodecRegistry);

        dbCollection = database.getCollection(mongoProperties.getCollection());
        dbCollection.drop();
    }


}
