package per.taller.todotic.app.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
public class Contacto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	@Column(name = "apellidos")
	private String apellido;
	@Column(name = "nombre_completo")
	private String nombreCompleto;
	private String celular;
	private String email;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaNacimiento;
	private LocalDateTime fechaRegistro;
	@Column(name = "fecha_act")
	private LocalDateTime fechaActualizacion;

	@PrePersist
	public void asignarFechaRegistro() {
		this.fechaRegistro = LocalDateTime.now();
		this.nombreCompleto = this.nombre + " " + this.apellido;
	}

	@PreUpdate
	private void preUpdate() {
		this.nombreCompleto = this.nombre + " " + this.apellido;
		this.fechaActualizacion = LocalDateTime.now();
	}

	private static final long serialVersionUID = -2602368943757906522L;

}
