package com.transfermarket.pl.repository;

import com.transfermarket.pl.entity.ProductBatch;
import com.transfermarket.pl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductBatchRepository extends JpaRepository<ProductBatch, UUID> {

    void deleteProductById(UUID id);

    List<ProductBatch> findAllByUser(User user);
}
