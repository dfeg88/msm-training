package config;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import models.Address;
import models.Car;
import models.Customer;
import models.Profile;

public abstract class MongoConfig {

    private static final String collectionName = "profiles";

    public static void mongoTestConfig() {
        MongoClient mongoClient = MongoClients.create();

        CodecRegistry pojoCodecRegistry =
            fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoDatabase database = mongoClient.getDatabase("test")
            .withCodecRegistry(pojoCodecRegistry);

        MongoCollection<Document> collection = database.getCollection("profiles");

        Profile profile = new Profile(
            new Address("f", "f", "p", "ggg", "dd"),
            new Customer("dddd", "ggg"),
            new Car("fff", "fff", "gg", 2)
        );

        Document document = new Document();
        document.put(collectionName, profile);

        collection.insertOne(document);
    }

}
