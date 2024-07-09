package com.forohub.Foro.Hub.domain.topico;

import com.forohub.Foro.Hub.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Boolean existsByTitulo(String titulo);
    Boolean existsByMensaje(String mensaje);
}
