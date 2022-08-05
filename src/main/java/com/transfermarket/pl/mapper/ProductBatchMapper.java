package com.transfermarket.pl.mapper;
import com.transfermarket.pl.dto.CreateProductBatchRequest;
import com.transfermarket.pl.dto.ProductBatchDto;
import com.transfermarket.pl.entity.ProductBatch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductBatchMapper {

    private final ProductMapper productMapper;

    public ProductBatch mapToNewProductBatch(CreateProductBatchRequest dto) {
        ProductBatch productBatch = new ProductBatch();
        productBatch.setId(UUID.randomUUID());
        productBatch.setMeal(dto.getMeal());
        productBatch.setGrams(dto.getGrams());
        return productBatch;
    }

    public ProductBatchDto mapToProductBatchDto(ProductBatch productBatch) {
        ProductBatchDto dto = new ProductBatchDto();
        dto.setProduct(productMapper.mapToProductDto(productBatch.getProduct()));
        dto.setFats(productBatch.getFats());
        dto.setProteins(productBatch.getProteins());
        dto.setGrams(productBatch.getGrams());
        dto.setId(productBatch.getId());
        dto.setCalories(productBatch.getCalories());
        dto.setCarbs(productBatch.getCarbs());
        dto.setMeal(productBatch.getMeal());

        return dto;
    }

    public List<ProductBatchDto> mapToProductBatchDtos(List<ProductBatch> entities) {
        List<ProductBatchDto> dtos = new ArrayList<>();

        entities.forEach(entity -> dtos.add(mapToProductBatchDto(entity)));

        return dtos;
    }
}
