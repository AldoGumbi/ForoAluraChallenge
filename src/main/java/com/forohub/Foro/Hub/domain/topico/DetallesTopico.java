package com.forohub.Foro.Hub.domain.topico;

import com.forohub.Foro.Hub.domain.curso.Curso;
import com.forohub.Foro.Hub.domain.curso.DetallesCurso;
import com.forohub.Foro.Hub.domain.usuario.DetallesUsuario;
import com.forohub.Foro.Hub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DetallesTopico(
    Long id,
    String titulo,
    String mensaje,
    LocalDateTime fecha,
    String status,
    DetallesUsuario usuario,
    DetallesCurso curso) {

    public DetallesTopico(Topico topico, DetallesUsuario usuario, DetallesCurso curso) {
            this(
                    topico.getId(),
                    topico.getTitulo(),
                    topico.getMensaje(),
                    topico.getFechaCreacion(),
                    topico.getStatus(),
                    usuario,
                    curso
            );
        }

}