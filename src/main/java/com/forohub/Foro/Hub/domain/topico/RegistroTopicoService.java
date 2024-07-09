package com.forohub.Foro.Hub.domain.topico;

import com.forohub.Foro.Hub.domain.curso.Curso;
import com.forohub.Foro.Hub.domain.curso.CursoRepository;
import com.forohub.Foro.Hub.domain.curso.DetallesCurso;
import com.forohub.Foro.Hub.domain.usuario.Usuario;
import com.forohub.Foro.Hub.domain.usuario.UsuarioRepository;
import com.forohub.Foro.Hub.infraestruc.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistroTopicoService {
    @Autowired
    private TopicoRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public void RegistrarNuevoTopico(DatosRegistroTopico datos){
        Optional<Usuario> usuario= usuarioRepository.findById(datos.usuario().longValue());
        var curso= verificarCurso(datos.curso());
        if(repository.existsByTitulo(datos.titulo()) || repository.existsByMensaje((datos.mensaje())) ){
            throw new ValidacionDeIntegridad("[!] Topico / Mensaje ya registrados");
        }else{
            var topico = new Topico(datos, usuario, curso);
            repository.save(topico);
        }
    }

    public Usuario RetornarUsuario(Long idUsuario)
        {return usuarioRepository.getReferenceById(idUsuario);}

    public Curso RetornarCurso(Long idCurso)
    {return cursoRepository.getReferenceById(idCurso);}

    public Curso verificarCurso(Curso curso){
        if(curso.getId() == null){
            cursoRepository.save(curso);
            return cursoRepository.findFirstByNombre(curso.getNombre());
        }else{
            return cursoRepository.getById(curso.getId());
        }
    }

}
