package com.fitatu.pl.dto;

import com.fitatu.pl.entity.Meal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
