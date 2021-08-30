package com.clothingstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "User")
@Table(name = "customer")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<ShippingInfo> shippingInfoList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    public User() {}

    public User(String email, String password, String firstName, String lastName, String phoneNumber, AccountType accountType) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
    }

    public void addShippingInfo(ShippingInfo shippingInfo) {
        if (!this.shippingInfoList.contains(shippingInfo)) {
            this.shippingInfoList.add(shippingInfo);
            shippingInfo.setUser(this);
        }
    }

    public void setUserOrder(Order order) {
        if (!this.orders.contains(order)) {
            this.orders.add(order);
            order.setUser(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
