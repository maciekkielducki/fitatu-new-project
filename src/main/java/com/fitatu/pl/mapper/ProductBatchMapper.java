package com.fitatu.pl.mapper;
import com.fitatu.pl.entity.ProductBatch;
import com.fitatu.pl.dto.CreateProductBatchRequest;
import com.fitatu.pl.dto.ProductBatchDto;
import com.fitatu.pl.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductBatchMapper {

    private final ProductMapper productMapper;

    public ProductBatchDto mapToProductBatchDto(ProductBatch entity) {
        var product  = productMapper.mapToProductDto(entity.getProduct());
        return ProductBatchDto.builder()
                .product(product)
                .fats(entity.getFats())
                .proteins(entity.getProteins())
                .grams(entity.getGrams())
                .id(entity.getId())
                .calories(entity.getCalories())
                .carbs(entity.getCarbs())
                .meal(entity.getMeal())
                .build();
    }

    public List<ProductBatchDto> mapToProductBatchDtos(List<ProductBatch> entities) {
        return entities.stream().map(this::mapToProductBatchDto).collect(Collectors.toList());
    }
}
