package project.moroz.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import project.moroz.model.Role;

import java.util.List;

public interface UserDAO<T> {
    List<T> getList();
    void add(T t);
    void delete(T t);
    void edit(T t);
    T getById(int id);
    Role getRoleById(int id);
    List<Role> getRoleList();
    T checkUserByLoginAndPassword(String login, String pass);
    boolean checkUserLogin(String login);
}
