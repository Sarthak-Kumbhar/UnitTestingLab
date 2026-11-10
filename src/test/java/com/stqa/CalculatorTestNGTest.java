package com.stqa;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTestNGTest {

    private Calculator calc;

    @BeforeClass
    public void setUp() {
        calc = new Calculator();
    }

    // ---- Standard cases ----
    @Test
    public void tc01_add() {
        assertEquals(calc.add(10, 5), 15);
    }

    @Test
    public void tc02_subtract() {
        assertEquals(calc.subtract(10, 5), 5);
    }

    @Test
    public void tc03_multiply() {
        assertEquals(calc.multiply(10, 5), 50);
    }

    @Test
    public void tc04_divide() {
        assertEquals(calc.divide(10, 2), 5.0);
    }

    // ---- Extended cases ----
    @Test
    public void tc05_divideByZeroThrows() {
        IllegalArgumentException ex = expectThrows(
                IllegalArgumentException.class, () -> calc.divide(10, 0));
        assertEquals(ex.getMessage(), "Cannot divide by zero");
    }

    @Test
    public void tc06_addWithZero() {
        assertEquals(calc.add(10, 0), 10);
    }

    @Test
    public void tc07_subtractEqualNumbers() {
        assertEquals(calc.subtract(10, 10), 0);
    }

    @Test
    public void tc08_multiplyByZero() {
        assertEquals(calc.multiply(10, 0), 0);
    }

    @Test
    public void tc09_divideNegative() {
        assertEquals(calc.divide(-10, 2), -5.0);
    }
}
