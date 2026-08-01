package com.sooumik.expenseFlow.service.impl;

import com.sooumik.expenseFlow.dto.request.CreateExpenseRequest;
import com.sooumik.expenseFlow.dto.response.ExpenseResponse;
import com.sooumik.expenseFlow.entity.Category;
import com.sooumik.expenseFlow.entity.Expense;
import com.sooumik.expenseFlow.entity.PaymentAccount;
import com.sooumik.expenseFlow.entity.User;
import com.sooumik.expenseFlow.mapper.ExpenseMapper;
import com.sooumik.expenseFlow.repository.CategoryRepository;
import com.sooumik.expenseFlow.repository.ExpenseRepository;
import com.sooumik.expenseFlow.repository.PaymentAccountRepository;
import com.sooumik.expenseFlow.repository.UserRepository;
import com.sooumik.expenseFlow.service.ExpenseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PaymentAccountRepository paymentAccountRepository;
    private final ExpenseMapper expenseMapper;

    @Override
    public ExpenseResponse createExpense(CreateExpenseRequest request) {
        User user = getUser(request.getUserId());
        Category category = getCategory(request.getCategoryId());

        PaymentAccount paymentAccount = getPaymentAccount(request.getPaymentAccountId());

        validateOwnership(
                user,
                category,
                paymentAccount
        );

        Expense expense = expenseMapper.toEntity(
                request,
                user,
                category,
                paymentAccount
        );

        Expense savedExpense = expenseRepository.save(expense);
        return expenseMapper.toResponse(savedExpense);
    }

    private User getUser(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
    }

    private Category getCategory(UUID categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found."));
    }

    private PaymentAccount getPaymentAccount(UUID paymentAccountId) {
        return paymentAccountRepository.findById(paymentAccountId)
                .orElseThrow(() -> new EntityNotFoundException("Payment account not found."));
    }

    private void validateOwnership(
            User user,
            Category category,
            PaymentAccount paymentAccount
    ) {

        if (!category.getUser().getId().equals(user.getId())) {
            throw new IllegalArgumentException(
                    "Category does not belong to the user."
            );
        }

        if (!paymentAccount.getUser().getId().equals(user.getId())) {
            throw new IllegalArgumentException(
                    "Payment account does not belong to the user."
            );
        }
    }
}