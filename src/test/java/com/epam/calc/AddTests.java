package com.epam.calc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by anton_chyrko on 12/2/20.
 */
public class AddTests {

	@Test
	public void testAdd() {
		Calculator calculator = new Calculator(2);
		double a = 10.1;
		double b = 6.3;
		double result = calculator.add(a, b);
		double expectedResult = 16.4;
		assertThat(String.format("Wrong result of method add (input is %f and %f)", a, b), result, is(expectedResult));
	}

	@Test
	public void testAddPositiveOverload() {
		Calculator calculator = new Calculator(2);
		double a =  Double.MAX_VALUE;
		double b =  Double.MAX_VALUE;
		double result = calculator.add(a, b);
		double expectedResult = Double.POSITIVE_INFINITY;
		assertThat(String.format("Wrong result of method add (input is %f and %f)", a, b), result, is(expectedResult));
	}

	@Test
	public void testAddNegativeOverload() {
		Calculator calculator = new Calculator(2);
		double a =  Double.MAX_VALUE * -1;
		double b =  Double.MAX_VALUE * -1;
		double result = calculator.add(a, b);
		double expectedResult = Double.NEGATIVE_INFINITY;
		assertThat(String.format("Wrong result of method add (input is %f and %f)", a, b), result, is(expectedResult));
	}
}
