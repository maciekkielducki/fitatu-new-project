package com.transfermarket.pl.repository;

import com.transfermarket.pl.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {


    void deleteProductById(UUID id);

    Product findProductByNameStartingWith(String name);

}
