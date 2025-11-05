package com.saymondev.crud_cadastro.business;


import com.saymondev.crud_cadastro.infrastructure.DTOs.UsuarioDTO;
import com.saymondev.crud_cadastro.infrastructure.entities.Usuario;
import com.saymondev.crud_cadastro.infrastructure.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

   private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository repository) {
        this.usuarioRepository = repository;
    }

    public void salvarUsuario(Usuario usuario){
        usuarioRepository.saveAndFlush(usuario);
    }

    public Usuario findByEmail(String email){
       return usuarioRepository.findByEmail(email)
               .orElseThrow(() -> new RuntimeException("Email nao encontrado!"));
    }

    public void deleteByEmail (String email){
        usuarioRepository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorId(Integer id, UsuarioDTO usuarioDTO){

        Usuario user = usuarioRepository.findById((id)).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));


        if(usuarioDTO.name() != null || usuarioDTO.name().isBlank() ) {user.setName(usuarioDTO.name());}
        if(usuarioDTO.email() != null || usuarioDTO.name().isBlank()) {user.setEmail(usuarioDTO.email());}

       usuarioRepository.saveAndFlush(user);

    }




}


