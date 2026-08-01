package com.sooumik.expenseFlow.controller;

import com.sooumik.expenseFlow.common.constants.ApiConstants;
import com.sooumik.expenseFlow.common.constants.ApiMessages;
import com.sooumik.expenseFlow.advice.ApiResponse;
//import com.sooumik.expenseFlow.advice.ResponseBuilder;
import com.sooumik.expenseFlow.dto.request.CreateExpenseRequest;
import com.sooumik.expenseFlow.dto.response.ExpenseResponse;
import com.sooumik.expenseFlow.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstants.API_BASE_PATH+ApiConstants.EXPENSES)
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ApiResponse<ExpenseResponse>> createExpense(@Valid @RequestBody CreateExpenseRequest createExpenseRequest){
        ExpenseResponse response = expenseService.createExpense(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ResponseBuilder.success(
                                ApiMessages.EXPENSE_CREATED,
                                response
                        )
                );
    }
}
