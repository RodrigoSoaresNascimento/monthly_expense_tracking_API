package com.monthly.budget.app.dto.expense;

import com.monthly.budget.app.dto.user.UserDTO;
import com.monthly.budget.app.model.User;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class ExpenseCreateDTO {

    private String expenseName;

    private Double expenseValue;

    private Date expenseData;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private User userEnd;


    public ExpenseCreateDTO(String expenseName, Double expenseValue, Date expenseData, User userEnd) {
        this.expenseName = expenseName;
        this.expenseValue = expenseValue;
        this.expenseData = expenseData;
        this.userEnd = userEnd;
    }

    public ExpenseCreateDTO() {
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Double getExpenseValue() {
        return expenseValue;
    }

    public void setExpenseValue(Double expenseValue) {
        this.expenseValue = expenseValue;
    }

    public Date getExpenseData() {
        return expenseData;
    }

    public void setExpenseData(Date expenseData) {
        this.expenseData = expenseData;
    }

    public User getUserEnd() {
        return userEnd;
    }

    public void setUserEnd(User userEnd) {
        this.userEnd = userEnd;
    }
}
