package com.transfermarket.pl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.transfermarket.pl.entity.Meal;
import com.transfermarket.pl.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBatchDto {
    private UUID id;
    private Meal meal;
    private int grams;
    private ProductDto product;
    private int calories;
    private int proteins;
    private int carbs;
    private int fats;
}
