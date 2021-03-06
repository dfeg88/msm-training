package com.moneysupermarket.milestonetwo;

import com.moneysupermarket.milestonetwo.dao.AddressDao;
import com.moneysupermarket.milestonetwo.dao.CsvDao;
import com.moneysupermarket.milestonetwo.dao.ProfileDao;
import com.moneysupermarket.milestonetwo.data.MongoConnection;
import com.moneysupermarket.milestonetwo.data.MongoProperties;
import com.moneysupermarket.milestonetwo.models.Address;
import com.moneysupermarket.milestonetwo.models.Profile;
import com.moneysupermarket.milestonetwo.util.FileUtil;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Entry {

    private static final String COLLECTION_ADDRESSES = "addresses";
    private static final String COLLECTION_PROFILES = "profiles";
    private static final String DATABASE = "msm-training";
    private static final String CSV_MOCK_DATA = "MOCK_DATA";

    public static void main (String[] args) throws IOException, InterruptedException {
        FileUtil fileUtil = new FileUtil();

        MongoProperties mongoProperties = MongoProperties.builder()
            .collection(COLLECTION_PROFILES)
            .database(DATABASE)
            .build();

        MongoConnection mongoConnection = new MongoConnection(mongoProperties);
        mongoConnection.dropDatabase(); // for testing purposes
        Thread.sleep(1000);

        // Part One
        ProfileDao profileDao = new ProfileDao(mongoConnection.createProfileCollection());
        CsvDao csvDao = new CsvDao(new FileReader(fileUtil.getCsvFile(CSV_MOCK_DATA)));
        List<Profile> profilesFromCSV = csvDao.getProfilesFromCSV();
        profilesFromCSV.forEach(profileDao::save);

        // Write to console
        System.out.println(profileDao.getAll()); // Part Two
        System.out.println(profileDao.getLastTenProfiles()); // Part Three
        System.out.println(profileDao.getProfilesByCarMake("BMW")); // Part Four
        System.out.println(profileDao.getProfilesByPostcode("sk11")); // Part Five

        // Part Six
        mongoProperties.setCollection(COLLECTION_ADDRESSES);
        AddressDao addressDao = new AddressDao(mongoConnection.createAddressCollection());
        List<Profile> mongoProfiles = profileDao.getAll();

        mongoProfiles.forEach(profile -> addressDao.save(profile.getAddress()));

        Thread.sleep(1000);
        mongoConnection.getMongoClient().close();
    }
}
