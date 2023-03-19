package io.reflectoring.locadora.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDTO {
    @NotBlank
    private String ownerRef;

    @Email
    @NotBlank
    private String emailFrom;

    @Email
    @NotBlank
    private String emailTo;

    @NotBlank
    private String subject;

    @NotBlank
    private String text;
}
