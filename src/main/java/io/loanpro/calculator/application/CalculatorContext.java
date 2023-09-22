package io.loanpro.calculator.application;

import io.loanpro.calculator.domain.strategy.CalculationStrategy;
import org.springframework.stereotype.Component;

@Component
public class CalculatorContext {
    private CalculationStrategy strategy;

    public void setStrategy(CalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(double a, double b) {
        return strategy.calculate(a, b);
    }
}
