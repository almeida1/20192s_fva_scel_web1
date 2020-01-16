package com.fatec.scel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.scel.model.Usuario;
import com.fatec.scel.model.UsuarioRepository;
import com.fatec.scel.model.UsuarioService;

@Controller
public class LoginController {
	@Autowired
	UsuarioRepository repo;
	@Autowired
	UsuarioService service;
	@Autowired
	BCryptPasswordEncoder pe;

	// Login form
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	// Login form with error
	@RequestMapping("/login-error")
	public String loginError(ModelAndView model) {
		model.addObject("loginError", true);
		return "login";
	}


}
