package io.reflectoring.locadora.models;

import java.io.Serializable;
import java.time.Duration;
import java.util.UUID;

import io.reflectoring.locadora.enums.GeneroEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tb_video")
public class VideoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
	private GeneroEnum genero;

	@Column(nullable = false, unique = true, length = 64)
	private String nome;

	@Column(nullable = false, length = 16)
	private String formato;

	@Column(nullable = false)
	private Double preco;

	@Column(nullable = false)
	private Duration duracao;

    @Column(nullable = false)
    private Integer exemplares;
}

