package dao;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Profile;

public class ProfileDao implements GenericDao<Profile> {
    private ObjectMapper objectMapper;

    public ProfileDao(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void save(Profile profile) {
        
    }

    public List<Profile> getAll() {
        return null;
    }

    public Optional<Profile> get(String id) {
        return null;
    }

    public void delete(Profile profile) {

    }

}
