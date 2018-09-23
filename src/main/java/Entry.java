import java.io.IOException;

import client.MongoConnection;

public class Entry {

    public static void main (String[] args) throws IOException {
//        ProfileDao profileDao = new ProfileDao(new ObjectMapper());
//        CsvDao csvDao = new CsvDao(new FileReader(FileUtil.getCsvFile("MOCK_DATA")));
//        List<Profile> profiles = csvDao.getProfilesFromCSV();
//        profiles.forEach(profile -> profileDao.save(profile));
        MongoConnection.mongoTestConfig();
    }
}
