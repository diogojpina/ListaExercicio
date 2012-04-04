package br.usp.ime.academicdevoir.util;

import br.usp.ime.academicdevoir.entidade.Usuario;
import br.usp.ime.academicdevoir.infra.Privilegio;

public class Given {

	public static Usuario novoUsuario() {
		Usuario usuario = new Usuario();
		usuario.setLogin("login-1");
		usuario.setEmail("usuarior@ime.usp.br");
		usuario.setPrivilegio(Privilegio.ALUNO);
		usuario.setSenha("senha-1");
		return usuario;
	}

}
