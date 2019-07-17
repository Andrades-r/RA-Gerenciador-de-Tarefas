package br.com.renatoandrade.ragerenciadortarefas.modelos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="usr_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="usr_id")
	private Long id;
	
	@Column(name="usr_email", nullable = false, length = 100)
	@NotNull(message="E-mail Obrigatório")
	@Length(min=5, max=100, message="Email deve possuir entre 5 e 100 caracteres")
	private String email;

	@Column(name="usr_password", nullable = false, length = 100)
	@NotNull(message="Senha Obrigatório")
	private String password;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
