package com.moneysupermarket.milestonetwo;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.moneysupermarket.milestonetwo.data.MongoConnection;
import com.moneysupermarket.milestonetwo.data.MongoProperties;
import com.moneysupermarket.milestonetwo.dao.CsvDao;
import com.moneysupermarket.milestonetwo.dao.ProfileDao;
import com.moneysupermarket.milestonetwo.models.Profile;
import com.moneysupermarket.milestonetwo.util.FileUtil;

public class Entry {

    public static void main (String[] args) throws IOException {
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
        System.out.println("*****************************  PART TWO ***************************");
        profileDao.getAll();
        System.out.println("*************************  END OF PART TWO ***********************");

        mongoConnection.getMongoClient().close();
    }
}
