package com.sooumik.expenseFlow.repository;

import com.sooumik.expenseFlow.entity.PaymentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExpenseRepository extends JpaRepository<PaymentAccount, UUID> {
}
