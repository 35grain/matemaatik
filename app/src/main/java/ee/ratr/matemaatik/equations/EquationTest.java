package ee.ratr.matemaatik.equations;

public class EquationTest {
    public static void main(String[] args) {
        Equation tehe = new Add(50, 10);
        System.out.println("Tehe: " + tehe.toString());
        System.out.println("Vastus: " + tehe.getSolution() + "\n");
    }
}
