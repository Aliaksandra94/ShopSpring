package project.moroz.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.moroz.model.Role;
import project.moroz.model.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO<User> {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<User> getList() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    @Override
    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @Override
    public void edit(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public Role getRoleById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Role.class, id);
    }

    @Override
    public boolean checkUserLogin(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("select userID from User where login = :login");
        query.setParameter("login", login);
        List list = query.list();
        if (list.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public User checkUserByLoginAndPassword(String login, String pass) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select userID from User where login = :login and pass = :pass");
        query.setParameter("login", login);
        query.setParameter("pass", pass);
        List list = query.list();
        if (list.isEmpty()) {
            return null;
        } else {
            System.out.println(session.get(User.class, (Integer.parseInt(list.get(0).toString()))).toString());
            return session.get(User.class, (Integer.parseInt(list.get(0).toString())));
        }
        //return session.get(User.class, (Integer.parseInt((session.createQuery("select userID from User where login = :login and pass = :pass").list()).get(0).toString())));
    }

    @Override
    public List<Role> getRoleList() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Role ").list();
    }
}
