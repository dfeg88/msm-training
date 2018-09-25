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
import java.util.List;

public class Entry {

    public static void main (String[] args) throws IOException, InterruptedException {
        FileUtil fileUtil = new FileUtil();
        // M2-Part One
        MongoProperties mongoProperties = MongoProperties.builder()
            .collection("profiles")
            .database("msm-training")
            .build();

        MongoConnection mongoConnection = new MongoConnection(mongoProperties, Profile.class);
        ProfileDao profileDao = new ProfileDao(mongoConnection);
        CsvDao csvDao = new CsvDao(new FileReader(fileUtil.getCsvFile("MOCK_DATA")));
        List<Profile> profiles = csvDao.getProfilesFromCSV();

        profiles.forEach(profile -> {
            profileDao.save(profile);
        });

//         M2-Part Two
        System.out.println("*****************************  PART TWO ***************************\n\n");
        profileDao.getAll();
        System.out.println("\n\n*************************  END OF PART TWO ***********************\n\n");

//         M2-Part Three
        System.out.println("\n\n*****************************  PART THREE ***************************");
        profileDao.getLastTenProfiles();
        System.out.println("\n\n*************************  END OF PART THREE ***********************\n\n");

//         M2 - Part Four
        System.out.println("*****************************  PART FOUR ***************************\n\n");
        profileDao.getProfilesByCarMake("BMW");
        System.out.println("\n\n*************************  END OF PART FOUR ***********************\n\n");

//         M2 - Part Five
        System.out.println("*****************************  PART FIVE ***************************\n\n");
        profileDao.getProfilesByPostcode("SK11");
        System.out.println("\n\n*************************  END OF PART FIVE ***********************\n\n");

        // M2 - Part Six
        mongoProperties = MongoProperties.builder()
            .collection("addresses")
            .database("msm-training")
            .build();

        mongoConnection = new MongoConnection(mongoProperties, Address.class);
        AddressDao addressDao = new AddressDao(mongoConnection);

        FindIterable<Profile> addresses = profileDao.getDocumentIterable();
        addresses.forEach((Block<? super Profile>) document -> addressDao.save(document.getAddress()));

        Thread.sleep(1000);
        mongoConnection.getMongoClient().close();
    }
}
