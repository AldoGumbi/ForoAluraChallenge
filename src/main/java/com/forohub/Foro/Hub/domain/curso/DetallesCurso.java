package com.forohub.Foro.Hub.domain.curso;

public record DetallesCurso(
        Long id,
        String nombre,
        String categoria
)
{
    public DetallesCurso(Curso curso){
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
