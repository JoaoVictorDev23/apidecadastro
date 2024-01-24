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

    private String name;
    private String email;
    private String senha;
    private Number perfis;
}
