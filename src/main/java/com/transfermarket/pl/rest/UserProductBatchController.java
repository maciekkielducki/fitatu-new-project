package com.transfermarket.pl.rest;

import com.transfermarket.pl.service.UserProductBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserProductBatchController {

    private final UserProductBatchService userProductBatchService;

    @GetMapping
    public ResponseEntity getAllUserProductBatch() {
        return new ResponseEntity(userProductBatchService.getAllUserProductBatch(), HttpStatus.OK);
    }

}
