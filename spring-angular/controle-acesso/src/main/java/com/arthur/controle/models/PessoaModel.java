package com.arthur.controle.models;

import java.time.LocalDateTime;
import java.util.UUID;

import com.arthur.controle.enums.EspecieEnum;
import com.arthur.controle.enums.NivelEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_PESSOA")
public class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 128)
    private String nome;

    @Column(nullable = false)
    private int idade;

    @Column(nullable = false)
    private EspecieEnum especie;

    @Column(nullable = false, length = 128)
    private String poder;

    @Column(nullable = false)
    private NivelEnum nivel;

    @Column(nullable = false)
    private LocalDateTime dataEntrada;

    private LocalDateTime dataSaida;

    @Column(nullable = false, length = 128)
    private String email;
}
