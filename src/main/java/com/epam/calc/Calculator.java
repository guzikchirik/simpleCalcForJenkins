package com.epam.calc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    private int precision;

    public Calculator(int precision) {
        this.precision = precision;
    }

    public double add(double a, double b) {
        double aBig = convertToBigDecimal(a);
        double bBig = convertToBigDecimal(b);
        double result = aBig + bBig;
        return result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY
                ? result : convertToBigDecimal(result);
    }

    public double subtract(double a, double b) {
        double aBig = convertToBigDecimal(a);
        double bBig = convertToBigDecimal(b);
        double result = aBig - bBig;
        return result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY
                ? result : convertToBigDecimal(result);
    }

    public double multiply(double a, double b) {
        double aBig = convertToBigDecimal(a);
        double bBig = convertToBigDecimal(b);
        double result = aBig * bBig;
        return result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY
                ? result : convertToBigDecimal(result);
    }

    public double division(double a, double b) {
        if (a < 0 && b == 0) {
            return Double.NEGATIVE_INFINITY;
        } else if (a > 0 && b == 0) {
            return Double.POSITIVE_INFINITY;
        }
        double aBig = convertToBigDecimal(a);
        double bBig = convertToBigDecimal(b);
        double result = aBig / bBig;
        return result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY
                ? result : convertToBigDecimal(result);
    }

    private double convertToBigDecimal(double val) {
        return BigDecimal.valueOf(val)
                .setScale(precision, RoundingMode.HALF_UP)
                .doubleValue();
    }

}
