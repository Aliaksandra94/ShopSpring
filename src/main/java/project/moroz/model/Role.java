package project.moroz.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleID;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();

    public Role(String name) {
        this.roleID = roleID;
        this.name = name;
    }

    public Role() {
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleID=" + roleID +
                ", name='" + name + '\'' +
                '}';
    }
}
