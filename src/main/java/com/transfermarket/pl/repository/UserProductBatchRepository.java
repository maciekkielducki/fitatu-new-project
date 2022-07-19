package com.transfermarket.pl.repository;

import com.transfermarket.pl.entity.User;
import com.transfermarket.pl.entity.UserProductBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

// UUID ID
@Repository
public interface UserProductBatchRepository extends JpaRepository<UserProductBatch, UUID> {

    void deleteUserProductBatch(UUID id);
}
