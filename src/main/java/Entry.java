import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CsvDao;
import dao.ProfileDao;
import models.Profile;
import util.FileUtil;

public class Entry {

    public static void main (String[] args) throws IOException {
        ProfileDao profileDao = new ProfileDao(new ObjectMapper());
        CsvDao csvDao = new CsvDao(new FileReader(FileUtil.getCsvFile("MOCK_DATA")));
        List<Profile> profiles = csvDao.getProfilesFromCSV();
        profiles.forEach(profile -> profileDao.save(profile));
    }
}
