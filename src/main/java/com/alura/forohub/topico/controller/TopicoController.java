package com.alura.forohub.topico.controller;

import com.alura.forohub.topico.dto.TopicoDetalleDTO;
import com.alura.forohub.topico.dto.TopicoRequest;
import com.alura.forohub.topico.dto.TopicoResponse;
import com.alura.forohub.topico.dto.TopicoUpdateRequest;
import com.alura.forohub.topico.service.TopicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
@RequiredArgsConstructor
public class TopicoController {

    private final TopicoService topicoService;

    @PostMapping
    public ResponseEntity<TopicoResponse> crearTopico(@RequestBody TopicoRequest request) {
        TopicoResponse response = topicoService.crearTopico(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TopicoDetalleDTO>> listarTopicos() {
        List<TopicoDetalleDTO> topicos = topicoService.listarTopicos();
        return ResponseEntity.ok(topicos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoResponse> actualizarTopico(@PathVariable Long id,
                                                           @RequestBody TopicoUpdateRequest request) {
        TopicoResponse actualizado = topicoService.actualizarTopico(id, request);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }

}
