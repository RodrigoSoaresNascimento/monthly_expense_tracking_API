package com.monthly.budget.app.dto.Income;

import com.monthly.budget.app.model.User;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class IncomeCreateDTO {

    private String incomeName;

    private Double incomeValue;

    private Date incomeData;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private User userEnd;

    public IncomeCreateDTO(String incomeName, Double incomeValue, Date incomeData, User userEnd) {
        this.incomeName = incomeName;
        this.incomeValue = incomeValue;
        this.incomeData = incomeData;
        this.userEnd = userEnd;
    }

    public IncomeCreateDTO() {
    }

    public String getIncomeName() {
        return incomeName;
    }

    public void setIncomeName(String incomeName) {
        this.incomeName = incomeName;
    }

    public Double getIncomeValue() {
        return incomeValue;
    }

    public void setIncomeValue(Double incomeValue) {
        this.incomeValue = incomeValue;
    }

    public Date getIncomeData() {
        return incomeData;
    }

    public void setIncomeData(Date incomeData) {
        this.incomeData = incomeData;
    }

    public User getUserEnd() {
        return userEnd;
    }

    public void setUserEnd(User userEnd) {
        this.userEnd = userEnd;
    }
}
