
package com.calculator;

public class Calculator {

    // Addition method
    public int add(int a, int b) {
        return a + b;
    }

    // Subtraction method
    public int subtract(int a, int b) {
        return a - b;
    }

    // Main method
    public static void main(String[] args) {

        Calculator calc = new Calculator();

        System.out.println("--- Simple Calculator  ---");

        System.out.println("Addition (5 + 3): " + calc.add(5, 3));

        System.out.println("Subtraction (5 - 3): " + calc.subtract(5, 3));

        System.out.println("Experiment 8 - Jenkins CI Automation");
    }
}
