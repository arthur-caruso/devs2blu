package com.example.departamento.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.departamento.entities.Departamento;
import com.example.departamento.repositories.DepartamentoRepository;

@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoResource {
    @Autowired
	private DepartamentoRepository departamentoRepository;

    @GetMapping
	public ResponseEntity<List<Departamento>> findAll() {
		List<Departamento> listaDepartamentos = departamentoRepository.findAll();
		return ResponseEntity.ok().body(listaDepartamentos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Departamento> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(departamentoRepository.findById(id).get());
	}
}
