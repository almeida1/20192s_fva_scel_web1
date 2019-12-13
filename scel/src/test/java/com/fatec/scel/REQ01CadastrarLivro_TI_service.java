package com.fatec.scel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fatec.scel.model.Livro;
import com.fatec.scel.model.LivroService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class REQ01CadastrarLivro_TI_service {

	@Autowired
	LivroService livroService;

	@Test
	public void test() throws Exception {
		assertThat(livroService).isNotNull();
	}

	@Test
	public void CT01CadastrarLivroComSucesso() {
		Livro livro = new Livro("1111", "Teste de Software", "Delamaro");
		assertThat(livroService.salvar(livro)).isNotNull();
	}
}
