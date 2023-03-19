package com.arthur.controle.repositories;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arthur.controle.enums.NivelEnum;
import com.arthur.controle.models.PessoaModel;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, UUID> {
    @Query("SELECT p FROM PessoaModel p WHERE p.nivel = ?1")
    List<PessoaModel> findAllByNivel(NivelEnum nivel);
}
