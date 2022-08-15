package com.fitatu.pl.rest;

import com.fitatu.pl.dto.UpdateUserRequest;
import com.fitatu.pl.dto.CreateUserRequest;
import com.fitatu.pl.entity.User;
import com.fitatu.pl.mapper.UserMapper;
import com.fitatu.pl.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity(userMapper.mapToUserDtos(userList), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById (@PathVariable("id") UUID id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(userMapper.mapToUserDto(user), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody CreateUserRequest request) {
        User mappedUser = userMapper.mapToNewUser(request);
        User newUser = userService.addNewUser(
                mappedUser,
                request.getSex(),
                request.getWeight(),
                request.getHeight(),
                Instant.now());
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserRequest request, @PathVariable UUID id) {
        User mappedUser = userMapper.mapToUpdateUser(request, id);
        User updateUser = userService.updateUser(mappedUser, id);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable UUID id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
