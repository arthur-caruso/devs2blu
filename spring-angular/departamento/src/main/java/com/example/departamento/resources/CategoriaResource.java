package com.example.departamento.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.departamento.entities.Categoria;
import com.example.departamento.repositories.CategoriaRepository;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    @Autowired
	private CategoriaRepository categoriaRepository;

    @GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		return ResponseEntity.ok().body(listaCategorias);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(categoriaRepository.findById(id).get());
	}
}
