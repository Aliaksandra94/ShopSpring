package project.moroz.model;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;
import project.moroz.model.annotation.TypeInt;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "users", uniqueConstraints={@UniqueConstraint(columnNames ={"user_id","login"})})
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    @Column(name = "name")
    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 3, max = 15, message = "Name should be between 3 and 15 characters.")
    private String name;
    @Column(name = "login")
    @NotEmpty(message = "Login shouldn't be empty")
    @Size(min = 3, max = 15, message = "Login should be between 3 and 15 characters.")
    private String login;
    @Column(name = "pass")
    @NotEmpty(message = "Age shouldn't be empty")
    @Size(min = 3, max = 10, message = "Pass should be between 3 and 15 characters.")
    private String pass;
    @Column(name = "age")
    @TypeInt(message = "Age should be a number")
    @Min(value = 10, message = "Age should be more than 10")
    @Max(value = 120, message = "Age should be less than 120")
    private int age;
    @Column(name = "email")
    @NotEmpty(message = "Email shouldn't be empty")
    @Email(message = "Email should be valid")
    private String email;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @Column(name = "discount")
    @Min(value = 1, message = "Discount should be more or equal than 1%")
    @Max(value = 25, message = "Discount should be less or equal than 25%")
    private double discount;
    private String page;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Basket basket;

    public User(String name, String login, String pass, int age, String email, Role role) {
        this.userID = userID;
        this.name = name;
        this.login = login;
        this.pass = pass;
        this.age = age;
        this.email = email;
        this.role = role;
    }

    public User() {
    }

    public Role getRole() {
        return role;
    }

    @Autowired
    public void setRole(Role role) {
        this.role = role;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
