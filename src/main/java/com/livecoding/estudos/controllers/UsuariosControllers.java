package com.livecoding.estudos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuariosControllers {

    @GetMapping
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok("deu ok");

    }

}
