package dao;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Profile;
import util.FileUtil;

public class ProfileDao implements GenericDao<Profile> {
    private ObjectMapper objectMapper;

    public ProfileDao(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void save(Profile profile) {
        String FILE_PATH = FileUtil.createJsonFile(profile.getCustomer().getFirstName(), profile.getCustomer().getLastName());
        try {
            objectMapper.writeValue(new File(FILE_PATH), profile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
