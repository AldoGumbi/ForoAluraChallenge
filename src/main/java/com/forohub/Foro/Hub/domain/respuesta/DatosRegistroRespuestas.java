package com.forohub.Foro.Hub.domain.respuesta;

import com.forohub.Foro.Hub.domain.curso.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroRespuestas(
        @NotBlank
        String mensaje,
        @NotNull
        LocalDateTime fecha,
        @NotNull
        Long idUsuario,
        @NotNull
        Long idTopico
) {
}
