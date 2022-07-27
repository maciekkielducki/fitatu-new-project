package com.transfermarket.pl.service;


import com.transfermarket.pl.dto.ProductBatchDto;
import com.transfermarket.pl.dto.UserDto;
import com.transfermarket.pl.entity.Product;
import com.transfermarket.pl.entity.ProductBatch;
import com.transfermarket.pl.entity.ProductInfo;
import com.transfermarket.pl.entity.User;
import com.transfermarket.pl.repository.ProductBatchRepository;
import com.transfermarket.pl.repository.ProductRepository;
import com.transfermarket.pl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductBatchService {

    private final ProductBatchRepository productBatchRepository;
    private final ProductService productService;
    private final UserService userService;


    public List<ProductBatch> findAllByUser(ProductBatchDto productBatchDto, UUID userId) {

        User user = userService.findById(userId);

        return productBatchRepository.findAllByUser(user);
    }

    public ProductBatch addProductBatch(ProductBatchDto productBatchDto) {

        Product product = productService.findById(productBatchDto.getProductId());

        User user = userService.findUserById(productBatchDto.getUserId());

        ProductBatch productBatch = buildNewProductBatch(productBatchDto, product, user);


        return productBatchRepository.save(productBatch);
    }

    private ProductBatch buildNewProductBatch(ProductBatchDto dto, Product product, User user) {
        return ProductBatch.builder()
                .id(UUID.randomUUID())
                .user(user)
                .product(product)
                .grams(dto.getGrams())
                .calories(product.getProductInfo().getCalories() * dto.getGrams() / 100)
                .carbs(product.getProductInfo().getCarbs() * dto.getGrams() / 100)
                .fats(product.getProductInfo().getFats() * dto.getGrams() / 100)
                .proteins(product.getProductInfo().getProteins() * dto.getGrams() / 100)
                .meal(dto.getMeal())
                .build();
    }

    public void deleteProductBatchById(UUID id) {
        productBatchRepository.deleteProductById(id);
    }





}
