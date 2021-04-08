package ee.ratr.matemaatik.equations;

public class Divide extends Equation {

    public Divide(int upperLimit, int lowerLimit) {
        int[] variables = generateVars(upperLimit, lowerLimit);
        variableA = variables[0];
        variableB = variables[1];
        eqSymbol = '÷';
    }

    @Override
    int[] generateVars(int upperLimit, int lowerLimit) {
        int b = (int) (Math.random() * (upperLimit - lowerLimit)) + lowerLimit;
        int a = b * ((int) (Math.random() * (upperLimit - lowerLimit)) + lowerLimit);
        return new int[]{a, b};
    }

    @Override
    public int getSolution() { return variableA / variableB; }
}
