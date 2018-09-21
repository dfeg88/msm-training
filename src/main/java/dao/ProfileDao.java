package dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Profile;

public class ProfileDao implements GenericDao<Profile> {
    private ObjectMapper objectMapper;

    public ProfileDao(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void save(Profile profile) {
        
    }

}
