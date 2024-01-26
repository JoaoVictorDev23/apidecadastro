package com.livecoding.estudos.domain.usuarios;


import com.livecoding.estudos.domain.usuarios.enums.perfis;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;



@Table(name="usuarios")
@Entity(name="usuarios")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor

public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @ElementCollection(targetClass = perfis.class)
    @CollectionTable(name = "usuario_perfis", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "perfil", nullable = false)
    private Set<perfis> perfis;

    public Usuario(@Valid UsuarioDTO requestUsuario){
        this.name = requestUsuario.name();
        this.email = requestUsuario.email();
        this.senha = requestUsuario.senha();
        this.perfis= requestUsuario.perfis();
    }
    public Usuario(String email, String senha,Set<perfis> perfil){
        this.email = email;
        this.senha = senha;
        this.perfis = perfil;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}

