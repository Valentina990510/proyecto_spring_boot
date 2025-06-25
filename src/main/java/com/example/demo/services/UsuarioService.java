package com.example.demo.services;

import com.example.demo.entity.Usuarios;
import com.example.demo.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    public Usuarios insertar(Usuarios usuarios){
        return usuarioRepo.save(usuarios);
    }

    public Usuarios actualizar(Usuarios usuarios){
        return usuarioRepo.save(usuarios);
    }

    public List<Usuarios> listar(){
        return usuarioRepo.findAll();
    }

    public void eliminar(Usuarios usuarios){
        usuarioRepo.delete(usuarios);
    }


}
