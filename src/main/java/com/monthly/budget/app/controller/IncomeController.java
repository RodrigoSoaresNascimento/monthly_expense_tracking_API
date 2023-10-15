package com.monthly.budget.app.controller;

import com.monthly.budget.app.dto.Income.IncomeDTO;
import com.monthly.budget.app.service.IncomeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incomes")
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/findAll")
    public List<IncomeDTO> listIncomes (){
        return incomeService.listIncomes();
    }

    @DeleteMapping("/delete/{idIncome}")
    public ResponseEntity<Void> delete (@PathVariable("idIncome") Long idIncome){
        incomeService.deleteIncome(idIncome);
        return ResponseEntity.noContent().<Void>build();
    }

    @PostMapping("/add/{idUser}")
    public ResponseEntity<IncomeDTO> addIncome (@Valid @RequestBody IncomeDTO incomeDTO, @PathVariable("idUser") Long idUser){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(incomeService.addIncome(incomeDTO, idUser));
    }

    @GetMapping("/totalIncome/{idUser}")
    public ResponseEntity<Double> getTotalIncomeValue (@PathVariable("idUser") Long idUser ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(incomeService.getTotalIncomeValue(idUser));
    }
}
