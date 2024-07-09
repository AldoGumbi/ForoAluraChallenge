package com.forohub.Foro.Hub.domain.usuario;

public record DetallesUsuario(
        Long id,
        String nombre,
        String email) {

    public DetallesUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail());
    }
}
