package com.monthly.budget.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExpense;

    @Column(length = 100, nullable = false)
    private String expenseName;

    @Column(length = 50,nullable = false)
    private Double expenseValue;

    @Column(length = 50, nullable = false)
    private Date expenseData;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User userEnd;

    public User getUserEnd() {
        return userEnd;
    }

    public void setUserEnd(User userEnd) {
        this.userEnd = userEnd;
    }

    public Long getIdExpense() {
        return idExpense;
    }

    public void setIdExpense(Long idExpense) {
        this.idExpense = idExpense;
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

    @Override
    public String toString() {
        return "Expense{" +
                "idExpense=" + idExpense +
                ", expenseName='" + expenseName + '\'' +
                ", expenseValue=" + expenseValue +
                ", expenseData=" + expenseData +
                '}';
    }
}
