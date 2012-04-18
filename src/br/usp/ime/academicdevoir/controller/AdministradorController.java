package br.usp.ime.academicdevoir.controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.usp.ime.academicdevoir.dao.AdministradorDao;
import br.usp.ime.academicdevoir.dao.DisciplinaDao;
import br.usp.ime.academicdevoir.entidade.Administrador;
import br.usp.ime.academicdevoir.entidade.Usuario;
import br.usp.ime.academicdevoir.infra.Criptografia;
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
	private DisciplinaDao disciplinaDao;
	private Validator validator;

	public AdministradorController(Result result,
			AdministradorDao administradorDao, UsuarioSession usuario,
			DisciplinaDao disciplinaDao, Validator validator) {
		this.result = result;
		this.administradorDao = administradorDao;
		this.usuarioSession = usuario;
		this.validator = validator;
		this.disciplinaDao = disciplinaDao;
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

	@Permission({ Privilegio.ADMINISTRADOR })
	/**
	 * Altera um professor no banco de dados com o id fornecido e set o nome
	 * do professor para novoNome, o email para novoEmail e a senha para novaSenha.
	 * 
	 * @param id
	 * @param novoNome
	 * @param novoEmail
	 * @param novaSenha
	 */
	public void altera(Long id, String novoNome, String novoEmail,
			String novaSenha) {
		Usuario u = usuarioSession.getUsuario();
		if (u.getId().longValue() != id) {
			result.redirectTo(LoginController.class).acessoNegado();
			return;
		}

		Administrador a;

		a = administradorDao.carrega(id);
		a.setNome(novoNome);
		a.setEmail(novoEmail);
		a.setSenha(novaSenha);

		validator.validate(a);
		validator.onErrorUsePageOf(AdministradorController.class).alteracao(id);

		a.setSenha(new Criptografia().geraMd5(novaSenha));
		administradorDao.atualizaAdministrador(a);
		result.redirectTo(AdministradorController.class).home();

	}

	public void listaDisciplinas() {
		result.redirectTo(AdministradorController.class).lista();
	}

	public void lista() {
		result.include("listaDisciplinas", disciplinaDao.listaTudo());
	}

}
