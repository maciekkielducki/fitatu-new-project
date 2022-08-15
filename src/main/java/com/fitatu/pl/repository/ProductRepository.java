package com.fitatu.pl.repository;

import com.fitatu.pl.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {


    void deleteProductById(UUID id);

    Product findProductByNameStartingWith(String name);

}
