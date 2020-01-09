package com.fatec.scel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fatec.scel.model.UsuarioService;
import com.fatec.scel.model.Usuario;
import com.fatec.scel.model.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class REQ05CadastrarUsuarioTI_repository {

	@Autowired
	UsuarioRepository repository;
	@Autowired
	UsuarioService servico;

	@Test
	public void CT01CadastrarUsuarioComSucesso() {
		// dado que não existe nenhum usuario cadastrado
		repository.deleteAll();
	    // quando o usuario inclui um aluno valido
		repository.save(new Usuario("aaaa", "Jose da Silva", "jose@gmail.com","123","04280-130"));
		// então - a quantidade de usuarios cadastrados é igual 1
		final List<Usuario> todos = (List<Usuario>) repository.findAll();
		assertEquals(1, todos.size());
		repository.deleteAll();
	}
	@Test
	public void CT02CadastrarUsuarioComSucesso() {
		// dado que não existe nenhum usuario cadastrado
		repository.deleteAll();
	    // quando o usuario inclui um aluno valido
		Usuario usuario = new Usuario("aaaa", "Jose da Silva", "jose@gmail.com","123","03166-000");
		usuario.setEndereco(servico.obtemEndereco(usuario.getCep()));
		assertNotNull(repository.save(usuario));
		
		// então - o endereco com base no cep é obtido dos correios
		Usuario usuarioRO = repository.findByRa("aaaa");
		assertThat(usuarioRO.getEndereco()).isEqualTo("Rua Taquari");
	}
	
}