package com.kaushik.expensetracker.mapper;

import org.springframework.stereotype.Component;

import com.kaushik.expensetracker.dto.ExpenseRequest;
import com.kaushik.expensetracker.dto.ExpenseResponse;
import com.kaushik.expensetracker.entity.Expense;

@Component
public class ExpenseMapper {

    public Expense toEntity(ExpenseRequest request) {

        Expense expense = new Expense();

        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setExpenseDate(request.getExpenseDate());
        expense.setDescription(request.getDescription());

        return expense;
    }

    public ExpenseResponse toResponse(Expense expense) {

        ExpenseResponse response = new ExpenseResponse();

        response.setId(expense.getId());
        response.setAmount(expense.getAmount());
        response.setCategory(expense.getCategory());
        response.setExpenseDate(expense.getExpenseDate());

        return response;
    }

}
