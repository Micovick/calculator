package io.loanpro.calculator.domain.model;

public class Operation {
    Long id;
    OperationType type;
    Long cost;

    public Long getId() {
        return id;
    }

    public Operation setId(Long id) {
        this.id = id;
        return this;
    }

    public OperationType getType() {
        return type;
    }

    public Operation setType(OperationType type) {
        this.type = type;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public Operation setCost(Long cost) {
        this.cost = cost;
        return this;
    }
}
