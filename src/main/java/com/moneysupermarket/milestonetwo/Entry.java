package com.moneysupermarket.milestonetwo;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.bson.Document;

import com.moneysupermarket.milestonetwo.dao.AddressDao;
import com.moneysupermarket.milestonetwo.data.MongoConnection;
import com.moneysupermarket.milestonetwo.data.MongoProperties;
import com.moneysupermarket.milestonetwo.dao.CsvDao;
import com.moneysupermarket.milestonetwo.dao.ProfileDao;
import com.moneysupermarket.milestonetwo.models.Profile;
import com.moneysupermarket.milestonetwo.util.FileUtil;

public class Entry {

    public static void main (String[] args) throws IOException, InterruptedException {
        MongoProperties mongoProperties = MongoProperties.builder()
            .collection("profiles")
            .dataBase("msm-training")
            .build();

        MongoConnection mongoConnection = new MongoConnection(mongoProperties);
        ProfileDao profileDao = new ProfileDao(mongoConnection);
        CsvDao csvDao = new CsvDao(new FileReader(FileUtil.getCsvFile("MOCK_DATA")));
        List<Profile> profiles = csvDao.getProfilesFromCSV();

        // M2-Part One
        profiles.forEach(profile -> {
            profileDao.save(profile);
        });

        // M2-Part Two
//        System.out.println("*****************************  PART TWO ***************************");
//        profileDao.getAll();
//        System.out.println("*************************  END OF PART TWO ***********************");

        // M2-Part Three
//        System.out.println("*****************************  PART THREE ***************************");
//        profileDao.getLastTenProfiles();
//        System.out.println("*************************  END OF PART THREE ***********************");

        // M2 - Part Four
//        System.out.println("*****************************  PART FOUR ***************************\n\n");
//        profileDao.getProfilesByCarMake("BMW");
//        System.out.println("\n\n*************************  END OF PART FOUR ***********************\n\n");

        // M2 - Part Five
//        System.out.println("*****************************  PART FIVE ***************************\n\n");
//        profileDao.getProfilesByPostcode("SK11");
//        System.out.println("\n\n*************************  END OF PART FIVE ***********************\n\n");

        // M2 - Part Six
        mongoProperties = MongoProperties.builder()
            .collection("addresses")
            .dataBase("msm-training")
            .build();

        mongoConnection = new MongoConnection(mongoProperties);
        AddressDao addressDao = new AddressDao(mongoConnection);
        List<Document> documents = profileDao.getAllDocuments();
        documents.forEach(document -> {
            try {
                addressDao.saveAddress(document);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread.sleep(1000);
        mongoConnection.getMongoClient().close();
    }
}
