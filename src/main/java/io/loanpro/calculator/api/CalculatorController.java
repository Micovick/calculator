package io.loanpro.calculator.api;

import io.loanpro.calculator.domain.model.OperationType;
import io.loanpro.calculator.domain.service.OperationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    private final OperationService operationService;

    public CalculatorController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping("/calculate")
    public double calculate(@RequestParam OperationType operation, @RequestParam double a, @RequestParam double b) {
        return operationService.performOperation(1L, operation, a, b);
    }
}
