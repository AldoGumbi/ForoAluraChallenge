package com.forohub.Foro.Hub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarRespuesta(
        String mensaje,
        LocalDateTime fecha
) {
}
