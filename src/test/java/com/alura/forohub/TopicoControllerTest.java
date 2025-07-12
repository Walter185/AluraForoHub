package com.alura.forohub;

import com.alura.forohub.topico.dto.TopicoUpdateRequest;
import com.alura.forohub.topico.entity.StatusTopico;
import com.alura.forohub.topico.entity.Topico;
import com.alura.forohub.topico.repository.TopicoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TopicoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Topico topico;

    @BeforeEach
    void setUp() {
        topicoRepository.deleteAll();

        topico = new Topico();
        topico.setTitulo("Título original");
        topico.setMensaje("Mensaje original");
        topico.setFechaDeCreacion(LocalDateTime.now());
        topico.setStatus(StatusTopico.NO_RESPONDIDO);
        topico.setAutor(null); // si es requerido, deberás setearlo
        topico.setCurso(null); // idem

        topico = topicoRepository.save(topico);
    }

    @Test
    void actualizarTopico_deberiaRetornarTopicoActualizado() throws Exception {
        TopicoUpdateRequest request = new TopicoUpdateRequest(
                "Título actualizado", "Mensaje actualizado", "SOLUCIONADO"
        );

        mockMvc.perform(put("/api/topicos/{id}", topico.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Título actualizado"))
                .andExpect(jsonPath("$.mensaje").value("Mensaje actualizado"))
                .andExpect(jsonPath("$.status").value("SOLUCIONADO"));
    }

    @Test
    void eliminarTopico_deberiaRetornarNoContent() throws Exception {
        mockMvc.perform(delete("/api/topicos/{id}", topico.getId()))
                .andExpect(status().isNoContent());
    }
}
