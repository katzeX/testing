package com.internship;

import com.internship.utils.FakerUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestConstants {

    public static final long ID_ONE = 1L;
    public static final long AUTHOR_ID = FakerUtils.randomNumber();
    public static final double DISCOUNT_PERCENTAGE_ONE = 10;

    public static final LocalDate DISCOUNT_ONE_START_DATE = LocalDate.of(2020, 9, 3);
    public static final LocalDate DISCOUNT_ONE_END_DATE = LocalDate.of(2020, 9, 13);

    public static final double PRICE_ONE = 150;
    public static final double PRICE_TWO = 0;
    public static final double PRICE_THREE = PRICE_ONE + 1;
    public static final int AVAILABLE_BOOKS = 10;
    public static final double DISCOUNT_PRICE_ONE = 135;

    public static final String BOOK_TITLE_ONE = "Frankenstein";
    public static final String LANGUAGE = "English";
    public static final String VOUCHER_TITLE_ONE = "Voucher";

    public static final String AUTH_USER_EMAIL = "test@domain.com";
    public static final String AUTH_USER_PASSWORD = "welcome1";
    public static final String AUTH_USER_PASSWORD1 = "$2a$10$AjHGc4x3Nez/p4ZpvFDWeO6FGxee/cVqj5KHHnHfuLnIOzC5ag4fm";


    public static final String AUTHOR_FIRST_NAME = "Author first name";
    public static final String AUTHOR_LAST_NAME = "Author last name";

    public static final String BOOK_WITH_ID_NOT_FOUND = "Book with ID=[1] wasn't found";
    public static final String USER_FIRST_NAME_1 = "Mary";
    public static final String USER_FIRST_NAME_2 = "Alex";
    public static final String USER_LAST_NAME_1 = "Shelley";
    public static final String USER_LAST_NAME_2 = "Smith";

    public static String createURLWithPort(String url, int port) {
        return "http://localhost:" + port + url;
    }
}
