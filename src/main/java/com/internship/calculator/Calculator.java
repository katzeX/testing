package com.internship.calculator;

public class Calculator {

    public double multiply(double multiplier1,
            double multiplier2) {
        return multiplier1 * multiplier2;
    }

    public double divide(double dividend, double divider) {
        return dividend / divider;
    }

    public double subtract(double subtrahend, double subtractor) {
        return subtrahend - subtractor;
    }

    public double add(double addendum1, double addendum2) {
        return addendum1 + addendum2;
    }

    public boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
