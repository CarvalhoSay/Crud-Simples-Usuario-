package com.saymondev.crud_cadastro.controller;

import com.saymondev.crud_cadastro.business.UsuarioService;
import com.saymondev.crud_cadastro.infrastructure.DTOs.UsuarioDTO;
import com.saymondev.crud_cadastro.infrastructure.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Void> salvarUsuario (@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();

        usuario.setName(usuarioDTO.name());
        usuario.setEmail(usuarioDTO.email());

        usuarioService.salvarUsuario(usuario);

       return ResponseEntity.ok().build();

    }


    @GetMapping
    public ResponseEntity<Usuario> findByEmail (@RequestParam String email){
       Usuario usuario = usuarioService.findByEmail(email);
       return ResponseEntity.ok().body(usuario);

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByEmail (@RequestParam String email){

        usuarioService.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> AtualizarUsuario (@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO) {



        usuarioService.atualizarUsuarioPorId(id, usuarioDTO);
        return ResponseEntity.ok().build();

    }

}
