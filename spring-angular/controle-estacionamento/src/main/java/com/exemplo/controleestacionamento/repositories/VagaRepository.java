package com.exemplo.controleestacionamento.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemplo.controleestacionamento.models.VagaModel;

@Repository
public interface VagaRepository extends JpaRepository<VagaModel, UUID> {
	boolean existsByNumeroVaga(String numeroVaga);
	boolean existsByPlacaCarro(String placaCarro);
}
