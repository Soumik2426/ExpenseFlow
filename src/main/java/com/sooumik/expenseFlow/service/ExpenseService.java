package com.sooumik.expenseFlow.service;

import com.sooumik.expenseFlow.dto.request.CreateExpenseRequest;
import com.sooumik.expenseFlow.dto.response.ExpenseResponse;

import java.util.List;
import java.util.UUID;

public interface ExpenseService {

    ExpenseResponse createExpense(CreateExpenseRequest request);
    ExpenseResponse getExpenseById(UUID expenseId);
    List<ExpenseResponse> getAllExpenses();
}