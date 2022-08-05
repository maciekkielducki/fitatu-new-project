package com.transfermarket.pl.rest;

import com.transfermarket.pl.dto.ProductDto;
import com.transfermarket.pl.entity.Product;
import com.transfermarket.pl.mapper.ProductMapper;
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
    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productList = productService.getAllProducts();
        return new ResponseEntity(productMapper.mapToProductDtos(productList), HttpStatus.OK);
    }

    @GetMapping("/{name}/name")
    public ResponseEntity<Object> findByNameLike(@PathVariable String name) {
        Product productList = productService.findByNameStartingWith(name);
        return new ResponseEntity<>(productMapper.mapToProductDto(productList), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto) {
        Product mappedProduct = productMapper.mapToNewProduct(productDto);
        Product newProduct = productService.addNewProduct(
                mappedProduct,
                productDto.getCalories(),
                productDto.getProteins(),
                productDto.getCarbs(),
                productDto.getFats());
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDto productDto, @PathVariable UUID id) {
        Product mappedProduct = productMapper.mapToUpdateProduct(productDto, id);
        Product updateProduct = productService.updateProduct(mappedProduct, id);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
