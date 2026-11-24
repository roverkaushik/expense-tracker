package com.kaushik.expensetracker.service;

import com.kaushik.expensetracker.dto.UserRequest;
import com.kaushik.expensetracker.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long userId);

    UserResponse updateUser(Long userId, UserRequest request);

    void deleteUser(Long userId);
}
