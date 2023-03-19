package com.arthur.controle.models;

import java.time.LocalDateTime;
import java.util.UUID;

import com.arthur.controle.enums.StatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String de;

    private String para;

    private String assunto;

    @Column(columnDefinition = "TEXT")
    private String texto;

    private LocalDateTime dataEnvio;

    private StatusEnum status;
}
