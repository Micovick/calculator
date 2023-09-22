package io.loanpro.calculator.domain.strategy;

public class MultiplicationStrategy implements CalculationStrategy {
    @Override
    public double calculate(double a, double b) {
        return a * b;
    }
}
