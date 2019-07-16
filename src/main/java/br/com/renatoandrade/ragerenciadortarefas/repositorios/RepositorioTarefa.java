package br.com.renatoandrade.ragerenciadortarefas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.renatoandrade.ragerenciadortarefas.modelos.Tarefa;

public interface RepositorioTarefa extends JpaRepository<Tarefa, Long>{

}
