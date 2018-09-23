package com.moneysupermarket.milestonetwo;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.bson.Document;

import com.moneysupermarket.milestonetwo.client.MongoConfiguration;
import com.moneysupermarket.milestonetwo.dao.CsvDao;
import com.moneysupermarket.milestonetwo.models.Profile;
import com.moneysupermarket.milestonetwo.util.FileUtil;

public class Entry {

    private static final String COLLECTION_PROFILE = "profile";


    public static void main (String[] args) throws IOException {
//        ProfileDao profileDao = new ProfileDao(new Document());
//        CsvDao csvDao = new CsvDao(new FileReader(FileUtil.getCsvFile("MOCK_DATA")));
//        List<Profile> profiles = csvDao.getProfilesFromCSV();
//        profiles.forEach(profile -> profileDao.save(profile));
        MongoConfiguration mongoConfiguration = new MongoConfiguration();
        mongoConfiguration.getDbCollection().drop();

        List<Profile> profiles;

        CsvDao csvDao = new CsvDao(new FileReader(FileUtil.getCsvFile("MOCK_DATA")));
        profiles = csvDao.getProfilesFromCSV();

        profiles.forEach(profile -> {
            mongoConfiguration.getDbCollection().insertOne(new Document(COLLECTION_PROFILE, profile));
        });

        mongoConfiguration.getMongoClient().close();
    }
}
