import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProfileDao implements Dao<Profile> {

    public ProfileDao() {}

    @Override
    public void save(Profile profile) {
        ObjectMapper objectMapper = new ObjectMapper();
        String FILE_PATH = "./files/" + profile.getCustomer().getFirstName() + profile.getCustomer().getLastName() + ".json";

        try {
            objectMapper.writeValue(new File(FILE_PATH), profile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
