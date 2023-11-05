package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Data
@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private UUID orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private PurchaseOrder purchaseOrder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int productQuantity;


}
