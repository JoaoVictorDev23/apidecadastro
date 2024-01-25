package com.livecoding.estudos.domain.usuarios;


import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "perfis")
    private Integer  perfis;

    public Usuario(RequestUsuario requestUsuario){
        this.name = requestUsuario.name();
        this.email = requestUsuario.email();
        this.senha = requestUsuario.senha();
        this.perfis= requestUsuario.perfis();
    }

}
