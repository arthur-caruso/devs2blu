package io.reflectoring.locadora.dtos;

import java.time.Duration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VideoDTO {
	@Size(max = 64)
	@NotBlank
	private String nomeGenero;

	@Size(max = 64)
	@NotBlank
	private String nome;

	@Size(max = 16)
	@NotBlank
	private String formato;

	private Double preco;
	private Duration duracao;
    private Integer exemplares;
}
