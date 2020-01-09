package com.fatec.scel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fatec.scel.model.Usuario;
import com.fatec.scel.model.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class REQ05CadastrarUsuarioTI_service {
	@Autowired
	UsuarioService service;

	@Test
	public void CT01CadastrarUsuarioComSucesso() {

		Usuario umUsuario = new Usuario("1111", "Jose da Silva", "jose@gmail.com", "123", "03166-000");
		try {
			Usuario resultadoObtido = null;
			resultadoObtido = service.salvar(umUsuario);
			System.out.println(resultadoObtido.getSenha());
			assertNotNull(resultadoObtido);
		} catch (Exception e) {
			fail("nao deveria falhar");
			System.out.println(e.getMessage());
		}

	}
	@Test
	public void CT02CadastrarUsuario_ja_cadastrado() {
        //insert into usuario values (1, '3166-000','1111' , 'jose@gmail.com','rua taquari', '1111', '1243')
		Usuario umUsuario = new Usuario("1111", "Jose da Silva", "jose@gmail.com", "123", "03166-000");
		try {
			Usuario resultadoObtido = null;
			service.salvar(umUsuario);
			resultadoObtido = service.salvar(umUsuario);//deve retornar nulo usuario ja cadastrado
			assertNull(resultadoObtido);
		} catch (Exception e) {
			fail("nao deveria falhar");
			System.out.println(e.getMessage());
		}

	}
	@Test
	public void CT03CadastrarUsuarioCom_cep_branco() {
		String cep = "";
		try {
			service.obtemEndereco(cep);
		} catch (Exception e) {
			assertEquals("400 Bad Request", e.getMessage());
		}
	}

	@Test
	public void CT04CadastrarUsuarioCom_cep_inexistente() {
		String cep = "1";
		try {
			service.obtemEndereco(cep);
		} catch (Exception e) {
			assertEquals("400 Bad Request", e.getMessage());
		}
	}

	@Test
	public void CT05CadastrarUsuarioComSucesso_cep_valido() {
		String cep = "03166-000";
		String logradouro = service.obtemEndereco(cep);
		assertEquals("Rua Taquari", logradouro);

	}

}
