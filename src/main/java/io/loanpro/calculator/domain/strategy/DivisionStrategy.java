package io.loanpro.calculator.domain.strategy;

public class DivisionStrategy implements CalculationStrategy {
    @Override
    public double calculate(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }
}
