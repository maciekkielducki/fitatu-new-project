package com.transfermarket.pl.mapper;
import com.transfermarket.pl.dto.ProductDto;
import com.transfermarket.pl.entity.Product;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ProductMapper {

    public Product mapToNewProduct(ProductDto dto) {
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        return product;
    }

    public Product mapToUpdateProduct(ProductDto dto, UUID id) {
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        return product;
    }

    public ProductDto mapToProductDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setCalories(product.getProductInfo().getCalories());
        dto.setCarbs(product.getProductInfo().getCarbs());
        dto.setFats(product.getProductInfo().getFats());
        dto.setProteins(product.getProductInfo().getProteins());
        dto.setId(product.getId());
        dto.setDescription(product.getDescription());
        dto.setName(product.getName());
        return dto;
    }

    public List<ProductDto> mapToProductDtos(List<Product> entities) {
        List<ProductDto> dtos = new ArrayList<>();

        entities.forEach(entity -> dtos.add(mapToProductDto(entity)));

        return dtos;
    }

}
