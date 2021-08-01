package com.clothingstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Category")
@Table(name = "category",
       uniqueConstraints = {
            @UniqueConstraint(name = "uq_category_name_sub_category", columnNames = {"name", "subCategory"})
       })
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String subCategory;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id.equals(category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subCategory='" + subCategory + '\'' +
                '}';
    }
}
