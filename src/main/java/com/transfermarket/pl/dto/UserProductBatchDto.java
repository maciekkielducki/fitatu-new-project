package com.transfermarket.pl.dto;


import com.transfermarket.pl.entity.Meal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProductBatchDto {

    private UUID id;
    private String username;

    private int grams;
    private int calories;
    private int proteins;
    private int carbs;
    private int fats;
}
