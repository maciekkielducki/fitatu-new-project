package com.fitatu.pl.service;


import com.fitatu.pl.entity.Sex;
import com.fitatu.pl.entity.UserInfo;
import com.fitatu.pl.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;

    public UserInfo addUserInfo(Sex sex, double weight, double height, Instant dateOfBirth) {
        UserInfo userInfo = new UserInfo();
        userInfo.setSex(sex);
        userInfo.setWeight(weight);
        userInfo.setHeight(height);
        userInfo.setBmr(calculateBmr(sex, weight, height, dateOfBirth));
        return userInfoRepository.save(userInfo);
    }

    private double calculateBmr(Sex sex, double weight, double height, Instant dateOfBirth) {
        int baseParameter = sex == Sex.MALE ? 66 : 655;
        int weightParameter = sex == Sex.MALE ? 14 : 9;
        int heightParameter = sex == Sex.MALE ? 5 : 2;
        int ageParameter = sex == Sex.MALE ? 7 : 5;

        int age = (int) Instant.now().until(dateOfBirth, ChronoUnit.DAYS) / 365;

        return (baseParameter + (weightParameter * weight) +
                    (heightParameter * height)) -
                    (ageParameter * age);
    }
}
