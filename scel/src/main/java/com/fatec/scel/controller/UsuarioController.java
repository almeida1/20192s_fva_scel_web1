package com.fatec.scel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.fatec.scel.model.Usuario;
import com.fatec.scel.model.UsuarioRepository;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;

	@GetMapping("/consulta")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ConsultarUsuario");
		modelAndView.addObject("usuarios", repository.findAll());
		return modelAndView;
	}
	@GetMapping("/cadastrar")
	public ModelAndView cadastraUsuario(Usuario usuario) {

		ModelAndView mv = new ModelAndView("CadastrarUsuario");
		mv.addObject("usuario", usuario);

		return mv;
	}
	@PostMapping("/save")
	public ModelAndView save(@Valid Usuario usuario, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("ConsultarUsuario");
		if (result.hasErrors()) {
			return new ModelAndView("CadastrarUsuario");
		}
		try {
			Usuario jaExiste=null;
			jaExiste = repository.findByRa(usuario.getRa());
			if (jaExiste == null) {
				repository.save(usuario);
				modelAndView = new ModelAndView("ConsultarUsuario");
				modelAndView.addObject("usarios", repository.findAll());
				return modelAndView;
			} else {
				return new ModelAndView("CadastrarUsuario");
			}
		} catch (Exception e) {
			System.out.println("erro ===> " +e.getMessage());
			return modelAndView; // captura o erro mas nao informa o motivo.
		}
	}
}
