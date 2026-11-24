package com.kaushik.expensetracker.service;

import com.kaushik.expensetracker.dto.ExpenseRequest;
import com.kaushik.expensetracker.dto.ExpenseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ExpenseService {

    ExpenseResponse createExpense(ExpenseRequest request);

    List<ExpenseResponse> getAllExpenses();

    ExpenseResponse getExpenseById(Long id);

    ExpenseResponse updateExpense(Long id, ExpenseRequest request);

    void deleteExpense(Long id);
}
