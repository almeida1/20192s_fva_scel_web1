package com.fatec.scel;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fatec.scel.model.Usuario;

public class UserSS implements UserDetails {
	private Long id;
	private String email;
	private String senha;
	private int perfil;

	public UserSS() {
	}

	public UserSS(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.perfil = usuario.getPerfil();
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}
    public int getPerfil() {
    	return perfil;
    }
	@Override
	public boolean isAccountNonExpired() {
		// por padrao nao expira
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// por padrao nao esta bloqueada
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// por padrao nao esta expirada
		return true;
	}

	@Override
	public boolean isEnabled() {
		// por padrao esta habilitada
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

}
