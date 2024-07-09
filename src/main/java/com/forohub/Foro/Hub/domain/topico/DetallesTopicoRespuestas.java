package com.forohub.Foro.Hub.domain.topico;


import com.forohub.Foro.Hub.domain.curso.Curso;
import com.forohub.Foro.Hub.domain.curso.DetallesCurso;
import com.forohub.Foro.Hub.domain.respuesta.DatosListaRespuesta;
import com.forohub.Foro.Hub.domain.usuario.DetallesUsuario;
import com.forohub.Foro.Hub.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public record DetallesTopicoRespuestas(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        String status,
        DetallesUsuario usuario,
        DetallesCurso curso,
        List<DatosListaRespuesta> respuestas) {

    public DetallesTopicoRespuestas(Topico topico, DetallesUsuario usuario, DetallesCurso curso, List<DatosListaRespuesta> respuestas) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                usuario,
                curso,
                respuestas
        );
    }

}