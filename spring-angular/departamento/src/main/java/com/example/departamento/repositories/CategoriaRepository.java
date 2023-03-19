package com.example.departamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.departamento.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}