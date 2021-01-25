package project.moroz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import project.moroz.model.Role;
import project.moroz.repository.DAO;

import java.util.List;

public class RoleProjectServiceImpl implements ProjectService<Role> {
    private DAO roleDAO;

    @Autowired
    public void setRoleDAO(@Qualifier("roleDAOImpl") DAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional
    public List<Role> getList() {
        return roleDAO.getList();
    }

    @Override
    @Transactional
    public void add(Role role) {
        roleDAO.add(role);
    }

    @Override
    @Transactional
    public void delete(Role role) {
        roleDAO.delete(role);
    }

    @Override
    @Transactional
    public void edit(Role role) {
        roleDAO.edit(role);
    }

    @Override
    @Transactional
    public Role getById(int id) {
        return (Role)roleDAO.getById(id);
    }

    @Override
    @Transactional
    public Role save(Role role) {
        roleDAO.save(role);
        return role;
    }
}
