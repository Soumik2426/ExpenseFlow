package com.sooumik.expenseFlow.repository;

import com.sooumik.expenseFlow.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, UUID> {
}
