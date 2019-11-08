package com.fatec.scel;


import org.apache.tomcat.util.http.parser.MediaType;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fatec.scel.model.Livro;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class REQ01CadastrarLivroMVC2 {
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void createEmployeeAPI() throws Exception {
//	  mockMvc.perform( MockMvcRequestBuilders
//	      .post("/livros/cadastrar")
//	      .content(asJsonString(new Livro("1111", "Teste de Software", "Delamaro"))
//	      .contentType(MediaType.APPLICATION_JSON)
//	      .accept(MediaType.APPLICATION_JSON)));
	      
	}
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}  
}
