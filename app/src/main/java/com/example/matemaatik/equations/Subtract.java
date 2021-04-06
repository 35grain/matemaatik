package com.example.matemaatik.equations;

import com.example.matemaatik.equations.Equation;

public class Subtract extends Equation {

    public Subtract(int upperLimit, int lowerLimit) {
        int[] variables = generateVars(upperLimit, lowerLimit);
        variableA = variables[0];
        variableB = variables[1];
        eqSymbol = '-';
    }

    @Override
    int[] generateVars(int upperLimit, int lowerLimit) {
        int b = (int) (Math.random() * (upperLimit - lowerLimit)) + lowerLimit;
        int a = b + (int) (Math.random() * (upperLimit - lowerLimit)) + lowerLimit;
        return new int[]{a, b};
    }

    @Override
    int getSolution() {
        return variableA - variableB;
    }
}
