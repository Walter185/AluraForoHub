package com.alura.forohub.topico.dto;

import com.alura.forohub.topico.entity.StatusTopico;

import java.time.LocalDateTime;

public record TopicoDetalleDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        StatusTopico status,
        String autor,
        String curso
) {
    public TopicoDetalleDTO(com.alura.forohub.topico.entity.Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()
        );
    }
}
