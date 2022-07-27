package com.transfermarket.pl.repository;

import com.transfermarket.pl.dto.UserDto;
import com.transfermarket.pl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserById(UUID id);


    void deleteUserById(UUID id);

}
