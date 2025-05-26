package com.monqui.van_go.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monqui.van_go.config.JwtService;
import com.monqui.van_go.dto.login.AuthenticationDTO;
import com.monqui.van_go.dto.login.TokenDTO;
import com.monqui.van_go.entities.User;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationResource {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationResource(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody AuthenticationDTO autenticacaoDTO) {
        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(
                autenticacaoDTO.getEmail(),
                autenticacaoDTO.getPassword()
            );

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        
        User usuario = (User) authentication.getPrincipal();
        
        String token = jwtService.generateToken(usuario);

        TokenDTO resposta = new TokenDTO(
            usuario.getEmail(),
            token,
            usuario.getId(),
            usuario.getTypeEntity()
        );

        return ResponseEntity.ok(resposta);
    }
}