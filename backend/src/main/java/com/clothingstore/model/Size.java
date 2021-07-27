package com.clothingstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "Size")
@Table(name = "size")
@Data
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sizeTag;

    private String measurements;

    private Integer quantity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    public Size() {}

    public Size(String sizeTag, String measurements, Integer quantity, Product product) {
        this.sizeTag = sizeTag;
        this.measurements = measurements;
        this.quantity = quantity;
        this.product = product;
    }
}
