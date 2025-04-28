package com.example.Database_assign.entities;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_ID")
    private Long product_id;

    @Column(name = "Product_name")
    private String product_name;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Quantity_stock")
    private int quantity_stock;

    @Column(name = "Origin")
    private String origin;

    @Column(name = "Functional")
    private String functional;

    @Column(name = "Version")
    private String Version;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price")
    private BigDecimal price;
}
