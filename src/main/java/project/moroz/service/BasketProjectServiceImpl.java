package project.moroz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.moroz.model.Basket;
import project.moroz.model.BasketItem;
import project.moroz.model.User;
import project.moroz.repository.BasketDAO;

import java.util.List;
@Service
public class BasketProjectServiceImpl implements BasketProjectService {
    private BasketDAO basketDAO;

    @Autowired
    public void setBasketDAO(BasketDAO basketDAO) {
        this.basketDAO = basketDAO;
    }

    @Override
    @Transactional
    public List<Basket> getList() {
        return basketDAO.getList();
    }

    @Override
    @Transactional
    public void addProductToBasket(int userID, int productID, int count) {
        basketDAO.addProductToBasket(userID, productID, count);
    }

    @Override
    @Transactional
    public void updateCount(User user, int productID, int count) {
        basketDAO.updateCount(user, productID, count);
    }

    @Override
    @Transactional
    public void deleteItem(User user, int productID) {
        basketDAO.deleteItem(user, productID);
    }

    @Override
    @Transactional
    public List<BasketItem> returnListOfProductsInBasket(User user) {
        return basketDAO.returnListOfProductsInBasket(user);
    }
}
