package com.example.demo.controller;

import com.example.demo.model.ProductRequest;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "product-all";
    }

    @GetMapping("/add")
    public String getProductForm(Model model) {
        return "product-add";
    }

    @PostMapping("/add")
    public String createProduct(@ModelAttribute ProductRequest product,
                                Model model) {
        productService.createProduct(product);

        return "redirect:/products";
    }


}
