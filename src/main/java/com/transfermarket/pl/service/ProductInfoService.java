package com.transfermarket.pl.service;


import com.transfermarket.pl.entity.ProductInfo;
import com.transfermarket.pl.repository.ProductInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductInfoService {

    private final ProductInfoRepository productInfoRepository;

    public List<ProductInfo> getAllProductInfo() {
        return productInfoRepository.findAll();
    }

    public ProductInfo addProductInfo(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);

    }


}
