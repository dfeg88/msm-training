package com.moneysupermarket.milestonetwo.dao;

import java.util.List;
import java.util.Optional;

import org.bson.Document;

import com.moneysupermarket.milestonetwo.models.Profile;

public class ProfileDao implements GenericDao<Profile> {
    private Document document;

    public ProfileDao(Document document) {
        this.document = document;
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
