package com.monthly.budget.app.controller;

import com.monthly.budget.app.dto.expense.ExpenseDTO;
import com.monthly.budget.app.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/findAll")
    public List<ExpenseDTO> findAll (){
        return expenseService.listExpenses();
    }

    @DeleteMapping("/delete/{idExpense}")
    public ResponseEntity<Void> delete (@PathVariable("idExpense") Long idExpense){
        expenseService.deleteExpense(idExpense);
        return ResponseEntity.noContent().<Void>build();
    }

    @PostMapping("/add/{idUser}")
    public ResponseEntity<ExpenseDTO> addExpense (@Valid @RequestBody ExpenseDTO expenseDTO, @PathVariable("idUser") Long idUser){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(expenseService.addExpense(expenseDTO, idUser));
    }

    @GetMapping("/totalExpense/{idUser}")
    public ResponseEntity<Double> getTotalExpenseValue (@PathVariable("idUser") Long idUser){
        return ResponseEntity.status(HttpStatus.OK)
                .body(expenseService.getTotalExpenseValue(idUser));
    }
}
