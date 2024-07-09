package com.forohub.Foro.Hub.controller;

import com.forohub.Foro.Hub.domain.usuario.DatosRegistroUsuario;
import com.forohub.Foro.Hub.domain.usuario.Usuario;
import com.forohub.Foro.Hub.domain.usuario.UsuarioRepository;
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


@RestController
@RequestMapping("/login")

public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroUsuario datos, UriComponentsBuilder uriBuilder) {
        var usuario = new Usuario(datos);
        if(repository.existsByEmail(usuario.getEmail())) {
            throw new ValidacionDeIntegridad("[!] Usuario ya registrado");
        }else {
            repository.save(usuario);
        }
        var uri = uriBuilder.path("/register/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new Usuario(datos));
    }

}
