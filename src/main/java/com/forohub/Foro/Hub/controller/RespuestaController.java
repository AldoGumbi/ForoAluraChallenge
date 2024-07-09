package com.forohub.Foro.Hub.controller;

import com.forohub.Foro.Hub.domain.curso.DetallesCurso;
import com.forohub.Foro.Hub.domain.respuesta.*;
import com.forohub.Foro.Hub.domain.topico.*;
import com.forohub.Foro.Hub.domain.usuario.DetallesUsuario;
import com.forohub.Foro.Hub.infraestruc.errores.ValidacionDeIntegridad;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/topico")
public class RespuestaController {
    @Autowired
    private RegistroRespuestaServices service;
    @Autowired
    private RegistroTopicoService topicoService;
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private RespuestaRepository respuestaRepository;

    @PostMapping("/respuesta")
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroRespuestas datos, UriComponentsBuilder uriBuilder) throws ValidacionDeIntegridad {
        String message;
        service.RegistrarNuevaRespuesta(datos);
        message = "Respuesta Guardada con exito!";
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}/respuestas")
    public ResponseEntity listadoRespuestas(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        var usuario = new DetallesUsuario(topicoService.RetornarUsuario(topico.getUsuario().getId()));
        var curso = new DetallesCurso(topicoService.RetornarCurso(topico.getCurso().getId()));
        var respuestas = topico.getRespuestas().stream()
                .map(r->new DatosListaRespuesta(r.getId(),r.getMensaje(), r.getFechaCreacion(), r.getUsuario()))
                .toList();

        return ResponseEntity.ok(new DetallesTopicoRespuestas(topico, usuario, curso, respuestas));
    }

    @PutMapping("/respuesta/{id}")
    @Transactional
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizarRespuesta datos, @PathVariable Long id)throws ValidacionDeIntegridad {
        var respuesta= new Respuesta();
        if(respuestaRepository.existsById(id)) {
            respuesta = respuestaRepository.getReferenceById(id);
        }else{
            throw new ValidacionDeIntegridad("[!] ID respuesta no encontrado");
        }
        respuesta.actualizarRespuesta(datos);
        return ResponseEntity.ok(datos);
    }

    @DeleteMapping("/respuesta/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id) {
        if(respuestaRepository.existsById(id)){
            respuestaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{throw new ValidacionDeIntegridad("[!] ID respuesta no encontrado");}

    }
}
