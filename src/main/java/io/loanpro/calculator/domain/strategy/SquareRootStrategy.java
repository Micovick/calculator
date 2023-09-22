package io.loanpro.calculator.domain.strategy;

public class SquareRootStrategy implements CalculationStrategy {
    @Override
    public double calculate(double a, double b) {
        return Math.sqrt(a);
    }
}
