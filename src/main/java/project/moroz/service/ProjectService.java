package project.moroz.service;

import project.moroz.model.Role;

import java.util.List;

public interface ProjectService<T> {
    List<T> getList();
    void add(T t);
    T save(T t);
    void delete(T t);
    void edit(T t);
    T getById(int id);
}
