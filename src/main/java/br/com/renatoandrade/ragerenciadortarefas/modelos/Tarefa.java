package br.com.renatoandrade.ragerenciadortarefas.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tar_tarefas")
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tar_id")
	private Long id;
	
	@Column(name = "tar_title", length = 50, nullable= false)
	@NotNull(message = "O titulo e obrigatorio")
	@Length(max = 50, min = 3, message="O titulo deve possuir ao menos 3 caracteres e no maximo 50")
	private String title;
	
	@Column(name = "tar_description", length = 100, nullable= true)
	@Length(max=100,message="descricao deve conter ate 100 caracteres")
	private String description;
	
	@Column(name = "tar_expiration", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expiration;
	
	@Column(name = "tar_completed", nullable= false)
	private Boolean completed = false;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public Boolean isCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

}
