package com.arthur.controle.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDTO {

    @NotBlank
    @Email
    private String de;

    @NotBlank
    @Email
    private String para;

    @NotBlank
    private String assunto;

    @NotBlank
    private String texto;

}
