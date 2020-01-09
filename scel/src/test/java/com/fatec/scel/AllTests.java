package com.fatec.scel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ REQ01CadastrarLivro_TI_repository.class, 
	            REQ01CadastrarLivro_TI_service.class,
	            REQ02ConsultarLivro.class, 
	            REQ05CadastrarUsuarioTI_repository.class,
	            REQ05CadastrarUsuarioTI_service.class,
		        REQ09RegistrarEmprestimo.class, 
		        ScelApplicationTests.class })
public class AllTests {

}
