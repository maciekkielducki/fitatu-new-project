package com.transfermarket.pl.mapper;

import com.transfermarket.pl.dto.CreateUserRequest;
import com.transfermarket.pl.dto.ProductBatchDto;
import com.transfermarket.pl.entity.ProductBatch;
import com.transfermarket.pl.entity.User;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class ProductBatchMapper {

    public ProductBatchDto mapToProductBatchDto(ProductBatch entity) {
        ProductBatchDto dto = new ProductBatchDto();
        dto.setProduct(entity.getProduct());
        dto.setFats(entity.getFats());
        dto.setProteins(entity.getProteins());
        dto.setGrams(entity.getGrams());
        dto.setId(entity.getId());
        dto.setCalories(entity.getCalories());
        dto.setCarbs(entity.getCarbs());
        dto.setMeal(entity.getMeal());

        return dto;
    }

    public List<ProductBatchDto> mapToProductBatchDtos(List<ProductBatch> entities) {
        List<ProductBatchDto> dtos = new ArrayList<>();

        entities.forEach(entity -> dtos.add(mapToProductBatchDto(entity)));

        return dtos;
    }
}
