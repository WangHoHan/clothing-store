package com.clothingstore.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Category")
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String subCategory;
    @ManyToMany(mappedBy = "categories")
    private List<Product> products = new ArrayList<>();
}
