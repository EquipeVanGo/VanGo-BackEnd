package com.monqui.van_go.dto;

public class LoginDTO {

    private Long id;
    private char typeEntity;

    public LoginDTO(Long id, char typeEntity) {
        this.id = id;
        this.typeEntity = typeEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char getTypeEntity() {
        return typeEntity;
    }

    public void setTypeEntity(char typeEntity) {
        this.typeEntity = typeEntity;
    }
}
