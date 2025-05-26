package com.monqui.van_go.resources;

import com.monqui.van_go.config.JwtService;
import com.monqui.van_go.dto.login.AuthenticationDTO;
import com.monqui.van_go.dto.login.TokenDTO;
import com.monqui.van_go.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthRequest {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    public AuthRequest(AuthenticationManager authManager, JwtService jwtService) {
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody AuthenticationDTO request) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        User user = (User) auth.getPrincipal();
        String jwt = jwtService.generateToken(user);

        return ResponseEntity.ok(new TokenDTO(request.getEmail(),
                jwt,user.getId(),user.getTypeEntity()));
    }
}
