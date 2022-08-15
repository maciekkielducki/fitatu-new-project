package com.fitatu.pl.service;


import com.fitatu.pl.dto.CreateProductBatchRequest;
import com.fitatu.pl.entity.Product;
import com.fitatu.pl.entity.ProductBatch;
import com.fitatu.pl.entity.User;
import com.fitatu.pl.repository.ProductBatchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductBatchService {

    private final ProductBatchRepository productBatchRepository;
    private final ProductService productService;
    private final UserService userService;


    public List<ProductBatch> findAllByUser(UUID userId) {
        User user = userService.findById(userId);
        return productBatchRepository.findAllByUser(user);
    }

    public ProductBatch addProductBatch(CreateProductBatchRequest createProductBatchRequest) {
        Product product = productService.findById(createProductBatchRequest.getProductId());
        User user = userService.findUserById(createProductBatchRequest.getUserId());
        ProductBatch productBatch = buildNewProductBatch(createProductBatchRequest, product, user);
        return productBatchRepository.save(productBatch);
    }

    private ProductBatch buildNewProductBatch(CreateProductBatchRequest dto, Product product, User user) {
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
