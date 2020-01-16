package com.fatec.scel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fatec.scel.model.Usuario;
import com.fatec.scel.model.UsuarioRepository;
public class AuthenticationService implements UserDetailsService {
    @Autowired
    private UsuarioRepository repo;
	
    @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario umUsuario = repo.findByEmail(email);
		if (umUsuario == null) {
			throw new UsernameNotFoundException("Usuario não encotrado");
		}
		return null ;
	}

}
