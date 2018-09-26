package com.moneysupermarket.milestonetwo.dao;

import java.util.List;

public interface GenericDao<T> {
    void save(T t);

    List<T> getAll();
}
