package per.taller.todotic.app.service;

import java.util.Optional;

import per.taller.todotic.app.model.entity.Usuario;

public interface IUsuarioService {
	
	/*
	 * validar por nombre de usuario
	 */
	Optional<Usuario> findOneByUsername(String username);

	/*
	 * validar existe usuario
	 */
	public Boolean existsByUsername(String username);

}
