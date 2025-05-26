package com.monqui.van_go.dto.login;

public class TokenDTO {
    private String email;
    private String token;
    private Long id;
    private char typeEntity;

    public TokenDTO() {
    }

    public TokenDTO(String email, String token, Long id, char typeEntity) {
        this.email = email;
        this.token = token;
        this.id = id;
        this.typeEntity = typeEntity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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