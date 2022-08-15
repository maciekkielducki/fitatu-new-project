package com.fitatu.pl.mapper;
import com.fitatu.pl.entity.Product;
import com.fitatu.pl.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    public Product mapToNewProduct(ProductDto dto) {
        return Product.builder()
                .id(UUID.randomUUID())
                .name(dto.getName())
                .description(dto.getDescription()).build();
    }

    public Product mapToUpdateProduct(ProductDto dto, UUID id) {
        return Product.builder()
                .id(id)
                .name(dto.getName())
                .description(dto.getDescription()).build();
    }

    public ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .calories(product.getProductInfo().getCalories())
                .carbs(product.getProductInfo().getCarbs())
                .fats(product.getProductInfo().getFats())
                .proteins(product.getProductInfo().getProteins())
                .id(product.getId())
                .description(product.getDescription())
                .name(product.getName()).build();
    }

    public List<ProductDto> mapToProductDtos(List<Product> entities) {
        return entities.stream().map(this::mapToProductDto).collect(Collectors.toList());
    }

}
