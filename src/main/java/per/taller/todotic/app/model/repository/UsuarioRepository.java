package per.taller.todotic.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import per.taller.todotic.app.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
