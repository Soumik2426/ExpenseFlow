package com.sooumik.expenseFlow.controller;

import com.sooumik.expenseFlow.dto.request.CreateExpenseRequest;
import com.sooumik.expenseFlow.dto.request.UpdateExpenseRequest;
import com.sooumik.expenseFlow.dto.response.ExpenseResponse;
import com.sooumik.expenseFlow.service.ExpenseService;
import com.sooumik.expenseFlow.common.constants.ApiConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.API_BASE_PATH + ApiConstants.EXPENSES)
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    //To create an Expense
    @PostMapping
    public ResponseEntity<ExpenseResponse> createExpense(@Valid @RequestBody CreateExpenseRequest request) {
        ExpenseResponse response = expenseService.createExpense(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    //To get an expense by ID
    @GetMapping(ApiConstants.ID)
    public ResponseEntity<ExpenseResponse> getExpenseById(@PathVariable UUID id) {
        ExpenseResponse response = expenseService.getExpenseById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }


    //To get all the expenses
    @GetMapping
    public ResponseEntity<List<ExpenseResponse>> getAllExpenses() {

        List<ExpenseResponse> response = expenseService.getAllExpenses();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    //To update an already existing expense
    @PutMapping(ApiConstants.ID)
    public ResponseEntity<ExpenseResponse> updateExpense(@PathVariable UUID id, @Valid @RequestBody UpdateExpenseRequest request) {

        ExpenseResponse response = expenseService.updateExpense(id, request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    //To delete an already existing expense
    @DeleteMapping(ApiConstants.ID)
    public ResponseEntity<Void> deleteExpense(@PathVariable UUID id) {

        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}