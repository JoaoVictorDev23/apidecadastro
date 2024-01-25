package com.livecoding.estudos.domain.usuarios;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Table(name="usuarios")
@Entity(name="usuarios")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @ElementCollection
    @CollectionTable(name = "usuario_perfis", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "perfil", nullable = false)
    private List<Integer> perfis = new ArrayList<>();

    private Boolean active;

    public Usuario(RequestUsuario requestUsuario, List<Integer> perfis) {
        this.name = requestUsuario.name();
        this.email = requestUsuario.email();
        this.senha = requestUsuario.senha();
        this.perfis = perfis;
        this.active= true;
    }


}
