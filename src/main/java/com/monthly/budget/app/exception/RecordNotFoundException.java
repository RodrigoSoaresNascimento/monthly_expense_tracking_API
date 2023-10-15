package com.monthly.budget.app.exception;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(Long id) {
        super("Registro não encontrado para o identificador : "+ id);
    }
}
