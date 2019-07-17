package br.com.renatoandrade.ragerenciadortarefas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.renatoandrade.ragerenciadortarefas.modelos.Usuario;

public interface RepositorioUsuario extends JpaRepository < Usuario, Long>{

	Usuario findByEmail(String email);
	
}
