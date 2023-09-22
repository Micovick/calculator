package io.loanpro.calculator.domain.service;

import io.loanpro.calculator.application.CalculatorContext;
import io.loanpro.calculator.domain.model.Operation;
import io.loanpro.calculator.domain.model.OperationType;
import io.loanpro.calculator.domain.model.Record;
import io.loanpro.calculator.domain.model.User;
import io.loanpro.calculator.domain.strategy.*;
import io.loanpro.calculator.infrastructure.repository.OperationRepository;
import io.loanpro.calculator.infrastructure.repository.RecordRepository;
import io.loanpro.calculator.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OperationService {
    private final UserRepository userRepository;
    private final OperationRepository operationRepository;
    private final RecordRepository recordRepository;
    private final CalculatorContext calculatorContext;

    public OperationService(UserRepository userRepository, OperationRepository operationRepository, RecordRepository recordRepository, CalculatorContext calculatorContext) {
        this.userRepository = userRepository;
        this.operationRepository = operationRepository;
        this.recordRepository = recordRepository;
        this.calculatorContext = calculatorContext;
    }

    @Transactional
    public double performOperation(Long userId, OperationType operation, double a, double b) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Operation operationRecord = getOperation(operation);
        double cost = operationRecord.getCost();
        if (user.getBalance() < cost) {
            throw new IllegalStateException("Insufficient balance");
        }

        calculatorContext.setStrategy(getStrategy(operation));
        double result = calculatorContext.executeStrategy(a, b);

        double balance = user.getBalance() - cost;
        user.setBalance(balance);
        userRepository.save(user);

        Record record = new Record()
                .setOperation(operationRecord)
                .setUser(user)
                .setAmount(cost)
                .setUserBalance(balance)
                .setOperationResponse(result)
                .setDate(LocalDateTime.now());

        recordRepository.save(record);

        return result;
    }


    private Operation getOperation(OperationType operationType) {
        return operationRepository.findOperationByType(operationType)
                .orElseThrow(() -> new IllegalArgumentException("Operation not found"));
    }

    private CalculationStrategy getStrategy(OperationType operation) {
        switch (operation) {
            case ADDITION:
                return new AdditionStrategy();
            case MULTIPLICATION:
                return new MultiplicationStrategy();
            case DIVISION:
                return new DivisionStrategy();
            case SUBTRACTION:
                return new SubtractionStrategy();
            case SQUARE_ROOT:
                return new SquareRootStrategy();
            //TODO Create Random String Generator Strategy
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}
