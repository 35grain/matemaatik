package com.example.matemaatik;

public class Add extends Equation {

    public Add(int upperLimit, int lowerLimit) {
        int[] variables = generateVars(upperLimit, lowerLimit);
        variableA = variables[0];
        variableB = variables[1];
        eqSymbol = '+';
    }

    @Override
    int[] generateVars(int upperLimit, int lowerLimit) {
        int a = (int) (Math.random() * (upperLimit - lowerLimit)) + lowerLimit;
        int b = (int) (Math.random() * (upperLimit - lowerLimit)) + lowerLimit;
        return new int[]{a, b};
    }

    @Override
    int getSolution() {
        return variableA + variableB;
    }
}
