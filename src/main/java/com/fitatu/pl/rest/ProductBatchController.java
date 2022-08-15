package com.fitatu.pl.rest;


import com.fitatu.pl.dto.CreateProductBatchRequest;
import com.fitatu.pl.entity.ProductBatch;
import com.fitatu.pl.mapper.ProductBatchMapper;
import com.fitatu.pl.service.ProductBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        ProductBatch newProductBatch = productBatchService.addProductBatch(request);
        return new ResponseEntity<>(newProductBatch, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProductBatchById (@PathVariable UUID id) {
        productBatchService.deleteProductBatchById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
