package com.transfermarket.pl.service;


import com.transfermarket.pl.entity.ProductInfo;
import com.transfermarket.pl.repository.ProductInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductInfoService {

    private final ProductInfoRepository productInfoRepository;

    public ProductInfo addProductInfo(int calories, int proteins, int carbs, int fats) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCalories(calories);
        productInfo.setProteins(proteins);
        productInfo.setCarbs(carbs);
        productInfo.setFats(fats);
        return productInfoRepository.save(productInfo);
    }
}
