package com.fatec.scel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping(path = "/emprestimos")
public class EmprestimoController {
	/**
	 * quando o usuario digita localhost:8080/emprestimo/cadastrar
	 * 
	 * @param livro
	 * @return o html /CadastraLivro
	 */
	@GetMapping("/cadastrar")
	public ModelAndView registrarEmprestimo(String isbn, String usuario) {

		ModelAndView mv = new ModelAndView("RegistrarEmprestimo");
		mv.addObject("isbn", isbn);

		return mv;
	}
}
