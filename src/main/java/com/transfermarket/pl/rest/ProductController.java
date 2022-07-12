package com.transfermarket.pl.rest;

import com.transfermarket.pl.dto.ProductDto;
import com.transfermarket.pl.entity.Product;
import com.transfermarket.pl.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{name}/name")
    public ResponseEntity<Product> findByNameLike(@PathVariable String name) {
        return new ResponseEntity<>(productService.findByNameStartingWith(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto) {
        Product newProduct = productService.addNewProduct(productDto);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable UUID id) {
        Product updateProduct = productService.updateProduct(product, id);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
