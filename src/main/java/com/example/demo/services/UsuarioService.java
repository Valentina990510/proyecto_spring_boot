package com.example.demo.services;

import com.example.demo.entity.UsuariosEntity;
import com.example.demo.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {


    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public void insertarUsuario(UsuariosEntity usuarios){
         usuarioRepo.save(usuarios);
    }


    @Override
    public List<UsuariosEntity> listarUsuarios(){
        List<UsuariosEntity> usuarios= usuarioRepo.findAll();
        return usuarios;
    }

    @Override
    public void eliminarUsuario(UsuariosEntity usuarios){
        usuarioRepo.delete(usuarios);
    }

    @Override
    public UsuariosEntity actualizarUsuarios(int id) {
       UsuariosEntity usuarios = usuarioRepo.findById(id).orElse(null);
       return  usuarios;
    }


}
