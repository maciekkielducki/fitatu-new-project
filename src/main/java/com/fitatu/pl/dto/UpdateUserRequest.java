package com.fitatu.pl.dto;
import com.fitatu.pl.entity.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    private String username;
    private Sex sex;
    private double weight;
    private double height;
    private Instant dateOfBirth;
    private String password;
}
