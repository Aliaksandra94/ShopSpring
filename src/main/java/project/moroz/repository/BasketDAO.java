package project.moroz.repository;

import org.hibernate.Session;
import project.moroz.model.Basket;
import project.moroz.model.BasketItem;
import project.moroz.model.Product;
import project.moroz.model.User;

import java.util.List;
import java.util.stream.Collectors;

public interface BasketDAO {
    List<Basket> getList();
    void addProductToBasket(int userID, int productID, int count);
    void updateCount(User user, int productID, int count);
    void deleteItem(User user, int productID);
    List<BasketItem> returnListOfProductsInBasket(User user);

}
