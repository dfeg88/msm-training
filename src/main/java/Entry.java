import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CsvDao;
import dao.ProfileDao;
import models.Profile;

public class Entry {

    public static void main (String[] args) throws IOException {
        ProfileDao profileDao = new ProfileDao(new ObjectMapper());
        CsvDao csvDao = new CsvDao();
        List<Profile> profiles = csvDao.getProfilesFromCSV();
        profiles.forEach(profile -> profileDao.save(profile));
    }
}
