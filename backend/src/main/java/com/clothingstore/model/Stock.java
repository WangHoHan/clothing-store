package com.clothingstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Stock")
@Table(name = "stock")
@Getter
@Setter
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sizeTag;

    private String measurements;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    public Stock() {}

    public Stock(String sizeTag, String measurements, Integer quantity, Product product) {
        this.sizeTag = sizeTag;
        this.measurements = measurements;
        this.quantity = quantity;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return id.equals(stock.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", sizeTag='" + sizeTag + '\'' +
                ", measurements='" + measurements + '\'' +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
