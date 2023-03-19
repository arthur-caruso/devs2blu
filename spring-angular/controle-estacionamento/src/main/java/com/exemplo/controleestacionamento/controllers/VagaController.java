package com.exemplo.controleestacionamento.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.controleestacionamento.dtos.VagaDTO;
import com.exemplo.controleestacionamento.models.VagaModel;
import com.exemplo.controleestacionamento.services.VagaService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vagas")
public class VagaController {
	final VagaService vagaService;

	public VagaController(VagaService vagaService) {
		this.vagaService = vagaService;
	}

	@PostMapping
	public ResponseEntity<Object> saveVaga(@RequestBody @Valid VagaDTO vagaDTO) {
		if (vagaService.existsByNumeroVaga(vagaDTO.getNumeroVaga())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("CONFLICT: Vaga já está em uso!");
		}

		if (vagaService.existsByPlacaCarro(vagaDTO.getPlacaCarro())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("CONFLICT: Placa já consta no bd!");
		}

		var vagaModel = new VagaModel();
		BeanUtils.copyProperties(vagaDTO, vagaModel);
		vagaModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		vagaService.save(vagaModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(vagaModel);
	}

	@GetMapping
	public ResponseEntity<List<VagaModel>> getAllVagas() {
		return ResponseEntity.status(HttpStatus.OK).body(vagaService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getVaga(@PathVariable(value = "id") UUID id) {
		Optional<VagaModel> vagaModelOptional = vagaService.findById(id);

		if (!vagaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND: Vaga não encontrada!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(vagaModelOptional.get());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteVaga(@PathVariable(value = "id") UUID id) {
		Optional<VagaModel> vagaModelOptional = vagaService.findById(id);

		if (!vagaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND: Vaga não encontrada!");
		} else {
			vagaService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("OK: Vaga deletada com sucesso!");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateVaga(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid VagaDTO vagaDTO) {
		Optional<VagaModel> vagaModelOptional = vagaService.findById(id);

		if (!vagaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND: Vaga não encontrada!");
		} else {
			var vagaModel = vagaModelOptional.get();
			BeanUtils.copyProperties(vagaDTO, vagaModel);
			vagaModel.setId(vagaModelOptional.get().getId());
			vagaModel.setDataRegistro(vagaModelOptional.get().getDataRegistro());
			vagaService.save(vagaModel);
			return ResponseEntity.status(HttpStatus.OK).body(vagaModel);
		}
	}
}
