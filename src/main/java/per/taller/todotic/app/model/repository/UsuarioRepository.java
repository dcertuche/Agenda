package per.taller.todotic.app.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import per.taller.todotic.app.model.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Optional<Usuario> findByUsername(String name);
	boolean existsByUsername(String name);

}
