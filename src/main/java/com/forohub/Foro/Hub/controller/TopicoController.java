package com.forohub.Foro.Hub.controller;

import com.forohub.Foro.Hub.domain.curso.DetallesCurso;
import com.forohub.Foro.Hub.domain.topico.*;
import com.forohub.Foro.Hub.domain.usuario.DetallesUsuario;
import com.forohub.Foro.Hub.domain.usuario.Usuario;
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

@Controller
@RestController
@RequestMapping("/topico")
public class TopicoController {
    @Autowired
    private RegistroTopicoService service;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriBuilder) throws ValidacionDeIntegridad {
        String message;
        service.RegistrarNuevoTopico(datos);
        message = "Topico Guardado con exito!";
        return ResponseEntity.ok(message);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaTopicos>> listadoTopicos(@PageableDefault(size = 2, sort = {"id"}) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListaTopicos::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        var usuario = new DetallesUsuario(service.RetornarUsuario(topico.getUsuario().getId()));
        var curso = new DetallesCurso(service.RetornarCurso(topico.getCurso().getId()));
        return ResponseEntity.ok(new DetallesTopico(topico, usuario, curso));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionTopico datos, @PathVariable Long id)throws ValidacionDeIntegridad {
        var topico= new Topico();
        if(topicoRepository.existsById(id)) {
            topico = topicoRepository.getReferenceById(id);
        }else{
            throw new ValidacionDeIntegridad("[!] ID topico no encontrado");
        }
        var cursoFormato=service.verificarCurso(datos.curso());
        topico.actualizarTopico(datos, cursoFormato);
        var usuario = new DetallesUsuario(service.RetornarUsuario(topico.getUsuario().getId()));
        var curso = new DetallesCurso(service.RetornarCurso(topico.getCurso().getId()));
        return ResponseEntity.ok(new DetallesTopico(topico, usuario, curso));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id) {
        if(topicoRepository.existsById(id)){
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{throw new ValidacionDeIntegridad("[!] ID topico no encontrado");}

    }
}
