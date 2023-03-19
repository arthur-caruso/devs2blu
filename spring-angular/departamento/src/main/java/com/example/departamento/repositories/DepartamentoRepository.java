package com.example.departamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.departamento.entities.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {   
}
