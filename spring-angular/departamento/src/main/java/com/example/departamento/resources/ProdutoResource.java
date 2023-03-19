package com.example.departamento.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.departamento.entities.Produto;
import com.example.departamento.repositories.ProdutoRepository;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
    @Autowired
	private ProdutoRepository produtoRepository;

    @GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> listaProdutos = produtoRepository.findAll();
		return ResponseEntity.ok().body(listaProdutos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(produtoRepository.findById(id).get());
	}
}
