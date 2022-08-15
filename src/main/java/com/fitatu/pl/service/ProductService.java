package com.transfermarket.pl.service;

import com.transfermarket.pl.dto.ProductDto;
import com.transfermarket.pl.entity.*;
import com.transfermarket.pl.exception.ProductNotFoundException;
import com.transfermarket.pl.repository.ProductRepository;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.lang.model.element.Name;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {


    private final ProductInfoService productInfoService;
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addNewProduct(Product product, int calories, int proteins, int carbs, int fats) {
        ProductInfo productInfo = productInfoService.addProductInfo(calories, proteins, carbs, fats);
        product.setProductInfo(productInfo);
        return productRepository.save(product);
    }

    public Product updateProduct(Product product, UUID id) {
        Product foundProduct = findById(id);
        foundProduct.setName(product.getName());
        foundProduct.setDescription(product.getDescription());
        return productRepository.save(foundProduct);
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteProductById(id);
    }

    public Product findById(UUID id) {
        return productRepository.findById(id).orElseThrow(()
                -> new ProductNotFoundException("Product not found"));
    }

    public Product findByNameStartingWith(String name) {
        return productRepository.findProductByNameStartingWith(name);
    }

}
