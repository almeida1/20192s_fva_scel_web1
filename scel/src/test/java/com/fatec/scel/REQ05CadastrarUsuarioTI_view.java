package com.fatec.scel;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(REQ05CadastrarUsuarioTI_view.class)
public class REQ05CadastrarUsuarioTI_view {
	@Autowired
	private MockMvc mvc;

	@Test
	public void test() throws Exception{
		mvc.perform( MockMvcRequestBuilders
			      .get("/edit/{ra}", "1111") //Redirected URL = http://localhost/login
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk()) // esperado 200 retorna Status = 302
			      .andExpect(MockMvcResultMatchers.jsonPath("$.ra").value("1111"));
	}

}
