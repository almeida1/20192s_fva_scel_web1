package com.fatec.scel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ REQ01CadastrarLivro.class, 
	            REQ01CadastrarLivroMVC.class,
	            REQ02ConsultarLivro.class, 
	            REQ05CadastrarUsuario.class,
		        REQ09RegistrarEmprestimo.class, 
		        ScelApplicationTests.class })
public class AllTests {

}
