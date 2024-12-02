package com.example.calculatrice.ModelTest;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.example.calculatrice.Model.CalculatorModel;

class CalculatorModelTest {

    @Test
    void testAddition() {
        CalculatorModel calculator = new CalculatorModel();
        assertEquals(5.0, calculator.calculate(2.0, 3.0, "+"));
    }

    @Test
    void testSubtraction() {
        CalculatorModel calculator = new CalculatorModel();
        assertEquals(-1.0, calculator.calculate(2.0, 3.0, "-"));
    }

    @Test
    void testMultiplication() {
        CalculatorModel calculator = new CalculatorModel();
        assertEquals(6.0, calculator.calculate(2.0, 3.0, "x"));
    }

    @Test
    void testDivision() {
        CalculatorModel calculator = new CalculatorModel();
        assertEquals(2.0, calculator.calculate(6.0, 3.0, "÷"));
    }

    @Test
    void testDivisionByZero() {
        CalculatorModel calculator = new CalculatorModel();
        assertEquals(Double.NaN, calculator.calculate(6.0, 0.0, "÷"));
    }

    @Test
    void testInvalidOperator() {
        CalculatorModel calculator = new CalculatorModel();
        assertEquals(0.0, calculator.calculate(6.0, 3.0, "%"));
    }

    @Test
    void testNegativeSignPositiveValue() {
        CalculatorModel calculator = new CalculatorModel();
        assertEquals(-5.0, calculator.NegativeSign(5.0));
    }

    @Test
    void testNegativeSignNegativeValue() {
        CalculatorModel calculator = new CalculatorModel();
        assertEquals(5.0, calculator.NegativeSign(-5.0));
    }

    @Test
    void testNegativeSignZero() {
        CalculatorModel calculator = new CalculatorModel();
        assertEquals(0.0, calculator.NegativeSign(0.0));
    }

    @Test
    void testPerCent() {
        CalculatorModel calculator = new CalculatorModel();
        assertEquals(0.5, calculator.PerCent(50.0));
    }

    @Test
    void testPerCentZero() {
        CalculatorModel calculator = new CalculatorModel();
        assertEquals(0.0, calculator.PerCent(0.0));
    }
}
