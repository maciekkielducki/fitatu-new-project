package com.transfermarket.pl.mapper;
import com.transfermarket.pl.dto.CreateUserRequest;
import com.transfermarket.pl.dto.UpdateUserRequest;
import com.transfermarket.pl.dto.UserDto;
import com.transfermarket.pl.entity.User;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserMapper {

    public User mapToNewUser(CreateUserRequest dto) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setDateOfBirth(Instant.now());
        return user;
    }

    public User mapToUpdateUser(UpdateUserRequest dto, UUID id) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setDateOfBirth(Instant.now());
        return user;
    }

    public UserDto mapToUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setHeight(user.getUserInfo().getHeight());
        dto.setWeight(user.getUserInfo().getWeight());
        dto.setSex(user.getUserInfo().getSex());
        dto.setDateOfBirth(user.getDateOfBirth());
        dto.setBmr(user.getUserInfo().getBmr());
        return dto;
    }

    public List<UserDto> mapToUserDtos(List<User> entities) {
        List<UserDto> dtos = new ArrayList<>();

        entities.forEach(entity -> dtos.add(mapToUserDto(entity)));

        return dtos;
    }
}
