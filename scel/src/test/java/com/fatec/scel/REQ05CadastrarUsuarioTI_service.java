package com.fatec.scel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fatec.scel.model.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class REQ05CadastrarUsuarioTI_service {
	@Autowired
	UsuarioService service;

	@Test
	public void CT01CadastrarUsuarioComSucesso_cep_branco() {
		String cep = "";
		try {
			service.obtemEndereco(cep);
		} catch (Exception e) {
			assertEquals("400 Bad Request", e.getMessage());
		}
	}

	@Test
	public void CT01CadastrarUsuarioComSucesso_cep_inexistente() {
		String cep = "1";
		try {
			service.obtemEndereco(cep);
		} catch (Exception e) {
			assertEquals("400 Bad Request", e.getMessage());
		}
	}

	@Test
	public void CT01CadastrarUsuarioComSucesso_cep_valido() {
		String cep = "03166-000";
		String logradouro = service.obtemEndereco(cep);
		assertEquals("Rua Taquari", logradouro);

	}

}
