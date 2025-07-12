// TopicoUpdateRequest.java
package com.alura.forohub.topico.dto;

public record TopicoUpdateRequest(
        String titulo,
        String mensaje,
        String status
) {}
