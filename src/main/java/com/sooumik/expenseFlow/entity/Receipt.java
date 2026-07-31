package com.sooumik.expenseFlow.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "receipts",
        indexes = {
                @Index(name = "idx_receipt_expense", columnList = "expense_id")
        })
public class Receipt extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expense_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_receipt_expense"))
    private Expense expense;

    @Column(name = "storage_path", nullable = false, length = 500)
    private String storagePath;

    @Column(name = "mime_type", nullable = false, length = 100)
    private String mimeType;

    @Column(name = "file_size_bytes", nullable = false)
    private Long fileSizeBytes;
}
