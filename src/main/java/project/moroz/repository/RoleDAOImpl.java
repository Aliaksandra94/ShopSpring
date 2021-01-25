package project.moroz.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.moroz.model.Role;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RoleDAOImpl implements DAO<Role> {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Role> getList() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Role").list();
    }

    @Override
    public void add(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(role);
    }

    @Override
    public void delete(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(role);
    }

    @Override
    public void edit(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.update(role);
    }

    @Override
    public Role getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Role.class, id);
    }
    @Override
    public Role save(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(role);
        return role;
    }
}
