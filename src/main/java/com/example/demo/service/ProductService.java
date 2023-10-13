package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.model.ProductRequest;
import com.example.demo.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public void createProduct(ProductRequest request, MultipartFile productImage) {
        Product record = modelMapper.map(request, Product.class);

        String fileName = StringUtils.cleanPath(productImage.getOriginalFilename());
        record.setProductImage(fileName);

        productRepository.save(record);
    }


}