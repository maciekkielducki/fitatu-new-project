package com.fitatu.pl.service;


import com.fitatu.pl.entity.ProductInfo;
import com.fitatu.pl.repository.ProductInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
