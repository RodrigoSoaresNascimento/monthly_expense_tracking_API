package com.monthly.budget.app.controller;

import com.monthly.budget.app.dto.user.UserDTO;
import com.monthly.budget.app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public List<UserDTO> searchUsers (){
        return userService.list();
    }

    @DeleteMapping("/delete/{idUser}")
    public ResponseEntity<Void> delete (@PathVariable("idUser") Long idUser){
        userService.delete(idUser);
        return ResponseEntity.noContent().<Void>build();
    }

    @PostMapping("/add")
    public ResponseEntity<UserDTO> addUser (@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(userDTO));
    }

    @GetMapping("/getBalance/{idUser}")
    public ResponseEntity<Double> getBalance (@PathVariable("idUser") Long idUser){
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getBalance(idUser));

    }

}
