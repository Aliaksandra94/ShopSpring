package project.moroz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.moroz.model.Role;
import project.moroz.model.User;
import project.moroz.repository.DAO;
import project.moroz.repository.RoleDAOImpl;
import project.moroz.repository.UserDAOImpl;


import java.util.List;

@Service
public class UserProjectServiceImpl implements UserProjectService<User> {
    private UserDAOImpl userDAO;
    private RoleDAOImpl roleDAO;

    @Autowired
    public void setUserDAO(@Qualifier("userDAOImpl") UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setRoleDAO(@Qualifier("roleDAOImpl") RoleDAOImpl roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional
    public List<User> getList() {
        return userDAO.getList();
    }

    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    @Transactional
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Override
    @Transactional
    public User getById(int id) {
        return (User) userDAO.getById(id);
    }

    @Override
    @Transactional
    public Role getRoleById(int id) {
        return userDAO.getRoleById(id);
    }

    @Override
    @Transactional
    public boolean checkUserLogin(String login) {
        return userDAO.checkUserLogin(login);
    }

    @Override
    @Transactional
    public User checkUserByLoginAndPassword(String login, String pass) {
        return userDAO.checkUserByLoginAndPassword(login, pass);
    }

    @Override
    @Transactional
    public List<Role> getRoleList() {

        return userDAO.getRoleList();
    }
}
