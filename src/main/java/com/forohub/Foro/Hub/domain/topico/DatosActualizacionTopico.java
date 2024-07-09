package com.forohub.Foro.Hub.domain.topico;

import com.forohub.Foro.Hub.domain.curso.Curso;

public record DatosActualizacionTopico(
        String titulo,
        String mensaje,
        Curso curso,
        String status
) {
}
