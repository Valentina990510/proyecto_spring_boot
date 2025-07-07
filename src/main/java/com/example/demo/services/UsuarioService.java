package com.example.demo.services;

import com.example.demo.entity.UsuariosEntity;
import com.example.demo.repo.UsuarioRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void eliminarUsuario(int id){
        Optional<UsuariosEntity> usuario = usuarioRepo.findById(id);
        if(usuario.isPresent()){
            usuarioRepo.delete(usuario.get());
        } else {
            throw new EntityNotFoundException("Usuario no encontrado");

        }
    }

    @Override
    public void actualizarUsuarios(int id, UsuariosEntity usuarios ) {
        Optional<UsuariosEntity> usuario = usuarioRepo.findById(id);
        if (usuario.isPresent()) {
            UsuariosEntity existente = usuario.get();
            existente.setNombre(usuarios.getNombre()== null ? existente.getNombre() : usuarios.getNombre());
            existente.setEdad (usuarios.getEdad() == 0  ? existente.getEdad() : usuarios.getEdad());
            existente.setGenero(usuarios.getGenero() == null ? existente.getGenero(): usuarios.getGenero());
            existente.setCiudad(usuarios.getCiudad() == null ? existente.getCiudad() : usuarios.getCiudad());
            usuarioRepo.save(existente);
        } else {
            System.out.println("no existe usuario");
            throw new EntityNotFoundException("Usuario no encontrado");
        }

    }

}
