package com.internship.utils;

import com.github.javafaker.Faker;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FakerUtils {

    public static final Faker FAKER = new Faker();

    public static Long randomNumber() {
        return FAKER.number().randomNumber(5, true);
    }

}
