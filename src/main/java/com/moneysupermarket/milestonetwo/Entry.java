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

    public static void main (String[] args) throws IOException, InterruptedException {
        FileUtil fileUtil = new FileUtil();
        MongoProperties mongoProperties = MongoProperties.builder()
            .collection("profiles")
            .database("msm-training")
            .build();

        MongoConnection mongoConnection = new MongoConnection(mongoProperties);
        mongoConnection.dropDatabase();
        ProfileDao profileDao = new ProfileDao(mongoConnection.createProfileCollection());
        CsvDao csvDao = new CsvDao(new FileReader(fileUtil.getCsvFile("MOCK_DATA")));
        List<Profile> profilesFromCSV = csvDao.getProfilesFromCSV();

        profilesFromCSV.forEach(profile -> {
            profileDao.save(profile);
        });

        System.out.println("***************************** PART TWO ***************************\n\n");
        System.out.println(profileDao.getAll());
        System.out.println("\n\n*********************  END OF PART TWO ***********************\n\n");

        System.out.println("\n\n************************* PART THREE ***************************");
        System.out.println(profileDao.getLastTenProfiles());
        System.out.println("\n\n********************** END OF PART THREE ***********************\n\n");

        System.out.println("**************************** PART FOUR ***************************\n\n");
        System.out.println(profileDao.getProfilesByCarMake("BMW"));
        System.out.println("\n\n*********************** END OF PART FOUR ***********************\n\n");

        System.out.println("****************************  PART FIVE ***************************\n\n");
        System.out.println(profileDao.getProfilesByPostcode("SK11"));
        System.out.println("\n\n*********************  END OF PART FIVE ***********************\n\n");

        mongoProperties = MongoProperties.builder()
            .collection("addresses")
            .database("msm-training")
            .build();

        mongoConnection = new MongoConnection(mongoProperties);
        AddressDao addressDao = new AddressDao(mongoConnection.createAddressCollection());

        List<Profile> mongoProfiles = new LinkedList<>();
        mongoProfiles.forEach(profile -> addressDao.save(profile.getAddress()));

        Thread.sleep(1000);
        mongoConnection.getMongoClient().close();
    }
}
