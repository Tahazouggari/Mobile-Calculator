package com.example.calculatrice;

import java.lang.Math;



public class CalculatorViewModelTest {
    public double resultatsfinal;
    public double calculate(double value1, double value2, String operator) {

        switch (operator) {
            case "+":

                return value1 + value2;
            case "-":

                return value1 - value2;
            case "x":

                return value1 * value2;
            case "÷":

                return value2 != 0 ? value1 / value2 : Double.NaN;

            default:
                return 0;
        }
    }
    public double NegativeSign( double value){
        if(value==0){
            return 0;
        }
        return -value;
    }
    public double PerCent( double value){
        return value/100;
    }




}

