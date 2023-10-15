package com.monthly.budget.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monthly.budget.app.dto.user.UserCreateDTO;
import com.monthly.budget.app.dto.user.UserDTO;
import com.monthly.budget.app.exception.RecordNotFoundException;
import com.monthly.budget.app.model.User;
import com.monthly.budget.app.repository.ExpenseRepository;
import com.monthly.budget.app.repository.IncomeRepository;
import com.monthly.budget.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final ExpenseRepository expenseRepository;

    private final IncomeRepository incomeRepository;

    private final ObjectMapper objectMapper;

    public UserService(UserRepository userRepository, ExpenseRepository expenseRepository, IncomeRepository incomeRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.expenseRepository = expenseRepository;
        this.incomeRepository = incomeRepository;
        this.objectMapper = objectMapper;
    }

    public User convertToUserModel (UserCreateDTO userCreateDTO){
        return objectMapper.convertValue(userCreateDTO, User.class);
    }

    public UserDTO convertToUserDTO (User user){
        return objectMapper.convertValue(user, UserDTO.class);
    }

    public List<UserDTO> list(){
        return userRepository.findAll()
                .stream()
                .map(this::convertToUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO createUser (UserCreateDTO userCreateDTO){

        User user = new User();

        user.setEmail(userCreateDTO.getEmail());
        user.setUserName(userCreateDTO.getUserName());
        user.setPassword(userCreateDTO.getPassword());
        userRepository.save(user);
        return convertToUserDTO(user);

    }

    public UserDTO getByid(Long id){
        Optional<User> user = Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));

        return convertToUserDTO(user.get());
    }

    public void delete (Long id){
        UserDTO userDelete = getByid(id);
        User user = convertToUserModel(userDelete);
        userRepository.delete(user);
    }

    public Double getBalance(Long idUser){
        Long idUserExist = getByid(idUser).getId();
        return incomeRepository.totalIncome(idUserExist) - expenseRepository.totalExpense(idUserExist);
    }

}
