package com.monthly.budget.app.repository;

import com.monthly.budget.app.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query(value = "SELECT SUM(expense_value)" +
                    "FROM expense " +
                    "WHERE id = ?1", nativeQuery = true)
    Double totalExpense(Long idUser);

}
