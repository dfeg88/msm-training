import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Entry {

    public static void main (String[] args) throws IOException {
        ProfileDao profileDao = new ProfileDao();
        List<Profile> profiles = new ArrayList<>();
        profileDao.getProfilesFromCSV(profiles);
        profiles.forEach(profile -> profileDao.save(profile));
    }
}
