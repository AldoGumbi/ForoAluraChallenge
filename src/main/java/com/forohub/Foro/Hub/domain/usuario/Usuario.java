package com.forohub.Foro.Hub.domain.usuario;

import com.auth0.jwt.algorithms.Algorithm;
import com.forohub.Foro.Hub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Table(name="usuarios")
@Entity(name="usuario")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private  String password;

    public Usuario(DatosRegistroUsuario datos) {
        this.nombre = datos.nombre();
        this.email = datos.email();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(datos.password());
    }


    public Long getId() {return id;}
    public String getNombre() {return nombre;}
    public String getEmail() {return email;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return List.of();}
    public String getPassword() {return password;}
    @Override
    public String getUsername() {return "";}
    @Override
    public boolean isAccountNonExpired() {return UserDetails.super.isAccountNonExpired();}
    @Override
    public boolean isAccountNonLocked() {return UserDetails.super.isAccountNonLocked();}
    @Override
    public boolean isCredentialsNonExpired() {return UserDetails.super.isCredentialsNonExpired();}
    @Override
    public boolean isEnabled() {return UserDetails.super.isEnabled();}
}

