package com.example.demo.controller;

import com.example.demo.entity.Usuarios;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/obtener")
    public List<Usuarios> listar(){
        return usuarioService.listar();
    }

    @PostMapping("/crear")
    public Usuarios insertar(@RequestBody Usuarios usuarios){
        return usuarioService.insertar(usuarios);
    }

    @PutMapping("/actualizar")
    public Usuarios actualizar(@RequestBody Usuarios usuarios){
        return usuarioService.actualizar(usuarios);
    }

    @DeleteMapping("/borrar")
    public void eliminar(@RequestBody Usuarios usuarios){
         usuarioService.eliminar(usuarios);
    }

}
