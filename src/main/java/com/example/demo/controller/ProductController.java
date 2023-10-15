package com.example.demo.controller;

import com.example.demo.model.ProductRequest;
import com.example.demo.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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