package project.moroz.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="basket")
public class Basket {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int basketID;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany (mappedBy="basket", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BasketItem> basketItems;

    public Basket() {
    }

    public int getBasketID() {
        return basketID;
    }

    public void setBasketID(int basketID) {
        this.basketID = basketID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }
}
