package com.transfermarket.pl.dto;


import com.transfermarket.pl.entity.Meal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProductBatchDto {

    private long id;
    private String username;

    private int grams;
    private int calories;
    private int proteins;
    private int carbs;
    private int fats;
}
