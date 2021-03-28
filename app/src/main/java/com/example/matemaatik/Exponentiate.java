package com.example.matemaatik;

public class Exponentiate extends Equation {
    public Exponentiate(int upperLimit, int lowerLimit) {
        int[] variables = generateVars(upperLimit, lowerLimit);
        variableA = variables[0];
        variableB = variables[1];
        if (variableB == 2) eqSymbol = '\u00b2';
        if (variableB == 3) eqSymbol = '\u00b3';
    }

    @Override
    int getSolution() {
        return (int) Math.pow(variableA, variableB);
    }

    @Override
    int[] generateVars(int upperLimit, int lowerLimit) {
        // Limits scaled down due to fast increase in complexity
        int b = (int) (Math.random() * (4 - 2)) + 2;
        double scale = 0.5;
        if (b == 3) scale = 0.2;
        int a = (int) ((Math.random() * (upperLimit * scale - lowerLimit * scale)) + lowerLimit * scale);
        return new int[]{a, b};
    }

    @Override
    public String toString() {
        return "" + variableA + eqSymbol;
    }
}
