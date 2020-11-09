package com.internship.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void multiplyWithValidData() {
        assertEquals(4, calculator.multiply(2, 2));
        assertEquals(4, calculator.multiply(1, 4));
    }

    @ParameterizedTest
    @ValueSource(ints = {-35, 71, 123, Integer.MAX_VALUE})
    public void shouldBeOdd(int number) {
        System.out.println(number);
        assertTrue(calculator.isOdd(number));

        assertThat(calculator.isOdd(number)).isEqualTo(true);
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before each test");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After each test");
    }
}
