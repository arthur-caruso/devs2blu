package com.exemplo.controleestacionamento.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.exemplo.controleestacionamento.models.VagaModel;
import com.exemplo.controleestacionamento.repositories.VagaRepository;

import jakarta.transaction.Transactional;

@Service
public class VagaService {
	final VagaRepository vagaRepository;

	public VagaService(VagaRepository vagaRepository) {
		this.vagaRepository = vagaRepository;
	}

	@Transactional
	public void save(VagaModel vagaModel) {
		vagaRepository.save(vagaModel);
	}

	@Transactional
	public void deleteById(UUID id) {
		vagaRepository.deleteById(id);
	}

	public boolean existsByNumeroVaga(String numeroVaga) {
		return vagaRepository.existsByNumeroVaga(numeroVaga);
	}

	public boolean existsByPlacaCarro(String placaCarro) {
		return vagaRepository.existsByPlacaCarro(placaCarro);
	}

	public List<VagaModel> findAll() {
		return vagaRepository.findAll();
	}

	public Optional<VagaModel> findById(UUID id) {
		return vagaRepository.findById(id);
	}
}
