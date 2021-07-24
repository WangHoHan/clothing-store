package com.clothingstore.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String gender;
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
}
