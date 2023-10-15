package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue
    private UUID productId;

    private String productName;
    private String productDesc;
    private double productPrice;
    private int productStock;
    private String productImage;

    @ManyToOne
    private Category category;
}