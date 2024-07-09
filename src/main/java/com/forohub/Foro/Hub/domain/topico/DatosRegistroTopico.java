package com.forohub.Foro.Hub.domain.topico;

import com.forohub.Foro.Hub.domain.curso.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        LocalDateTime fecha,
        @NotBlank
        String status,
        @NotNull
        Long usuario,
        Curso curso
) {
}
