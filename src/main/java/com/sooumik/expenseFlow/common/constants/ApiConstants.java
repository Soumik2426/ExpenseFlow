package com.sooumik.expenseFlow.common.constants;

public final class ApiConstants {

    private ApiConstants() {
    }

    //Just name of API endpoints
    public static final String API_BASE_PATH = "/api/v1";
    public static final String EXPENSES = "/expenses";
    public static final String GET_EXPENSES = "/getexpenses";
    public static final String CATEGORIES = "/categories";
    public static final String BUDGETS = "/budgets";
    public static final String PAYMENT_ACCOUNTS = "/payment-accounts";
    public static final String RECEIPTS = "/receipts";

    // Endpoints with Path Variables
    public static final String ID = "/{id}";

    // Endpoints with Query Parameters
    public static final String SEARCH = "/search";
}