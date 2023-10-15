package com.monthly.budget.app.dto.user;

import com.monthly.budget.app.dto.Income.IncomeDTO;
import com.monthly.budget.app.dto.expense.ExpenseDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

public class UserCreateDTO {

    private String userName;
    private String email;
    private String password;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private List<IncomeDTO> incomes = new ArrayList<>();

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private List<ExpenseDTO> expenses = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserCreateDTO() {
    }

    public UserCreateDTO(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserCreateDTO{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", incomes=" + incomes +
                ", expenses=" + expenses +
                '}';
    }
}
