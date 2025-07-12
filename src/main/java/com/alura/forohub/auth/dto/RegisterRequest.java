package com.alura.forohub.auth.dto;

public record RegisterRequest(
        String nombre,
        String username,
        String password
) {}
