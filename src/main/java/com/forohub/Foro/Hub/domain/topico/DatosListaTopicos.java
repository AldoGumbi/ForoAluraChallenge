package com.forohub.Foro.Hub.domain.topico;

import com.forohub.Foro.Hub.domain.curso.Curso;
import com.forohub.Foro.Hub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosListaTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        String status,
        Long idUsuairo,
        Long idCurso) {

    public DatosListaTopicos(Topico topico) {
        this(
             topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getUsuario().getId(),
                topico.getCurso().getId()
        );
    }
}