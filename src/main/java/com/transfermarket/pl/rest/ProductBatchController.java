package com.transfermarket.pl.rest;


import com.transfermarket.pl.dto.ProductBatchDto;
import com.transfermarket.pl.entity.ProductBatch;
import com.transfermarket.pl.service.ProductBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/product-batch")
@RequiredArgsConstructor
public class ProductBatchController {

    private final ProductBatchService productBatchService;

    @GetMapping
    public ResponseEntity findAllByUser(@RequestBody ProductBatchDto productBatchDto, @PathVariable UUID userId) {

        return new ResponseEntity<>(productBatchService.findAllByUser(productBatchDto, userId), HttpStatus.OK);
    }

    @PostMapping("{userId}/users")
    public ResponseEntity<ProductBatch> addProductBatch(@RequestBody ProductBatchDto productBatchDto, @PathVariable UUID userId) {

        ProductBatch newProductBatch = productBatchService.addProductBatch(productBatchDto);
        return new ResponseEntity<>(newProductBatch, HttpStatus.CREATED);

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProductBatchById (@PathVariable UUID id) {
        productBatchService.deleteProductBatchById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
