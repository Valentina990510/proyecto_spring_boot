package com.example.demo.controller;

import com.example.demo.entity.UsuariosEntity;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/api/usuarios")
    public List<UsuariosEntity> listar(){
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/api/usuarios")
    public void insertar(@RequestBody UsuariosEntity usuarios){
      usuarioService.insertarUsuario(usuarios);
    }

    @PutMapping("/api/usuarios/{id}")
    public void actualizar(@PathVariable int id, @RequestBody UsuariosEntity usuarios){
         usuarioService.actualizarUsuarios(id,usuarios);
    }

    @DeleteMapping("/api/usuarios/{id}")
    public void eliminar(@PathVariable @RequestBody int id){
         usuarioService.eliminarUsuario(id);
    }


}
