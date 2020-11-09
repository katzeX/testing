package com.internship;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestConstants {

    public static final long ID_ONE = 1L;
    public static final double DISCOUNT_PERCENTAGE_ONE = 10;

    public static final LocalDate DISCOUNT_ONE_START_DATE = LocalDate.of(2020, 9, 3);
    public static final LocalDate DISCOUNT_ONE_END_DATE = LocalDate.of(2020, 9, 13);

    public static final double PRICE_ONE = 150;
    public static final double PRICE_TWO = 0;
    public static final int AVAILABLE_BOOKS = 10;
    public static final double DISCOUNT_PRICE_ONE = 135;

    public static final String BOOK_TITLE_ONE = "Frankenstein";
    public static final String LANGUAGE = "English";
    public static final String VOUCHER_TITLE_ONE = "Voucher";

    public static final String AUTH_USER_EMAIL = "test@domain.com";
    public static final String AUTH_USER_PASSWORD = "welcome1";

    public static String createURLWithPort(String url, int port) {
        return "http://localhost:" + port + url;
    }
}
