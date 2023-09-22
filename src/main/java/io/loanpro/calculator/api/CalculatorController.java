package io.loanpro.calculator.api;

import io.loanpro.calculator.application.CalculatorContext;
import io.loanpro.calculator.domain.strategy.AdditionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    private final CalculatorContext context;

    public CalculatorController(CalculatorContext context) {
        this.context = context;
    }

    @GetMapping("/calculate")
    public double calculate(@RequestParam String operation, @RequestParam double a, @RequestParam double b) {
        switch (operation) {
            case "addition":
                context.setStrategy(new AdditionStrategy());
                break;
            // handle other operations...
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
        return context.executeStrategy(a, b);
    }
}
