package per.taller.todotic.app.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class ContactoDTO {

	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	@NotBlank
	private String celular;
	@NotEmpty
	@Email
	private String email;
	@NotBlank
	private String direccion;

}
