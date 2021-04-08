package ee.ratr.matemaatik.equations;

public class Multiply extends Equation {

    public Multiply(int upperLimit, int lowerLimit) {
        int[] variables = generateVars(upperLimit, lowerLimit);
        variableA = variables[0];
        variableB = variables[1];
        eqSymbol = 'x';
    }

    @Override
    int[] generateVars(int upperLimit, int lowerLimit) {
        int a = (int) (Math.random() * (upperLimit - lowerLimit)) + lowerLimit;
        int b = (int) (Math.random() * (upperLimit - lowerLimit)) + lowerLimit;
        return new int[]{a, b};
    }

    @Override
    public int getSolution() {
        return variableA * variableB;
    }
}
