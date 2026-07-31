package com.sooumik.expenseFlow.entity;

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
@Table(name = "categories",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_category_user_name",
                        columnNames = {"user_id", "name"}
                )
        })
public class Category extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 255)
    private String icon;
}
