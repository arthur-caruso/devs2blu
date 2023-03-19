package com.example.departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.departamento.entities.Categoria;
import com.example.departamento.entities.Departamento;
import com.example.departamento.entities.Empregado;
import com.example.departamento.entities.Produto;
import com.example.departamento.repositories.CategoriaRepository;
import com.example.departamento.repositories.DepartamentoRepository;
import com.example.departamento.repositories.EmpregadoRepository;
import com.example.departamento.repositories.ProdutoRepository;

@SpringBootApplication
public class DepartamentoApplication implements CommandLineRunner {

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Autowired
	private EmpregadoRepository empregadoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(DepartamentoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Departamento d1 = new Departamento(null, "Móveis", 1);
		Departamento d2 = new Departamento(null, "Limpeza", 1);

		Empregado e1 = new Empregado(null, "Alice", 1500, d2);
		Empregado e2 = new Empregado(null, "Bob", 1500, d1);


		Categoria c1 = new Categoria(null, "Limpeza de Piscina", d2);
		Categoria c2 = new Categoria(null, "Ferramentas de Limpeza", d2);
		Categoria c3 = new Categoria(null, "Compensados", d1);


		Produto p1 = new Produto(null, "Cloro de piscina 200g", 150, c1);
		Produto p2 = new Produto(null, "Vassoura", 50, c2);
		Produto p3 = new Produto(null, "Mesa", 4, c3);
		Produto p4 = new Produto(null, "Cadeira", 24, c3);
		Produto p5 = new Produto(null, "Armário", 10, c3);

		d2.getEmpregados().add(e1);
		d1.getEmpregados().add(e2);
	
		d2.getCategorias().add(c1);
		d2.getCategorias().add(c2);
		d1.getCategorias().add(c3);
	
		c1.getProdutos().add(p1);
		c2.getProdutos().add(p2);
		c3.getProdutos().add(p3);
		c3.getProdutos().add(p4);
		c3.getProdutos().add(p5);

		departamentoRepository.save(d1);
		departamentoRepository.save(d2);

		empregadoRepository.save(e1);
		empregadoRepository.save(e2);

		categoriaRepository.save(c1);
		categoriaRepository.save(c2);
		categoriaRepository.save(c3);

		produtoRepository.save(p1);
		produtoRepository.save(p2);
		produtoRepository.save(p3);
		produtoRepository.save(p4);
		produtoRepository.save(p5);
	}
}
