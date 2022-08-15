package com.transfermarket.pl.repository;


import com.transfermarket.pl.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, UUID> {
}
