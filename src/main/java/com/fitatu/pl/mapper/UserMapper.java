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

    public User mapToNewUser(CreateUserRequest dto) {
        return User.builder()
                .id(UUID.randomUUID())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .dateOfBirth(dto.getDateOfBirth()).build();
    }

    public User mapToUpdateUser(UpdateUserRequest dto, UUID id) {
        return User.builder()
                .id(id)
                .username(dto.getUsername())
                .dateOfBirth(dto.getDateOfBirth())
                .build();
    }

    public UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .username(user.getUsername())
                .height(user.getUserInfo().getHeight())
                .weight(user.getUserInfo().getWeight())
                .sex(user.getUserInfo().getSex())
                .dateOfBirth(user.getDateOfBirth())
                .bmr(user.getUserInfo().getBmr())
                .build();
    }

    public List<UserDto> mapToUserDtos(List<User> entities) {
        return entities.stream().map(this::mapToUserDto).collect(Collectors.toList());
    }
}
