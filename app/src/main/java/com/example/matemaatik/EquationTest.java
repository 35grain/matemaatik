package com.example.matemaatik;

import java.util.ArrayList;
import java.util.List;

public class EquationTest {
    public static void main(String[] args) {
        Subtract lahuta = new Subtract(20,2);
        Add liida = new Add(20,2);
        Multiply korruta = new Multiply(15,2);
        Divide jaga = new Divide(20,2);

        List<Equation> tehted = new ArrayList<Equation>();
        tehted.add(lahuta);
        tehted.add(liida);
        tehted.add(korruta);
        tehted.add(jaga);

        for (Equation tehe: tehted) {
            System.out.println("Tehe: " + tehe.toString());
            System.out.println("Vastus: " + tehe.getSolution() + "\n");
        }

    }
}
