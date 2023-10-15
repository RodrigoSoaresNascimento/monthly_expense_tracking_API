package com.monthly.budget.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monthly.budget.app.dto.Income.IncomeCreateDTO;
import com.monthly.budget.app.dto.Income.IncomeDTO;
import com.monthly.budget.app.exception.RecordNotFoundException;
import com.monthly.budget.app.model.Income;
import com.monthly.budget.app.model.User;
import com.monthly.budget.app.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    private final UserService userService;

    private final ObjectMapper objectMapper;

    public IncomeService(IncomeRepository incomeRepository, UserService userService, ObjectMapper objectMapper) {
        this.incomeRepository = incomeRepository;
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    public IncomeDTO convertIncomeEntityToIncomeDTO (Income income){
        return objectMapper.convertValue(income, IncomeDTO.class);
    }

    public Income convertIncomeDTOToIncomeEntity (IncomeDTO incomeDTO){
        return objectMapper.convertValue(incomeDTO, Income.class);
    }

    public IncomeDTO addIncome (IncomeCreateDTO incomeCreateDTO, Long idUser){

        Income income = new Income();
        User user = userService.convertToUserModel(userService.getByid(idUser));
        income.setIncomeData(incomeCreateDTO.getIncomeData());
        income.setIncomeValue(incomeCreateDTO.getIncomeValue());
        income.setIncomeName(incomeCreateDTO.getIncomeName());
        income.setUserEnd(user);
        incomeRepository.save(income);
        return convertIncomeEntityToIncomeDTO(income);
    }

    public List<IncomeDTO> listIncomes () {
        return incomeRepository.findAll()
                .stream()
                .map(this::convertIncomeEntityToIncomeDTO)
                .collect(Collectors.toList());
    }

    public IncomeDTO getIncomeById (Long idIncome){
        Optional<Income> income = Optional.ofNullable(incomeRepository.findById(idIncome)
                .orElseThrow(() -> new RecordNotFoundException(idIncome)));
        return convertIncomeEntityToIncomeDTO(income.get());
    }

    public void deleteIncome (Long idIncome){
        IncomeDTO incomeDTO = getIncomeById(idIncome);
        incomeRepository.delete(convertIncomeDTOToIncomeEntity(incomeDTO));
    }

    public Double getTotalIncomeValue (Long idUser){
        return incomeRepository.totalIncome(idUser);
    }

}
