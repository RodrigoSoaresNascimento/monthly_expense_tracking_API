package com.monthly.budget.app.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idIncome;

    @Column(length = 100, nullable = false)
    private String incomeName;

    @Column(nullable = false)
    private Double incomeValue;

    @Column(length = 50, nullable = false)
    private Date incomeData;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User userEnd;

    public Long getIdIncome() {
        return idIncome;
    }

    public void setIdIncome(Long idIncome) {
        this.idIncome = idIncome;
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

    @Override
    public String toString() {
        return "Income{" +
                "idIcome=" + idIncome +
                ", incomeName='" + incomeName + '\'' +
                ", incomeValue=" + incomeValue +
                ", incomeData=" + incomeData +
                '}';
    }
}
