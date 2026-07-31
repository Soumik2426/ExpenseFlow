package com.sooumik.expenseFlow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expenses",
        indexes = {
                @Index(name = "idx_expense_user", columnList = "user_id"),
                @Index(name = "idx_expense_category", columnList = "category_id"),
                @Index(name="idx_expense_payment_account",columnList="payment_account_id"),
                @Index(name = "idx_expense_date", columnList = "expense_date")
        })
public class Expense extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_expense_user"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_expense_category"))
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_account_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_expense_payment_account"))
    private PaymentAccount paymentAccount;

    @Column(name = "title",
            nullable = false,
            length = 150)
    private String title;

    @Column(name = "description",
            length = 500)
    private String description;

    @Column(name = "amount",
            nullable = false,
            precision = 12,
            scale = 2)
    private BigDecimal amount;

    @Column(name = "expense_date",
            nullable = false)
    private LocalDate expenseDate;
}
