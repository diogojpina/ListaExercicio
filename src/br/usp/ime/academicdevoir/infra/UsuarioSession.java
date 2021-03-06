package br.usp.ime.academicdevoir.infra;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.usp.ime.academicdevoir.entidade.Usuario;

@Component
@SessionScoped
public class UsuarioSession {

	/**
	 * @uml.property  name="usuario"
	 * @uml.associationEnd  
	 */
	private Usuario usuario;

	/**
	 * @return
	 * @uml.property  name="usuario"
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 * @uml.property  name="usuario"
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogged() {
		return usuario != null;
	}

	public void logout() {
		usuario = null;
	}
}
