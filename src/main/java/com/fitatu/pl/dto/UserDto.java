package com.fitatu.pl.dto;

import com.fitatu.pl.entity.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDto {

    private UUID id;
    private String username;
    private Sex sex;
    private double weight;
    private double height;
    private Instant dateOfBirth;
    private double bmr;
}
