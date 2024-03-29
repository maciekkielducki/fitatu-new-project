package com.fitatu.pl.service;

import com.fitatu.pl.entity.User;
import com.fitatu.pl.entity.UserInfo;
import com.fitatu.pl.exception.UserNotFoundException;
import com.fitatu.pl.repository.UserRepository;
import com.fitatu.pl.entity.Sex;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserInfoService userInfoService;
    private final PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addNewUser(User user, Sex sex, double weight, double height, Instant dateOfBirth) {
        UserInfo userInfo = userInfoService.addUserInfo(sex, weight, height, dateOfBirth);
        user.setUserInfo(userInfo);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User by id " + id + " was not found"));
    }

    public User findUserById(UUID id) {
        return userRepository.findUserById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User by id " + id + " was not found"));
    }

    public User updateUser(User user, UUID id) {
        User foundUser = findUserById(id);
        foundUser.setUsername(user.getUsername());
        foundUser.setPassword(user.getPassword());
        return userRepository.save(foundUser);
    }

    public void deleteUser(UUID id)  {
        userRepository.deleteUserById(id);
    }

}
