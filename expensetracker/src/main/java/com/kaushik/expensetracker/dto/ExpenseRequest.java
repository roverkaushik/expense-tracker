package com.kaushik.expensetracker.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseRequest {

    private BigDecimal amount;
    private String category;
    private String description;
    private LocalDate expenseDate;

}
