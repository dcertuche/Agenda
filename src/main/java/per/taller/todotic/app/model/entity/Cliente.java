package per.taller.todotic.app.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	@Column(name = "id_sap")
	private Long id;
	private String nombre;
	private String apellido;
	private String nombreCompleto;
	private Long numeroProducto;
	private String gerente;
	@Enumerated(EnumType.STRING)
	private Estado estado;

	public enum Estado {
		ACTIVO, CANCELADO
	}

	private static final long serialVersionUID = -2366342517173725857L;

}
