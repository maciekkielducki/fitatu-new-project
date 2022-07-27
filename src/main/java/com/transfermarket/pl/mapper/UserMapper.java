package com.transfermarket.pl.mapper;

import com.transfermarket.pl.dto.CreateUserRequest;
import com.transfermarket.pl.dto.UserDto;
import com.transfermarket.pl.entity.User;
import liquibase.pro.packaged.U;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class UserMapper {
    public User mapToNewUser(CreateUserRequest dto) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setDateOfBirth(dto.getDateOfBirth());
        return user;
    }
}
