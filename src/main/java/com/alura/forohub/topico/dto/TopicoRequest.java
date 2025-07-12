package com.alura.forohub.topico.dto;

public record TopicoRequest(
        String titulo,
        String mensaje,
        Long cursoId
) {}
