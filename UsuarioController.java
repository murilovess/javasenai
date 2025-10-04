package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula.model.UsuarioModel;
import com.example.service.UsuarioService;
import com.example.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioModel> listar(){
        return usuarioService.listarTodos();
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody UsuarioModel usuario){

        usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Cadastrado com sucesso..."));  
      } 



}
