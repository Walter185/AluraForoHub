package com.alura.forohub.topico.dto;

import java.time.LocalDateTime;

public record TopicoListadoDTO(
        Long id,
        String titulo,
        String autor,
        String curso,
        LocalDateTime fechaDeCreacion,
        String estado
) {}

