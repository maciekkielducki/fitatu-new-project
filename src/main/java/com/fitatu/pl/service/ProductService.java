package com.fitatu.pl.service;

import com.fitatu.pl.entity.Product;
import com.fitatu.pl.entity.ProductInfo;
import com.fitatu.pl.exception.ProductNotFoundException;
import com.fitatu.pl.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
