package com.transfermarket.pl.dto;

import com.transfermarket.pl.entity.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateUserRequest {

    private String username;
    private Sex sex;
    private double weight;
    private double height;
    private Instant dateOfBirth;
    private String password;
}
