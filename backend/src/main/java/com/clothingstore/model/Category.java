package com.clothingstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Category")
@Table(name = "category",
       uniqueConstraints = {
            @UniqueConstraint(name = "uq_category_name_sub_category", columnNames = {"name", "subCategory"})
       })
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String subCategory;

    @ManyToMany(mappedBy = "categories", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    public Category() {}

    public Category(String name, String subCategory) {
        this.name = name;
        this.subCategory = subCategory;
    }

    @PreRemove
    private void removeCategoriesFromProducts() {
        for (Product product: products) {
            product.getCategories().remove(this);
        }
    }
}
