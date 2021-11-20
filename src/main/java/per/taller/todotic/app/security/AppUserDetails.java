package per.taller.todotic.app.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import per.taller.todotic.app.model.entity.Rol;
import per.taller.todotic.app.model.entity.Usuario;

public class AppUserDetails implements UserDetails {

	private Logger logger = LoggerFactory.getLogger(AppUserDetails.class);
	
	private final Long id;
	private final String name;
	private final String username;
	private final String password;
	private final List<Rol> rol;
	private final List<GrantedAuthority> grantedAuthorities;

	public AppUserDetails(Usuario usuario) {
		id = usuario.getId();
		name = usuario.getNombres();
		username = usuario.getUsername();
		password = usuario.getPassword();
		rol = usuario.getRoles();
		grantedAuthorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		 
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Rol> getRol() {
		return rol;
	}

	private static final long serialVersionUID = 1L;

}
