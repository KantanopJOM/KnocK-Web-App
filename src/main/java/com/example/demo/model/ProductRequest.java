package com.example.demo.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Data
public class ProductRequest {

    private String productName;

    private String productDesc;

    private double productPrice;

    private int productStock;

    private MultipartFile productImage;
}