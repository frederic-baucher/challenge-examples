package com.deadlock.hack.controller.dto;

public class TokenDto {
    private final String token;

    public TokenDto(final String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
