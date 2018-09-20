package dao;

public interface GenericDao<T> {
    void save(T t);
}
