package br.usp.ime.academicdevoir.controller;
import br.usp.ime.academicdevoir.entidade.Usuario;
import br.usp.ime.academicdevoir.infra.Privilegio;

public class Given {

	public Usuario novoUsuario() {
		Usuario usuario = new Usuario();
		usuario.setLogin("alunor");
		usuario.setEmail("usuarior@ime.usp.br");
		usuario.setPrivilegio(Privilegio.ALUNO);
		usuario.setSenha("alunor");
		return usuario;
	}

}
