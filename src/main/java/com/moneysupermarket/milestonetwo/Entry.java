package com.moneysupermarket.milestonetwo;

import java.io.IOException;

import com.moneysupermarket.milestonetwo.client.MongoConfiguration;

public class Entry {

    public static void main (String[] args) throws IOException {
//        ProfileDao profileDao = new ProfileDao(new Document());
//        CsvDao csvDao = new CsvDao(new FileReader(FileUtil.getCsvFile("MOCK_DATA")));
//        List<Profile> profiles = csvDao.getProfilesFromCSV();
//        profiles.forEach(profile -> profileDao.save(profile));
        MongoConfiguration.mongoTestConfig();
    }
}
