package project.moroz.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
    @Column(name = "name")
    @NotEmpty(message = "Name shouldn't be empty")
    private String name;
    @Column(name = "price")
    //@NotEmpty(message = "Price shouldn't be empty")
    @DecimalMin(value = "0.01", message = "Price should be more than 0.01")
    @Max(value = 10000, message = "Price's length should be less than 5 characters")
    private double price;
    @Column(name = "quantity")
    //@NotEmpty(message = "Quantity shouldn't be empty")
    @Min(value = 1, message = "Quantity should be more than 0 and should be integer.")
    private int quantity;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "basket_item_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "basketItem_id"))
    private List<BasketItem> basketItems;
    String page;

    public Product() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
