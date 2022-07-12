package com.transfermarket.pl.service;

import com.transfermarket.pl.entity.User;
import com.transfermarket.pl.exception.UserNotFoundException;
import com.transfermarket.pl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addNewUser(User user) {
        user.setDateOfBirth(Instant.now());
        return userRepository.save(user);
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
