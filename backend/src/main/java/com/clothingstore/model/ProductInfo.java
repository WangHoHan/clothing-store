package com.clothingstore.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "ProductInfo")
@Table(name = "product_info")
@Data
public class ProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;

    private String fabrics;

    @Column(nullable = false)
    private String image;

    private String modelSize;

    private String modelHeight;

    private String modelWeight;

    @OneToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductInfo() {}

    public ProductInfo(String color, String fabrics, String image, String modelSize, String modelHeight, String modelWeight, Product product) {
        this.color = color;
        this.fabrics = fabrics;
        this.image = image;
        this.modelSize = modelSize;
        this.modelHeight = modelHeight;
        this.modelWeight = modelWeight;
        this.product = product;
    }
}
