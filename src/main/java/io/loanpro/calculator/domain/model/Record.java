package io.loanpro.calculator.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_id", nullable = false)
    Operation operation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    @Column(nullable = false)
    Double amount;
    @Column(nullable = false)
    Double userBalance;
    @Column(nullable = false)
    Double operationResponse;
    @Column(nullable = false)
    LocalDateTime date;

    public Long getId() {
        return id;
    }

    public Record setId(Long id) {
        this.id = id;
        return this;
    }

    public Operation getOperationId() {
        return operation;
    }

    public Record setOperation(Operation operation) {
        this.operation = operation;
        return this;
    }

    public User getUserId() {
        return user;
    }

    public Record setUser(User user) {
        this.user = user;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Record setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Double getUserBalance() {
        return userBalance;
    }

    public Record setUserBalance(Double userBalance) {
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
