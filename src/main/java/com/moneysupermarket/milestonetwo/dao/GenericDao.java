package com.moneysupermarket.milestonetwo.dao;

import java.util.Optional;

public interface GenericDao<T> {
    void save(T t);

    void getAll();

    Optional<T> get(String id);

    void delete(T t);
}
