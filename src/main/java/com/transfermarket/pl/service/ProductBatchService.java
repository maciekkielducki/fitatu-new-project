package com.transfermarket.pl.service;


import com.transfermarket.pl.dto.ProductBatchDto;
import com.transfermarket.pl.entity.Product;
import com.transfermarket.pl.entity.ProductBatch;
import com.transfermarket.pl.repository.ProductBatchRepository;
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


    public List<ProductBatch> getAllProductBatch() {
        return productBatchRepository.findAll();
    }

    public ProductBatch addProductBatch(ProductBatchDto productBatchDto) {
        Product product = productService.findById(productBatchDto.getProductId());

        ProductBatch productBatch = buildNewProductBatch(productBatchDto, product);

        return productBatchRepository.save(productBatch);
    }

    private ProductBatch buildNewProductBatch(ProductBatchDto dto, Product product) {
        return ProductBatch.builder()
                .id(UUID.randomUUID())
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
