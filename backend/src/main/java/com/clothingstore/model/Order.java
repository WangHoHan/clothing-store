package com.clothingstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Order")
@Table(name = "purchase_order")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String state;

    private String tracking;

    private String shippingMethod;

    private String paymentMethod;

    private Double total;

    private Boolean paid;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime placedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "shipping_id")
    private ShippingInfo shippingInfo;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private List<OrderContent> orderContentList = new ArrayList<>();

    public Order() {}

    public Order(String shippingMethod, String paymentMethod, Double total, LocalDateTime placedAt, ShippingInfo shippingInfo) {
        this.shippingMethod = shippingMethod;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.placedAt = placedAt;
        this.shippingInfo = shippingInfo;
    }

    public void addOrderContent(OrderContent orderContent) {
        this.orderContentList.add(orderContent);
        orderContent.setOrder(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", tracking='" + tracking + '\'' +
                ", shippingMethod='" + shippingMethod + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", total=" + total +
                ", paid=" + paid +
                ", placedAt=" + placedAt +
                ", user=" + user +
                ", shippingInfo=" + shippingInfo +
                '}';
    }
}
