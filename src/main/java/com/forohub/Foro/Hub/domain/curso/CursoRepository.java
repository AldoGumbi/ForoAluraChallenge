package com.forohub.Foro.Hub.domain.curso;

import com.forohub.Foro.Hub.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long>{
    Curso findFirstByNombre(String nombre);
}
