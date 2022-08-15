package com.fitatu.pl.mapper;
import com.fitatu.pl.dto.CreateUserRequest;
import com.fitatu.pl.dto.UpdateUserRequest;
import com.fitatu.pl.dto.UserDto;
import com.fitatu.pl.entity.User;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    //todo builder

    public User mapToNewUser(CreateUserRequest dto) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setDateOfBirth(dto.getDateOfBirth());
        return user;
    }

    public User mapToUpdateUser(UpdateUserRequest dto, UUID id) {
        User user = new User();
        user.setId(id);
        user.setUsername(dto.getUsername());
        user.setDateOfBirth(dto.getDateOfBirth());
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
        return entities.stream().map(this::mapToUserDto).collect(Collectors.toList());
    }
}
