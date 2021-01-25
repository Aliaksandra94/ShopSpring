package project.moroz.service;

import project.moroz.model.Role;

import java.util.List;

public interface UserProjectService<T> {
    List<T> getList();
    void add(T t);
    void delete(T t);
    void edit(T t);
    T getById(int id);
    Role getRoleById(int id);
    boolean checkUserLogin(String login);
    T checkUserByLoginAndPassword(String login, String pass);
    List<Role> getRoleList();
}
