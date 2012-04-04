package br.usp.ime.academicdevoir.dao;

import org.hibernate.Session;
import org.jstryker.database.DBUnitHelper;
import org.jstryker.database.HibernateHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.usp.ime.academicdevoir.entidade.Usuario;
import br.usp.ime.academicdevoir.util.Given;

public class UsuarioDaoTest {

	private static final String DATASET_USUARIO = "/br/usp/ime/academicdevoir/xml/Usuario.xml";

	private UsuarioDao usuarioDao;
	private Session session;
	
	private DBUnitHelper dbUnitHelper = new DBUnitHelper();

	@Before
	public void setUp() {
		dbUnitHelper.insert(DATASET_USUARIO);
		session = HibernateHelper.currentSession();
		usuarioDao = new UsuarioDao(session);
	}

	@After
	public void tearDown() {
		dbUnitHelper.delete(DATASET_USUARIO);
	}

	@Test
	public void naoDeveFazerLogin() {
		Usuario aluno = usuarioDao.fazLogin("aluno", "aluno");
		Assert.assertNull("Aluno não encontrado na base de dados", aluno);
	}
	
	@Test
	public void deveFazerLogin() {
		Usuario usuario = Given.novoUsuario();
		Usuario aluno = usuarioDao.fazLogin(usuario.getLogin(), usuario.getSenha());
		Assert.assertNotNull("Aluno encontrado na base de dados", aluno);
	}
	
	
}
