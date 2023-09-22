package io.loanpro.calculator.infrastructure.repository;

import io.loanpro.calculator.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
