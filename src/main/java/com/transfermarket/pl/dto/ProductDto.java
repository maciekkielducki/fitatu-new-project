package com.transfermarket.pl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private UUID id;
    private String name;
    private String description;
    private int calories;
    private int proteins;
    private int carbs;
    private int fats;
}
