package project.moroz.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "basket_items")
public class BasketItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basketItem_id")
    private int basketItemID;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;
    private int quantity;

    @ManyToMany(mappedBy = "basketItems", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Product> products;

    public BasketItem() {
    }

    public BasketItem(Basket basket, int quantity, List<Product> products) {
        this.basket = basket;
        this.quantity = quantity;
        this.products = products;
    }

    public int getBasketItemID() {
        return basketItemID;
    }

    public void setBasketItemID(int basketItemID) {
        this.basketItemID = basketItemID;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
