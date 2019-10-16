package com.fatec.scel;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fatec.scel.model.Livro;
import com.fatec.scel.model.LivroRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class REQ01CadastrarLivro {

	@Autowired
	LivroRepository repository;

	@Test
	public void CT01CadastrarLivroComSucesso() {
		// dado que não existe nenhum livro cadastrado
		repository.deleteAll();
	    // quando o usuario inclui um livro valido
		repository.save(new Livro("1111", "Teste de Software", "Delamaro"));
		// então - a quantidade de livros cadastrados é igual 1
		final List<Livro> todos = (List<Livro>) repository.findAll();
		assertEquals(1, todos.size());
		repository.deleteById(1l);
	}
	
}