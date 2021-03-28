package com.example.matemaatik;

public class EquationTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Equation tehe = new Random(15, 3).getEquation();
            System.out.println("Tehe: " + tehe.toString());
            System.out.println("Vastus: " + tehe.getSolution() + "\n");
        }
    }
}
