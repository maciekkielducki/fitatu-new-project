package com.transfermarket.pl.mapper;
import com.transfermarket.pl.dto.CreateProductBatchRequest;
import com.transfermarket.pl.dto.ProductBatchDto;
import com.transfermarket.pl.dto.ProductDto;
import com.transfermarket.pl.entity.ProductBatch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductBatchMapper {

    private final ProductMapper productMapper;
    private ProductDto ProductDto;

    public ProductBatch mapToNewProductBatch(CreateProductBatchRequest dto) {
        return ProductBatch.builder()
                .id(UUID.randomUUID())
                .meal(dto.getMeal())
                .grams(dto.getGrams())
                .build();
    }

    public ProductBatchDto mapToProductBatchDto(ProductBatch entity) {
        var product :ProductDto = productMapper.mapToProductDto(entity.getProduct());
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
