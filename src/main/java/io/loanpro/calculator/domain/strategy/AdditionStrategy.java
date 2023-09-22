package io.loanpro.calculator.domain.strategy;

public class AdditionStrategy implements CalculationStrategy {
    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}
