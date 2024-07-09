package com.forohub.Foro.Hub.domain.respuesta;

import com.forohub.Foro.Hub.domain.curso.CursoRepository;
import com.forohub.Foro.Hub.domain.topico.DatosRegistroTopico;
import com.forohub.Foro.Hub.domain.topico.Topico;
import com.forohub.Foro.Hub.domain.topico.TopicoRepository;
import com.forohub.Foro.Hub.domain.usuario.Usuario;
import com.forohub.Foro.Hub.domain.usuario.UsuarioRepository;
import com.forohub.Foro.Hub.infraestruc.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RegistroRespuestaServices {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RespuestaRepository respuestaRepository;

    public void RegistrarNuevaRespuesta(DatosRegistroRespuestas datos){
        var usuario = new Usuario();
        var topico= new Topico();
        if(topicoRepository.existsById(datos.idTopico()) && usuarioRepository.existsById(datos.idUsuario())){
            topico = topicoRepository.getReferenceById(datos.idTopico());
            usuario = usuarioRepository.getReferenceById(datos.idUsuario());
        }else{
            throw new ValidacionDeIntegridad("Topico / Usuario no encontrados");
        }
        var respuesta =  new Respuesta(datos, usuario, topico);
        topico.agregarRespuesta(respuesta);
        respuestaRepository.save(respuesta);
    }
}
