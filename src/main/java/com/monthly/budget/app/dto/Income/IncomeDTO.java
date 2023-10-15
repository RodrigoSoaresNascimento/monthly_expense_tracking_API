package com.monthly.budget.app.dto.Income;

import com.monthly.budget.app.model.User;

import java.util.Date;

public class IncomeDTO extends IncomeCreateDTO{

    private Long idIncome;

    public IncomeDTO(String incomeName, Double incomeValue, Date incomeData, User userEnd, Long idIncome) {
        super(incomeName, incomeValue, incomeData, userEnd);
        this.idIncome = idIncome;
    }

    public IncomeDTO() {
    }

    public Long getIdIncome() {
        return idIncome;
    }

    public void setIdIncome(Long idIncome) {
        this.idIncome = idIncome;
    }
}
