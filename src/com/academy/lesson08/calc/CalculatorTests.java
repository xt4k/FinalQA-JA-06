package com.academy.lesson08.calc;

public class CalculatorTests {
    public static void main(String[] args) {
        Caclulator calc = new Caclulator();
        try {
            calc.div(1.0, 0);
            assert false;
        } catch (Exception exc) {
            assert exc instanceof DivisionByZero;
        }
    }
}
