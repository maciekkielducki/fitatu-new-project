package com.transfermarket.pl.repository;

import com.transfermarket.pl.entity.ProductBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductBatchRepository extends JpaRepository<ProductBatch, UUID> {
    void deleteProductById(UUID id);
}
