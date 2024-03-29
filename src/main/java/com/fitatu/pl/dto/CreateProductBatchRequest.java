package com.fitatu.pl.dto;

import com.fitatu.pl.entity.Meal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductBatchRequest {
    private UUID userId;
    private Meal meal;
    private int grams;
    private UUID productId;
}
