package ee.ratr.matemaatik.equations;

public class Random {
    private Equation equation;

    public Random(int upperLimit, int lowerLimit) {
        int choice = (int) (Math.random() * 5);
        switch (choice) {
            case 0:
                this.equation = new Add(upperLimit, lowerLimit);
                break;
            case 1:
                this.equation = new Subtract(upperLimit, lowerLimit);
                break;
            case 2:
                this.equation = new Multiply(upperLimit, lowerLimit);
                break;
            case 3:
                this.equation = new Divide(upperLimit, lowerLimit);
                break;
            case 4:
                this.equation = new Exponentiate(upperLimit, lowerLimit);
        }
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
