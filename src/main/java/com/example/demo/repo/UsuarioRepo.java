package com.example.demo.repo;

import com.example.demo.entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<UsuariosEntity, Integer> {



}
