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
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
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
                                @RequestParam("productImage") MultipartFile productImage,
                                Model model) {

        // สร้างชื่อไฟล์ใหม่
        String fileName = System.currentTimeMillis() + "_" + StringUtils.cleanPath(productImage.getOriginalFilename());

        // บันทึกไฟล์ลงในที่เก็บไฟล์ (ตัวอย่าง: uploads/)
        try {
            String uploadDir = "src/main/resources/productImg/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            try (InputStream inputStream = productImage.getInputStream()) {
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                // จัดการข้อผิดพลาด
                e.printStackTrace();
            }
        } catch (IOException e) {
            // จัดการข้อผิดพลาด
            e.printStackTrace();
        }


        productService.createProduct(product, productImage);

        return "redirect:/products";
    }


}