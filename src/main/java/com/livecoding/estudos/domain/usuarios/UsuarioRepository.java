package com.livecoding.estudos.domain.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    List<Usuario> findAllByActiveTrue();
    Usuario findByEmail (String Email);
}
