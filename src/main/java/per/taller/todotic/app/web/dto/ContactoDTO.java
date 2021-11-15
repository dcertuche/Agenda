package per.taller.todotic.app.web.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent
	@NotNull
	private LocalDate fechaNacimiento;

}
