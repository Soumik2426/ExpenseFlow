package com.sooumik.expenseFlow.entity;

import com.sooumik.expenseFlow.common.enums.AccountType;
import com.sooumik.expenseFlow.common.enums.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment_accounts",
        indexes = {
                @Index(
                        name = "idx_payment_account_user",
                        columnList = "user_id"
                )
        })
public class PaymentAccount extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_payment_account_user"))
    private User user;

    @Column(name = "name",
            nullable = false,
            length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type",
            nullable = false,
            length = 30)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency",
            nullable = false,
            length = 10)
    private Currency currency;
}