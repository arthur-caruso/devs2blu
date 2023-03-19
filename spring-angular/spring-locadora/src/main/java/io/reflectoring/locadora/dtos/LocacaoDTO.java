package io.reflectoring.locadora.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LocacaoDTO {
	@Size(max = 64)
	@NotBlank
	private String nomeVideo;

	@Email
    @NotBlank
    private String emailLocatario;
}
