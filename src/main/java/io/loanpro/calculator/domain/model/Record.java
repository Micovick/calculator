package io.loanpro.calculator.domain.model;

import java.time.LocalDateTime;

public class Record {
    Long id;
    Long operationId;
    Long userId;
    Double amount;
    Long userBalance;
    Double operationResponse;
    LocalDateTime date;

    public Long getId() {
        return id;
    }

    public Record setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getOperationId() {
        return operationId;
    }

    public Record setOperationId(Long operationId) {
        this.operationId = operationId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Record setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Record setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Long getUserBalance() {
        return userBalance;
    }

    public Record setUserBalance(Long userBalance) {
        this.userBalance = userBalance;
        return this;
    }

    public Double getOperationResponse() {
        return operationResponse;
    }

    public Record setOperationResponse(Double operationResponse) {
        this.operationResponse = operationResponse;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Record setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }
}
