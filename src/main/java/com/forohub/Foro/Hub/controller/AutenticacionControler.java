package com.forohub.Foro.Hub.controller;

import com.forohub.Foro.Hub.domain.usuario.DatosAutenticacionUsuario;
import com.forohub.Foro.Hub.domain.usuario.Usuario;
import com.forohub.Foro.Hub.security.DatosJWTToken;
import com.forohub.Foro.Hub.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionControler {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuarios){
        Authentication authtoken = new UsernamePasswordAuthenticationToken(
                datosAutenticacionUsuarios.email(), datosAutenticacionUsuarios.password());
        var authUser = authenticationManager.authenticate(authtoken);
        var JWTtoken = tokenService.generarToken((Usuario) authUser.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}
