package com.example.departamento.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.departamento.entities.Empregado;
import com.example.departamento.repositories.EmpregadoRepository;

@RestController
@RequestMapping(value = "/empregados")
public class EmpregadoResource {
    @Autowired
	private EmpregadoRepository empregadoRepository;

    @GetMapping
	public ResponseEntity<List<Empregado>> findAll() {
		List<Empregado> listaEmpregados = empregadoRepository.findAll();
		return ResponseEntity.ok().body(listaEmpregados);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Empregado> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(empregadoRepository.findById(id).get());
	}
}
