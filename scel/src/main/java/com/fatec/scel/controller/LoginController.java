package com.fatec.scel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginController {
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
