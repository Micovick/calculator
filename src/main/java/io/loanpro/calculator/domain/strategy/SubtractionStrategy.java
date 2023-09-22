package io.loanpro.calculator.domain.strategy;

public class SubtractionStrategy implements CalculationStrategy {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }
}
