package com.clothingstore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Product")
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String gender;

    @Column(nullable = false)
    private Double price;

    private Double discount;

    @OneToOne(mappedBy = "product")
    private ProductInfo productInfo;

    @OneToMany(mappedBy = "product")
    private List<Size> sizes = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "product_categories",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")})
    private List<Category> categories = new ArrayList<>();

    public Product() {}

    public Product(String name, String description, String gender, Double price, Double discount) {
        this.name = name;
        this.description = description;
        this.gender = gender;
        this.price = price;
        this.discount = discount;
    }
}
