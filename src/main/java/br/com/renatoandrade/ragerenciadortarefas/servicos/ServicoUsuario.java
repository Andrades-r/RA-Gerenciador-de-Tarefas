package br.com.renatoandrade.ragerenciadortarefas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.renatoandrade.ragerenciadortarefas.modelos.Usuario;
import br.com.renatoandrade.ragerenciadortarefas.repositorios.RepositorioUsuario;

@Service
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public Usuario encontrarPorEmail(String email){
		return repositorioUsuario.findByEmail(email);
	}
	
	public void adicionarUsuario(Usuario user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repositorioUsuario.save(user);
	}
	
}
