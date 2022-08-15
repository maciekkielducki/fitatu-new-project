package com.transfermarket.pl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.transfermarket.pl.entity.Meal;
import com.transfermarket.pl.entity.Product;
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
}
