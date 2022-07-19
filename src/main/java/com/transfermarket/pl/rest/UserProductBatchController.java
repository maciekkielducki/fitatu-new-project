package com.transfermarket.pl.rest;

import com.transfermarket.pl.dto.UserProductBatchDto;
import com.transfermarket.pl.entity.UserProductBatch;
import com.transfermarket.pl.service.UserProductBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserProductBatchController {

    private final UserProductBatchService userProductBatchService;

    @GetMapping
    public ResponseEntity getAllUserProductBatch() {
        return new ResponseEntity(userProductBatchService.getAllUserProductBatch(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserProductBatch> addNewUserProductBatch(@RequestBody UserProductBatchDto userProductBatchDto) {
        UserProductBatch newUserProductBatch = userProductBatchService.addNewUserProductBatch(userProductBatchDto);
        return new ResponseEntity<>(newUserProductBatch, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProductBatch> updateUserProductBatch(@RequestBody UserProductBatch userProductBatch, @PathVariable UUID id) {
        UserProductBatch updateUserProductBatch = userProductBatchService.updateUserProductBatch(userProductBatch, id);
        return new ResponseEntity<>(updateUserProductBatch, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserProductBatch(@PathVariable UUID id) {
        userProductBatchService.deleteUserProductBatch(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
