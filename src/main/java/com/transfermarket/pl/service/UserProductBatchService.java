package com.transfermarket.pl.service;


import com.transfermarket.pl.entity.UserProductBatch;
import com.transfermarket.pl.repository.UserProductBatchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserProductBatchService {

    private final UserProductBatchRepository userProductBatchRepository;

    public List<UserProductBatch> getAllUserProductBatch() {
        return userProductBatchRepository.findAll();
    }
}
