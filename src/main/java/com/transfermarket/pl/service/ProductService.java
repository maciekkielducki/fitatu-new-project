package com.transfermarket.pl.service;

import com.transfermarket.pl.dto.ProductDto;
import com.transfermarket.pl.entity.Product;
import com.transfermarket.pl.entity.ProductInfo;
import com.transfermarket.pl.exception.ProductNotFoundException;
import com.transfermarket.pl.repository.ProductRepository;
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

    public Product addNewProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());

        ProductInfo productInfo = new ProductInfo();
        productInfo.setFats(productDto.getFats());
        productInfo.setCalories(productDto.getCalories());
        productInfo.setCarbs(productDto.getCarbs());
        productInfo.setProteins(productDto.getProteins());

        product.setProductInfo(productInfoService.addProductInfo(productInfo));

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
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    public Product findByNameStartingWith(String name) {
        return productRepository.findProductByNameStartingWith(name);
    }

}
