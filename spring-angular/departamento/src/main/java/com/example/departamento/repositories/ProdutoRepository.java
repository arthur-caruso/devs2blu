package com.example.departamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.departamento.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {}