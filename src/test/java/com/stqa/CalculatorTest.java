package com.stqa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calc = new Calculator();

    // ---- Standard cases ----
    @Test
    void tc01_add() {
        assertEquals(20, calc.add(10, 5));
    }

    @Test
    void tc02_subtract() {
        assertEquals(5, calc.subtract(10, 5));
    }

    @Test
    void tc03_multiply() {
        assertEquals(50, calc.multiply(10, 5));
    }

    @Test
    void tc04_divide() {
        assertEquals(5.0, calc.divide(10, 2));
    }

    // ---- Extended cases ----
    @Test
    void tc05_divideByZeroThrows() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class, () -> calc.divide(10, 0));
        assertEquals("Cannot divide by zero", ex.getMessage());
    }

    @Test
    void tc06_addWithZero() {
        assertEquals(10, calc.add(10, 0));
    }

    @Test
    void tc07_subtractEqualNumbers() {
        assertEquals(0, calc.subtract(10, 10));
    }

    @Test
    void tc08_multiplyByZero() {
        assertEquals(0, calc.multiply(10, 0));
    }

    @Test
    void tc09_divideNegative() {
        assertEquals(-5.0, calc.divide(-10, 2));
    }
}
