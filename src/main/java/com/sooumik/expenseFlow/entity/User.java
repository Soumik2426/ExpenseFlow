package com.sooumik.expenseFlow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_user_email",
                        columnNames = "email"
                )
        })
public class User extends BaseEntity {
    @Column(name = "email",
            nullable = false,
            length = 150)
    private String email;

    @Column(name = "password_hash",
            nullable = false,
            length = 255)
    private String passwordHash;

    @Column(name = "name",
            nullable = false,
            length = 100)
    private String name;
}
