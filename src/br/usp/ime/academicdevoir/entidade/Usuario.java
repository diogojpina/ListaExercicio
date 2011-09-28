package br.usp.ime.academicdevoir.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.usp.ime.academicdevoir.infra.Privilegio;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Usuario {
	
	@Id @GeneratedValue
	private Long id;
	private String nome;
	private String login;
	private String senha;
	private String email;
	private Privilegio privilegio;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Privilegio getPrivilegio() {
		return privilegio;
	}
	public void setPrivilegio(Privilegio privilegio) {
		this.privilegio = privilegio;
	}

}