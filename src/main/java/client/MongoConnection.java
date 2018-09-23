package client;

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
import dao.CsvDao;
import models.Profile;
import util.FileUtil;

public class MongoConnection {

    private static final String collectionName = "profiles";

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
            documents.add(new Document(collectionName, profile));
        });

        collection.insertMany(documents);

        mongoClient.close();

    }

}
