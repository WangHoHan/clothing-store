package com.clothingstore.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity(name = "Product")
@Table(name = "product")
@Getter
@Setter
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

    @OneToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "product_info_id")
    @JsonManagedReference
    private ProductInfo productInfo;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference
    private List<Size> sizes = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "product_categories",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")})
    private Set<Category> categories = new HashSet<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", gender='" + gender + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", productInfo=" + productInfo +
                '}';
    }
}
