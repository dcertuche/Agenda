package per.taller.todotic.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import per.taller.todotic.app.model.entity.Usuario;
import per.taller.todotic.app.model.repository.UsuarioRepository;

public class UsuarioServiceImpl implements IUsuarioService{
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Optional<Usuario> findOneByUsername(String username) {
		return null;
	}

	@Override
	public Boolean existsByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
