package com.forohub.Foro.Hub.domain.respuesta;

import com.forohub.Foro.Hub.domain.topico.DatosListaTopicos;
import com.forohub.Foro.Hub.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public record DatosListaRespuesta (
        Long id,
        String mensaje,
        LocalDateTime fecha,
        String nombreUsuario
){

    public DatosListaRespuesta(Long id,String mensaje, LocalDateTime fecha, Usuario usuario){
        this(id, mensaje, fecha, usuario.getNombre());
    }
}
