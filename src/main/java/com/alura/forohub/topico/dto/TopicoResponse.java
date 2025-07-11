package com.alura.forohub.topico.dto;

import java.time.LocalDateTime;

public record TopicoResponse(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        String status,
        String autor,
        String curso
) {}
