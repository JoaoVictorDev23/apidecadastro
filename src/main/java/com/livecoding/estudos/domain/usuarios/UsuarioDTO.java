package com.livecoding.estudos.domain.usuarios;

import com.livecoding.estudos.domain.usuarios.enums.perfis;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UsuarioDTO(
        String id,
        @NotBlank String name,
        @NotNull String email,
        @NotNull String senha,
        @NotNull Set<perfis> perfis
) {
        public UsuarioDTO(Usuario usuario) {
                this(usuario.getId(), usuario.getName(), usuario.getEmail(), usuario.getSenha(), usuario.getPerfis());
        }
}