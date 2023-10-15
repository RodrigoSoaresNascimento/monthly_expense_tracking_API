package com.monthly.budget.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monthly.budget.app.dto.expense.ExpenseCreateDTO;
import com.monthly.budget.app.dto.expense.ExpenseDTO;
import com.monthly.budget.app.exception.RecordNotFoundException;
import com.monthly.budget.app.model.Expense;
import com.monthly.budget.app.model.User;
import com.monthly.budget.app.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    private final UserService userService;

    private final ObjectMapper objectMapper;

    public ExpenseService(ExpenseRepository expenseRepository, UserService userService, ObjectMapper objectMapper) {
        this.expenseRepository = expenseRepository;
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    public ExpenseDTO convertExpenseEntityToExpenseDTO (Expense expense){
        return objectMapper.convertValue(expense, ExpenseDTO.class);
    }

    public Expense convertExpenseDTOToExpenseEntity (ExpenseDTO expenseDTO){
        return objectMapper.convertValue(expenseDTO, Expense.class);
    }

    public ExpenseDTO addExpense (ExpenseCreateDTO expenseCreateDTO, Long idUser){

        Expense expense = new Expense();
        User user = userService.convertToUserModel(userService.getByid(idUser));
        expense.setExpenseData(expenseCreateDTO.getExpenseData());
        expense.setExpenseValue(expenseCreateDTO.getExpenseValue());
        expense.setExpenseName(expenseCreateDTO.getExpenseName());
        expense.setUserEnd(user);
        expenseRepository.save(expense);
        return convertExpenseEntityToExpenseDTO(expense);
    }

    public List<ExpenseDTO> listExpenses () {
        return expenseRepository.findAll()
                .stream()
                .map(this::convertExpenseEntityToExpenseDTO)
                .collect(Collectors.toList());
    }

    public ExpenseDTO getExpenseById (Long idExpense){
        Optional<Expense> expense = Optional.ofNullable(expenseRepository.findById(idExpense)
                .orElseThrow(() -> new RecordNotFoundException(idExpense)));
        return convertExpenseEntityToExpenseDTO(expense.get());
    }

    public void deleteExpense (Long idExpense){
        ExpenseDTO expenseDTO = getExpenseById(idExpense);
        expenseRepository.delete(convertExpenseDTOToExpenseEntity(expenseDTO));
    }

    public Double getTotalExpenseValue (Long idUser){
        return expenseRepository.totalExpense(idUser);
    }

}
