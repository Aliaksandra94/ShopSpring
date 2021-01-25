package project.moroz.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.moroz.model.Basket;
import project.moroz.model.BasketItem;
import project.moroz.model.Product;
import project.moroz.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BasketDAOImpl implements BasketDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Basket> getList() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Basket ").list();
    }

    @Override
    public void addProductToBasket(int userID, int productID, int count) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, userID);
        if (user.getBasket().getBasketItems().stream().anyMatch(basketItem -> basketItem.getProducts().get(0).getProductID() == productID)) {
            BasketItem basketItem = user.getBasket().getBasketItems().stream().filter(s -> s.getProducts().get(0).getProductID() == productID).collect(Collectors.toList()).get(0);
            int firstCountInBasketItem = basketItem.getQuantity();
            basketItem.setQuantity(firstCountInBasketItem + count);
            session.update(basketItem);
            session.getTransaction().commit();
        } else {
            Product product = session.get(Product.class, productID);
            List<Product> productList = new ArrayList<>();
            productList.add(product);
            BasketItem basketItem = new BasketItem(user.getBasket(), count, productList);
            session.save(basketItem);
            product.getBasketItems().add(basketItem);
            session.update(product);
            user.getBasket().getBasketItems().add(basketItem);
            session.update(user);
        }
    }

    @Override
    public void updateCount(User u, int productID, int count) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, u.getUserID());
        BasketItem basketItem = user.getBasket().getBasketItems().stream().filter(s -> s.getProducts().get(0).getProductID() == productID).collect(Collectors.toList()).get(0);
        basketItem.setQuantity(count);
        session.update(basketItem);
    }

    @Override
    public void deleteItem(User u, int productID) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, u.getUserID());
        BasketItem basketItem = user.getBasket().getBasketItems().stream().filter(s -> s.getProducts().get(0).getProductID() == productID).collect(Collectors.toList()).get(0);
        Product product = session.get(Product.class, productID);
        BasketItem productItem = product.getBasketItems().stream().filter(s -> s.getProducts().get(0).getProductID() == productID).collect(Collectors.toList()).get(0);
        session.delete(basketItem);
        session.delete(productItem);
    }

    @Override
    public List<BasketItem> returnListOfProductsInBasket(User u) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, u.getUserID());
        List<Product> list = new ArrayList<>();
        user.getBasket().getBasketItems().stream().forEach(basketItem -> list.add(basketItem.getProducts().get(0)));
        session.getTransaction().commit();
        return user.getBasket().getBasketItems();
    }
}
