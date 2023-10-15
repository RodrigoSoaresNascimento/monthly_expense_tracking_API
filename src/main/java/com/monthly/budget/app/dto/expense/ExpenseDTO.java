package com.monthly.budget.app.dto.expense;

import com.monthly.budget.app.dto.user.UserDTO;
import com.monthly.budget.app.model.User;

import java.util.Date;

public class ExpenseDTO extends ExpenseCreateDTO{

    private Long idExpense;

    public ExpenseDTO(String expenseName, Double expenseValue, Date expenseData, User userEnd, Long idExpense) {
        super(expenseName, expenseValue, expenseData, userEnd);
        this.idExpense = idExpense;
    }

    public ExpenseDTO() {
    }

    public Long getIdExpense() {
        return idExpense;
    }

    public void setIdExpense(Long idExpense) {
        this.idExpense = idExpense;
    }
}
