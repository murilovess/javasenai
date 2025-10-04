package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula.model.UsuarioModel;
import com.example.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> listarTodos(){
        return usuarioRepository.findAll();
    }

    public UsuarioModel salvar(UsuarioModel usuario){

        if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){

            throw new IllegalArgumentException("Usuario ja cadastrado.");

        }
        return usuarioRepository.save(usuario);
    } 
}
