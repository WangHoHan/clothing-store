package com.clothingstore.model;

import javax.persistence.*;

@Entity(name = "Size")
@Table(name = "size")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sizeTag;
    private String measuerements;
    private Integer quantity;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    private Product product;
}
