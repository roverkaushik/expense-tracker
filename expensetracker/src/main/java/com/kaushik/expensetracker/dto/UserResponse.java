package com.kaushik.expensetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate contactNumber;

}
