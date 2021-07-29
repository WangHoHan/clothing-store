package com.clothingstore.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

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

    @OneToOne(optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "product_info_id")
    @JsonManagedReference
    private ProductInfo productInfo;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Size> sizes = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "product_categories",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")})
    private List<Category> categories = new ArrayList<>();

    public Product() {}

    public Product(String name, String description, String gender, Double price, Double discount, ProductInfo productInfo) {
        this.name = name;
        this.description = description;
        this.gender = gender;
        this.price = price;
        this.discount = discount;
        this.productInfo = productInfo;
    }

    public void setProductSize(Size size) {
        if (!sizes.contains(size)) {
            sizes.add(size);
            size.setProduct(this);
        }
    }

    public void addCategory(Category category) {
        if (!categories.contains(category)) {
            categories.add(category);
            category.getProducts().add(this);
        }
    }

    public void removeCategory(Category category) {
        if (categories.contains(category)) {
            categories.remove(category);
            category.getProducts().remove(this);
        }
    }
}
