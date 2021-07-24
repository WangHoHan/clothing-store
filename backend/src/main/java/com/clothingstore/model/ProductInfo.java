package com.clothingstore.model;

import javax.persistence.*;

@Entity(name = "ProductInfo")
@Table(name = "product_info")
public class ProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String color;
    private String fabrics;
    private String image;
    private String modelSize;
    private String modelHeight;
    private String modelWeight;
    @OneToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;
}
