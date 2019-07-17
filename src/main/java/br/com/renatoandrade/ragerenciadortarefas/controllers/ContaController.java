package br.com.renatoandrade.ragerenciadortarefas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.renatoandrade.ragerenciadortarefas.modelos.Usuario;
import br.com.renatoandrade.ragerenciadortarefas.servicos.ServicoUsuario;

@Controller
public class ContaController {

	@Autowired
	private ServicoUsuario servicoUser;
	
	@GetMapping("/login")
	public String login() {
		return ("/conta/login");
	}
	
	@GetMapping("/registration")
	public ModelAndView registrar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("conta/registrar");
		mv.addObject("usuario", new Usuario());
		return mv;
	}
	
	@PostMapping("/registration")
	public ModelAndView registrar(@Valid Usuario user, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		Usuario us = servicoUser.encontrarPorEmail(user.getEmail());
		if(us != null ) {
			result.rejectValue("email", "","Usuario ja cadastrado");
		}
		if(result.hasErrors()) {
			mv.setViewName("conta/registrar");
			mv.addObject("usuario",user);
		}else {
			servicoUser.adicionarUsuario(user);
			mv.setViewName("redirect:/login");
			
		}
		return mv;
	}
	
}
