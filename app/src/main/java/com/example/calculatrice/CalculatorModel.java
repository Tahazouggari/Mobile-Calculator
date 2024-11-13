package com.example.calculatrice;





public class CalculatorModel {

    public double calculate(double value1, double value2, String operator) {
        switch (operator) {
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            case "*":
                return value1 * value2;
            case "/":
                return value2 != 0 ? value1 / value2 : Double.NaN;
            default:
                return 0;
        }
    }
}
// History aftre
