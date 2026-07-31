package com.sooumik.expenseFlow.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponse {

    private UUID id;

    private String title;

    private String description;

    private BigDecimal amount;

    private LocalDate expenseDate;

    private UUID userId;

    private UUID categoryId;

    private String categoryName;

    private UUID paymentAccountId;

    private String paymentAccountName;

    private Instant createdAt;

    private Instant updatedAt;
}