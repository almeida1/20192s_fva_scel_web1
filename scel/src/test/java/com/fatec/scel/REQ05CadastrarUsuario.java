package com.fatec.scel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.fatec.scel.model.Usuario;
import com.fatec.scel.model.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class REQ05CadastrarUsuario {

	@Autowired
	UsuarioRepository repository;

	@Test
	public void CT01CadastrarUsuarioComSucesso() {
		// dado que não existe nenhum livro cadastrado
		repository.deleteAll();
	    // quando o usuario inclui um livro valido
		repository.save(new Usuario("aaaa", "Jose da Silva", "jose@gmail.com","04280-130","Rua Frei João, 59"));
		// então - a quantidade de livros cadastrados é igual 1
		final List<Usuario> todos = (List<Usuario>) repository.findAll();
		assertEquals(2, todos.size());
		repository.deleteById(1l);
	}
	@Test
	public void CT02CadastrarUsuarioComSucesso() {
		// dado que não existe nenhum livro cadastrado
		repository.deleteAll();
	    // quando o usuario inclui um livro valido
		repository.save(new Usuario("aaaa", "Jose da Silva", "jose@gmail.com","04280130",""));
		// então - a quantidade de livros cadastrados é igual 1
		Usuario usuarioRO=null;
		usuarioRO = repository.findByRa("aaaa");
		assertThat(usuarioRO).isNull();
		System.out.println(usuarioRO.getCep());
		assertThat(usuarioRO.getEndereco()).isEqualTo("Rua Frei João");
		
		
	}
}