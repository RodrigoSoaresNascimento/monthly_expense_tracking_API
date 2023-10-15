package com.monthly.budget.app.repository;

import com.monthly.budget.app.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    @Query(value = "SELECT SUM(income_value)" +
            "FROM income " +
            "WHERE id = ?1", nativeQuery = true)
    Double totalIncome(Long idUser);

}
