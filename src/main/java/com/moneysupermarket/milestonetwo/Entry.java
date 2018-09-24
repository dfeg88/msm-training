package com.moneysupermarket.milestonetwo;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.moneysupermarket.milestonetwo.client.MongoConnection;
import com.moneysupermarket.milestonetwo.dao.CsvDao;
import com.moneysupermarket.milestonetwo.dao.ProfileDao;
import com.moneysupermarket.milestonetwo.models.Profile;
import com.moneysupermarket.milestonetwo.util.FileUtil;

public class Entry {

    public static void main (String[] args) throws IOException {
        MongoConnection mongoConnection = new MongoConnection();
        ProfileDao profileDao = new ProfileDao(mongoConnection);
        CsvDao csvDao = new CsvDao(new FileReader(FileUtil.getCsvFile("MOCK_DATA")));
        List<Profile> profiles = csvDao.getProfilesFromCSV();

        profiles.forEach(profile -> {
            profileDao.save(profile);
        });

        mongoConnection.getMongoClient().close();
    }
}
