package com.clothingstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "ProductInfo")
@Table(name = "product_info")
@Getter
@Setter
public class ProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String collection;

    private String color;

    private String fabrics;

    @OneToMany(mappedBy = "productInfo", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

    private String modelSize;

    private String modelHeight;

    private String modelWeight;

    @OneToOne(mappedBy = "productInfo")
    @JsonBackReference
    private Product product;

    public ProductInfo() {}

    public ProductInfo(String color, String fabrics, String modelSize, String modelHeight, String modelWeight) {
        this.color = color;
        this.fabrics = fabrics;
        this.modelSize = modelSize;
        this.modelHeight = modelHeight;
        this.modelWeight = modelWeight;
    }

    public void setProductImage(Image image) {
        if (!images.contains(image)) {
            images.add(image);
            image.setProductInfo(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfo that = (ProductInfo) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", fabrics='" + fabrics + '\'' +
                ", modelSize='" + modelSize + '\'' +
                ", modelHeight='" + modelHeight + '\'' +
                ", modelWeight='" + modelWeight + '\'' +
                '}';
    }
}
