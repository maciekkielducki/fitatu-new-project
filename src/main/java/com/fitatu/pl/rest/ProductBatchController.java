package com.transfermarket.pl.rest;


import com.transfermarket.pl.dto.CreateProductBatchRequest;
import com.transfermarket.pl.entity.ProductBatch;
import com.transfermarket.pl.mapper.ProductBatchMapper;
import com.transfermarket.pl.service.ProductBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-batch")
@RequiredArgsConstructor
public class ProductBatchController {

    private final ProductBatchService productBatchService;
    private final ProductBatchMapper productBatchMapper;

    @GetMapping("/{userId}/users")
    public ResponseEntity<Object> findAllByUser(@PathVariable UUID userId) {
        List<ProductBatch> productBatchList = productBatchService.findAllByUser(userId);
        return new ResponseEntity<>(productBatchMapper.mapToProductBatchDtos(productBatchList), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductBatch> addProductBatch(@RequestBody CreateProductBatchRequest request) {
        ProductBatch mappedProductBatch = productBatchMapper.mapToNewProductBatch(request);
        ProductBatch newProductBatch = productBatchService.addProductBatch(mappedProductBatch);
        return new ResponseEntity<>(newProductBatch, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProductBatchById (@PathVariable UUID id) {
        productBatchService.deleteProductBatchById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
