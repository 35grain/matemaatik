package com.example.matemaatik.equations;

public abstract class Equation {
    protected int variableA;
    protected int variableB;
    protected char eqSymbol;

    // Here variableA must always be in the first position as a parameter in an equation
    abstract int getSolution();

    // Equation specific method for generating appropriate variables for equation
    abstract int[] generateVars(int upperLimit, int lowerLimit);

    // Used for displaying the equation
    @Override
    public String toString() {
        return variableA + " " + eqSymbol + " " + variableB;
    }
}
