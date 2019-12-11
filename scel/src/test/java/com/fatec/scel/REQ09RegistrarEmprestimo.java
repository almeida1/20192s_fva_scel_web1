package com.fatec.scel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fatec.scel.model.Emprestimo;
import com.fatec.scel.model.EmprestimoRepository;
import com.fatec.scel.model.UsuarioServico;

@RunWith(SpringRunner.class)
@DataJpaTest //suporte do h2
public class REQ09RegistrarEmprestimo {

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	

	@Test
	public void CT01_saveComDadosNuloDeveLancarException() throws Exception {
		try {
			Emprestimo emprestimo = new Emprestimo(null, null);
			
		}catch(Exception e) {
			assertEquals("Dados inválidos.",e.getMessage());
		}
		
	}
	@Test
	public void CT02_saveComSucessoNotNull() throws Exception {
		
        Emprestimo emprestimo=null;
        emprestimo = new Emprestimo("1111","aaaa");
		emprestimo = emprestimoRepository.save(emprestimo);
   		assertNotNull(emprestimo);
	}
	@Test
	public void CT03_saveConsultaComSucesso() throws Exception {
		Emprestimo emprestimo=null;
        emprestimo = new Emprestimo("1111","aaaa");
		emprestimo = emprestimoRepository.save(emprestimo);
		List<Emprestimo> emprestimos = (List<Emprestimo>) emprestimoRepository.findAll();
		Assert.assertEquals(1, emprestimos.size());
		emprestimoRepository.deleteAll();
	}
	
	@Test
	public void CT04_saveConsultaComSucesso() throws Exception {
		Emprestimo emprestimo=null;
        emprestimo = new Emprestimo("1111","aaaa");
		emprestimo = emprestimoRepository.save(emprestimo);
		List<Emprestimo> emprestimos = (List<Emprestimo>) emprestimoRepository.findAll();
		Assert.assertEquals(1, emprestimos.size());
		System.out.println(emprestimo.toString());
		emprestimoRepository.deleteAll();
	}

}