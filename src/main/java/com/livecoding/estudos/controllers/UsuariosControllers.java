package com.livecoding.estudos.controllers;

import com.livecoding.estudos.domain.usuarios.RequestUsuario;
import com.livecoding.estudos.domain.usuarios.Usuario;
import com.livecoding.estudos.domain.usuarios.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuariosControllers {

    @Autowired
    private UsuarioRepository repository;
    @GetMapping
    public ResponseEntity getAllUsers(){
        var allusuarios = repository.findAll();
        return ResponseEntity.ok(allusuarios);

    }

    @PostMapping
    public ResponseEntity createUsers(@RequestBody @Valid RequestUsuario user) {
        Usuario newUsuario = new Usuario(user, user.perfis());
        repository.save(newUsuario);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateUsers(@RequestBody @Valid RequestUsuario user) {
        Optional<Usuario> optionalUsuario = repository.findById(user.id());
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setName(user.name());
            usuario.setEmail(user.email());
            usuario.setSenha(user.senha());
            usuario.setPerfis(user.perfis());
            repository.save(usuario);  // Certifique-se de salvar as alterações no banco de dados
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteUsuario(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
