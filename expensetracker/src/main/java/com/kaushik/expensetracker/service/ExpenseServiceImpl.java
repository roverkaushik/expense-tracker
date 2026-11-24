package com.kaushik.expensetracker.service;

import org.springframework.stereotype.Service;

import com.kaushik.expensetracker.dto.ExpenseRequest;
import com.kaushik.expensetracker.dto.ExpenseResponse;
import com.kaushik.expensetracker.entity.Expense;
import com.kaushik.expensetracker.mapper.ExpenseMapper;
import com.kaushik.expensetracker.repository.ExpenseRepository;
import com.kaushik.expensetracker.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final ExpenseMapper expenseMapper;

    @Override
    public ExpenseResponse createExpense(ExpenseRequest request) {

        Expense expense = expenseMapper.toEntity(request);
        Expense savedExpense = expenseRepository.save(expense);

        return expenseMapper.toResponse(savedExpense);
    }

}
