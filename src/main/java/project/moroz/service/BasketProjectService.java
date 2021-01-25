package project.moroz.service;

import project.moroz.model.Basket;
import project.moroz.model.BasketItem;
import project.moroz.model.User;

import java.util.List;

public interface BasketProjectService {
    List<Basket> getList();
    void addProductToBasket(int userID, int productID, int count);
    void updateCount(User user, int productID, int count);
    void deleteItem(User user, int productID);
    List<BasketItem> returnListOfProductsInBasket(User user);
}
