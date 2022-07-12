package com.transfermarket.pl.dto;

import com.transfermarket.pl.entity.Meal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBatchDto {
    private Meal meal;
    private int grams;
    private UUID productId;
}
