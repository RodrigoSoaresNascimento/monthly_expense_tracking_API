package com.monthly.budget.app.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO extends UserCreateDTO{

    @JsonProperty("_id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO(String name, String email, String password, Long id) {
        super(name, email, password);
        this.id = id;
    }

    public UserDTO() {
    }


}
