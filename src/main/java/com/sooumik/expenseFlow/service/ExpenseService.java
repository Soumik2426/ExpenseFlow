package com.sooumik.expenseFlow.service;

import com.sooumik.expenseFlow.dto.request.CreateExpenseRequest;
import com.sooumik.expenseFlow.dto.response.ExpenseResponse;

public interface ExpenseService {

    ExpenseResponse createExpense(CreateExpenseRequest request);

}