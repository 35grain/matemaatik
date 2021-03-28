package com.example.matemaatik;

public class Random {
    private Equation equation;

    public Random(int upperLimit, int lowerLimit) {
        Equation[] equations = new Equation[]{new Add(upperLimit, lowerLimit), new Subtract(upperLimit, lowerLimit),
        new Multiply(upperLimit, lowerLimit), new Divide(upperLimit, lowerLimit)};
        this.equation = equations[(int) (Math.random() * equations.length)];
    }

    public Equation getEquation() {
        return equation;
    }

    int getSolution() {
        return equation.getSolution();
    }

    @Override
    public String toString() {
        return equation.toString();
    }
}
