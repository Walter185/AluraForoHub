package com.alura.forohub.auth;

import com.alura.forohub.auth.dto.JwtResponse;
import com.alura.forohub.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.alura.forohub.usuario.entity.Usuario;
import com.alura.forohub.auth.dto.LoginRequest;
import com.alura.forohub.auth.dto.RegisterRequest;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public void register(RegisterRequest request) {
        Usuario user = new Usuario();
        user.setNombre(request.nombre()); // ahora también se guarda el nombre
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole("USER");
        usuarioRepository.save(user);
    }


    public JwtResponse login(LoginRequest request) {
        System.out.println("👉 Intentando login con: " + request.username());

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.username(), request.password())
            );
            System.out.println("✅ Autenticación exitosa");
        } catch (Exception e) {
            System.out.println("❌ Falló la autenticación: " + e.getMessage());
            throw e;
        }

        Usuario user = usuarioRepository.findByUsername(request.username())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );

        String token = jwtService.generateToken(userDetails);
        return new JwtResponse(token);
    }
}


