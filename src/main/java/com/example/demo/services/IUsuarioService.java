package com.example.demo.services;

import com.example.demo.entity.UsuariosEntity;

import java.util.List;

public interface IUsuarioService  {
    public List<UsuariosEntity> listarUsuarios();

    public void insertarUsuario(UsuariosEntity usuarios);

    public void eliminarUsuario(int id);

    public void actualizarUsuarios(int id,UsuariosEntity usuariosEntity);
}
