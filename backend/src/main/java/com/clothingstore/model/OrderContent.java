package com.clothingstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "OrderContent")
@Table(name = "order_content")
@Getter
@Setter
public class OrderContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String size;

    private Integer quantity;

    public OrderContent() {}

    public OrderContent(Product product, String size, Integer quantity) {
        this.product = product;
        this.size = size;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderContent that = (OrderContent) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OrderContent{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
