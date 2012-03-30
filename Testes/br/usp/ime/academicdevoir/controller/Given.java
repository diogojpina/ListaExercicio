package br.usp.ime.academicdevoir.controller;

import br.usp.ime.academicdevoir.entidade.Aluno;
import br.usp.ime.academicdevoir.entidade.Usuario;
import br.usp.ime.academicdevoir.infra.Privilegio;

public class Given {

	public static Usuario novoUsuario() {
		
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario.setLogin("alunor");
		usuario.setEmail("usuarior@ime.usp.br");
		usuario.setPrivilegio(Privilegio.ALUNO);
		usuario.setSenha("alunor");
		return usuario;
	}

	public static Aluno novoAluno() {
		Aluno aluno = new Aluno();
		aluno.setId(1L);
		aluno.setNome("aluno");
		aluno.setLogin("aluno");
		aluno.setEmail("aluno@usp.br");
		aluno.setSenha("senha");
		return aluno;

	}

}
