package dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {
    void save(T t);

    List<T> getAll();

    Optional<T> get(String id);

    void delete(T t);
}
