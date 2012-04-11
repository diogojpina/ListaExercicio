package br.usp.ime.academicdevoir.controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.usp.ime.academicdevoir.dao.AdministradorDao;
import br.usp.ime.academicdevoir.entidade.Usuario;
import br.usp.ime.academicdevoir.infra.Permission;
import br.usp.ime.academicdevoir.infra.Privilegio;
import br.usp.ime.academicdevoir.infra.UsuarioSession;

@Permission({ Privilegio.ADMINISTRADOR })
@Resource
public class AdministradorController {

	/**
	 * @uml.property name="result"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	private final Result result;
	private UsuarioSession usuarioSession;
	private AdministradorDao administradorDao;

	public AdministradorController(Result result, 
			UsuarioSession usuario) {
		this.result = result;
	//	this.administradorDao = adminDao;
		this.usuarioSession = usuario;
	}

	public void home() {
	}

	@Permission({ Privilegio.ADMINISTRADOR })
	/**
	 * Método associado ao .jsp com formulário para alteração de cadastro de
	 * professor.
	 * 
	 * @param id   identificador do professor
	 */
	public void alteracao(Long id) {

		Usuario u = usuarioSession.getUsuario();
		if (u.getId().longValue() != id) {
			result.redirectTo(LoginController.class).acessoNegado();
			return;
		}
		result.include("administrador", administradorDao.carrega(id));
	}

}
