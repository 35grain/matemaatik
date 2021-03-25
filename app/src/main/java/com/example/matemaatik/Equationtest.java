package com.example.matemaatik;

import java.util.ArrayList;
import java.util.List;

public class Equationtest {
    public static void main(String[] args) {
        Subtract lahuta = new Subtract(0,10);
        Add liida = new Add(0,5);
        Multiply korruta = new Multiply(5,10);
        Divide jaga = new Divide(0,10);

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
