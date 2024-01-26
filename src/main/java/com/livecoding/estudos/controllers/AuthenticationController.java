package com.livecoding.estudos.controllers;

import com.livecoding.estudos.domain.usuarios.AuthenticationDTO;
import com.livecoding.estudos.domain.usuarios.LoginResponseDTO;
import com.livecoding.estudos.domain.usuarios.Usuario;
import com.livecoding.estudos.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO usuario){
        var usernamepassword = new UsernamePasswordAuthenticationToken(usuario.email(), usuario.senha());
        var auth = this.authenticationManager.authenticate(usernamepassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
