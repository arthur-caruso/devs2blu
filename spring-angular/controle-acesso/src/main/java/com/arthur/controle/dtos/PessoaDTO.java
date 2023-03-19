package com.arthur.controle.dtos;

import com.arthur.controle.enums.EspecieEnum;
import com.arthur.controle.enums.NivelEnum;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PessoaDTO {
    @NotBlank
    private String nome;

    @NotBlank
    private Integer idade;

    @NotBlank
    private EspecieEnum especie;

    @NotBlank
    private String poder;

    @NotBlank
    private NivelEnum nivel;

    @NotBlank
    @Email
    private String email;
}
