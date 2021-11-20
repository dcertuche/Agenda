package per.taller.todotic.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import per.taller.todotic.app.exception.BadRequestException;
import per.taller.todotic.app.model.entity.Rol;
import per.taller.todotic.app.model.entity.Usuario;
import per.taller.todotic.app.model.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final PasswordEncoder passwordEncoder;
	private final UsuarioRepository usuarioRepository;

	public AuthController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/registrar")
	void registrarUsuario(@RequestBody @Validated Usuario usuario) {
		boolean userNameExiste = usuarioRepository.existsByUsername(usuario.getUsername());

		if (userNameExiste) {
			throw new BadRequestException("El user name ya fue registrado para otro usuario.");
		}
		String password = passwordEncoder.encode(usuario.getPasswordPlain());
		usuario.setPassword(password);
		List<Rol> roles = new ArrayList<Rol>();
		roles.add(new Rol("USER"));
		usuario.setRoles(roles);

		usuarioRepository.save(usuario);
	}

	@GetMapping("/verificar-username")
	Map<String, Boolean> verificarEmail(@RequestParam String username) {
		boolean usernameExiste = usuarioRepository.existsByUsername(username);
		Map<String, Boolean> result = new HashMap<>();
		result.put("exists", usernameExiste);

		return result;
	}

}
