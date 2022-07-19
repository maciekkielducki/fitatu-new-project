package com.transfermarket.pl.service;


import com.transfermarket.pl.dto.UserProductBatchDto;
import com.transfermarket.pl.entity.Product;
import com.transfermarket.pl.entity.ProductBatch;
import com.transfermarket.pl.entity.User;
import com.transfermarket.pl.entity.UserProductBatch;
import com.transfermarket.pl.exception.ProductNotFoundException;
import com.transfermarket.pl.repository.UserProductBatchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserProductBatchService {


    private final ProductBatchService productBatchService;
    private final UserProductBatchRepository userProductBatchRepository;

    public List<UserProductBatch> getAllUserProductBatch() {
        return userProductBatchRepository.findAll();
    }

    public UserProductBatch addNewUserProductBatch(UserProductBatchDto userProductBatchDto) {
        User user = new User();
        user.setUsername(userProductBatchDto.getUsername());

        ProductBatch productBatch = new ProductBatch();
        productBatch.setCalories(userProductBatchDto.getCalories());
        productBatch.setProteins(userProductBatchDto.getProteins());
        productBatch.setProteins(userProductBatchDto.getProteins());
        productBatch.setCarbs(userProductBatchDto.getCarbs());
        productBatch.setFats(userProductBatchDto.getFats());

        UserProductBatch userProductBatch = new UserProductBatch();
        userProductBatch.setUser(userProductBatch.getUser());
        userProductBatch.setProductBatch(userProductBatch.getProductBatch());

        return userProductBatchRepository.save(userProductBatch);
    }

    public UserProductBatch updateUserProductBatch(UserProductBatch userProductBatch, UUID id) {
        UserProductBatch foundUserProductBatch = findById(id);
        foundUserProductBatch.setProductBatch(userProductBatch.getProductBatch());
        foundUserProductBatch.setUser(userProductBatch.getUser());

        return userProductBatchRepository.save(foundUserProductBatch);
    }
    public UserProductBatch findById(UUID id) {
        return userProductBatchRepository.findById(id).orElseThrow(()
                -> new ProductNotFoundException("User and ProductBatch not found"));
    }

    public void deleteUserProductBatch(UUID id) {
        userProductBatchRepository.deleteUserProductBatchById(id);
    }


}
