package project.moroz.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.moroz.model.Product;

import java.util.List;

@Repository
public class ProductDAOImpl implements DAO<Product> {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> getList() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product").list();
    }

    @Override
    public void add(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
    }

    @Override
    public void delete(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
    }

    @Override
    public void edit(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }

    @Override
    public Product getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }
    @Override
    public Product save(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
        return product;
    }
}
