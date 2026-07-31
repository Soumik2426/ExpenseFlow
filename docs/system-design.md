erDiagram

    USERS ||--o{ CATEGORIES : creates
    CATEGORIES ||--o{ CATEGORIES : parent_of
    USERS ||--o{ PAYMENT_ACCOUNTS : owns
    USERS ||--o{ EXPENSES : records
    CATEGORIES ||--o{ EXPENSES : classifies
    PAYMENT_ACCOUNTS ||--o{ EXPENSES : funds
    USERS ||--o{ BUDGETS : sets
    CATEGORIES ||--o{ BUDGETS : limits
    EXPENSES ||--o{ RECEIPTS : has

    USERS {
        uuid id PK
        string email
        string password_hash
        string name
        timestamp created_at
        timestamp updated_at
    }

    CATEGORIES {
        uuid id PK
        uuid user_id FK
        uuid parent_category_id FK
        string name
        string icon
        timestamp created_at
        timestamp updated_at
    }

    PAYMENT_ACCOUNTS {
        uuid id PK
        uuid user_id FK
        string name
        string account_type
        string currency
        timestamp created_at
        timestamp updated_at
    }

    EXPENSES {
        uuid id PK
        uuid user_id FK
        uuid category_id FK
        uuid payment_account_id FK
        string title
        string description
        decimal amount
        date expense_date
        timestamp created_at
        timestamp updated_at
    }

    BUDGETS {
        uuid id PK
        uuid user_id FK
        uuid category_id FK
        decimal limit_amount
        string budget_period
        date start_date
        date end_date
        timestamp created_at
        timestamp updated_at
    }

    RECEIPTS {
        uuid id PK
        uuid expense_id FK
        string storage_path
        string mime_type
        int file_size_bytes
        timestamp uploaded_at
    }