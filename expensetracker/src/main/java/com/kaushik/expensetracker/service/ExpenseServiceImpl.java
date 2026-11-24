package com.kaushik.expensetracker.service;

import org.springframework.stereotype.Service;

import com.kaushik.expensetracker.dto.ExpenseRequest;
import com.kaushik.expensetracker.dto.ExpenseResponse;
import com.kaushik.expensetracker.entity.Expense;
import com.kaushik.expensetracker.mapper.ExpenseMapper;
import com.kaushik.expensetracker.repository.ExpenseRepository;
import com.kaushik.expensetracker.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@Transactional
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

    @Override
    @Transactional(readOnly = true)
    public List<ExpenseResponse> getAllExpenses() {
        return expenseRepository.findAll().stream().map(expenseMapper::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ExpenseResponse getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));

        return expenseMapper.toResponse(expense);
    }

    @Override
    @Transactional
    public ExpenseResponse updateExpense(Long id, ExpenseRequest request) {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Expense not found with id: " + id));

        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setExpenseDate(request.getExpenseDate());
        expense.setDescription(request.getDescription());

        Expense updatedExpense = expenseRepository.save(expense);

        return expenseMapper.toResponse(updatedExpense);
    }

    @Override
    @Transactional
    public void deleteExpense(Long id) {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Expense not found with id: " + id));

        expenseRepository.delete(expense);
    }

}
