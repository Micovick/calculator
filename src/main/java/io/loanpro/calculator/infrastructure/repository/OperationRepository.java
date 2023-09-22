package io.loanpro.calculator.infrastructure.repository;

import io.loanpro.calculator.domain.model.Operation;
import io.loanpro.calculator.domain.model.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    Optional<Operation> findOperationByType(OperationType operationType);
}
