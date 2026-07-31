package com.sooumik.expenseFlow.mapper;

import com.sooumik.expenseFlow.dto.request.CreateExpenseRequest;
import com.sooumik.expenseFlow.dto.response.ExpenseResponse;
import com.sooumik.expenseFlow.entity.Category;
import com.sooumik.expenseFlow.entity.Expense;
import com.sooumik.expenseFlow.entity.PaymentAccount;
import com.sooumik.expenseFlow.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {

    public Expense toEntity(
            CreateExpenseRequest request,
            User user,
            Category category,
            PaymentAccount paymentAccount
    ) {

        return Expense.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .amount(request.getAmount())
                .expenseDate(request.getExpenseDate())
                .user(user)
                .category(category)
                .paymentAccount(paymentAccount)
                .build();
    }

    public ExpenseResponse toResponse(Expense expense) {
        Category category = expense.getCategory();
        PaymentAccount paymentAccount = expense.getPaymentAccount();
        User user = expense.getUser();

        return ExpenseResponse.builder()
                .id(expense.getId())
                .title(expense.getTitle())
                .description(expense.getDescription())
                .amount(expense.getAmount())
                .expenseDate(expense.getExpenseDate())

                .userId(user.getId())

                .categoryId(category.getId())
                .categoryName(category.getName())

                .paymentAccountId(paymentAccount.getId())
                .paymentAccountName(paymentAccount.getName())

                .createdAt(expense.getCreatedAt())
                .updatedAt(expense.getUpdatedAt())
                .build();
    }
}