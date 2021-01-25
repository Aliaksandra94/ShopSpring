package project.moroz.repository;

import project.moroz.model.Role;
import project.moroz.model.User;

import java.util.List;

public interface DAO<T> {
    List<T> getList();
    T save(T t);
    void add(T t);
    void delete(T t);
    void edit(T t);
    T getById(int id);
}
