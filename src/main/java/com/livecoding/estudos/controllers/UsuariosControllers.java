package com.livecoding.estudos.controllers;

import com.livecoding.estudos.domain.usuarios.Usuario;

import com.livecoding.estudos.domain.usuarios.UsuarioDTO;
import com.livecoding.estudos.domain.usuarios.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuariosControllers {

    @Autowired
    private UsuarioRepository repository;
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsers() {
        List<Usuario> allUsuarios = repository.findAll();
        List<UsuarioDTO> usuariosDTO = allUsuarios
                .stream()
                .map(UsuarioDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(usuariosDTO);
    }


    @PostMapping
    public ResponseEntity createUsers(@RequestBody @Valid UsuarioDTO user ){
        if(this.repository.findByEmail(user.email())!= null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.senha());
        Usuario newUsuario = new Usuario(user);
        newUsuario.setSenha(encryptedPassword);

        System.out.println(user);

        repository.save(newUsuario);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateUsers(@RequestBody @Valid UsuarioDTO user){

        Optional<Usuario> optionalUsuario = repository.findById(user.id());
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setName(user.name());
            usuario.setEmail(user.email());
            usuario.setSenha(user.senha());
            usuario.setPerfis(user.perfis());
            return ResponseEntity.ok(usuario);
        }
        else{
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
