package com.alura.forohub.topico.service;

import com.alura.forohub.auth.AuthUtil;
import com.alura.forohub.curso.entity.Curso;
import com.alura.forohub.curso.repository.CursoRepository;
import com.alura.forohub.topico.dto.TopicoDetalleDTO;
import com.alura.forohub.topico.dto.TopicoRequest;
import com.alura.forohub.topico.dto.TopicoResponse;
import com.alura.forohub.topico.dto.TopicoUpdateRequest;
import com.alura.forohub.topico.entity.StatusTopico;
import com.alura.forohub.topico.entity.Topico;
import com.alura.forohub.topico.repository.TopicoRepository;
import com.alura.forohub.usuario.entity.Usuario;
import com.alura.forohub.usuario.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicoService {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    @Transactional
    public TopicoResponse crearTopico(TopicoRequest request) {
        String username = AuthUtil.getAuthenticatedUsername();

        Usuario autor = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Curso curso = cursoRepository.findById(request.cursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Topico topico = new Topico();
        topico.setTitulo(request.titulo());
        topico.setMensaje(request.mensaje());
        topico.setAutor(autor);
        topico.setCurso(curso);
        topico.setFechaDeCreacion(LocalDateTime.now());
        topico.setStatus(StatusTopico.NO_RESPONDIDO);

        topicoRepository.save(topico);

        return new TopicoResponse(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getStatus().name(),
                autor.getNombre(),
                curso.getNombre()
        );
    }

    public List<TopicoDetalleDTO> listarTopicos() {
        return topicoRepository.findAll()
                .stream()
                .map(TopicoDetalleDTO::new)
                .toList();
    }

    @Transactional
    public TopicoResponse actualizarTopico(Long id, TopicoUpdateRequest request) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        if (request.titulo() != null) topico.setTitulo(request.titulo());
        if (request.mensaje() != null) topico.setMensaje(request.mensaje());
        if (request.status() != null) topico.setStatus(StatusTopico.valueOf(request.status()));

        topicoRepository.save(topico);

        return new TopicoResponse(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getStatus().name(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()
        );
    }

    @Transactional
    public void eliminarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new RuntimeException("Tópico no encontrado");
        }
        topicoRepository.deleteById(id);
    }

}
