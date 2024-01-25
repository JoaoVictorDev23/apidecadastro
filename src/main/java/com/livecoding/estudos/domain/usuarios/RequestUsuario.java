package com.livecoding.estudos.domain.usuarios;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestUsuario(

        String id,
        @NotBlank
        String name,
        @NotNull
        String email,
        @NotNull
        String senha,
        @NotNull Integer perfis) {
}
