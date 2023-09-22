package io.loanpro.calculator.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    OperationType type;
    @Column(nullable = false)
    Double cost;

    @OneToMany(mappedBy = "operation", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Record> records;

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

    public Double getCost() {
        return cost;
    }

    public Operation setCost(Double cost) {
        this.cost = cost;
        return this;
    }

    public List<Record> getRecords() {
        return records;
    }

    public Operation setRecords(List<Record> records) {
        this.records = records;
        return this;
    }
}
