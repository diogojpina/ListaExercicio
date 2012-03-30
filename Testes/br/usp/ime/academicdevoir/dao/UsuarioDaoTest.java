package br.usp.ime.academicdevoir.dao;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.usp.ime.academicdevoir.controller.Given;
import br.usp.ime.academicdevoir.entidade.Usuario;

public class UsuarioDaoTest {

	private Usuario usuario;
	private UsuarioDao usuarioDao;
	private Session session;

	@Before
	public void setUp() {
		session = new Configuration().configure()
				.buildSessionFactory().openSession();
		usuarioDao = new UsuarioDao(session);
		usuario = Given.novoUsuario();
	}

	@Test
	public void naoDeveFazerLogin() {
		Usuario aluno = usuarioDao.fazLogin(usuario.getLogin(), usuario.getSenha());
		Assert.assertNull("Aluno não encontrado na base de dados", aluno);
	}
	
	@Test
	public void deveFazerLogin() {
		usuario.setLogin("alunow");
		usuario.setSenha("alunow");
		Usuario aluno = usuarioDao.fazLogin(usuario.getLogin(), usuario.getSenha());
		Assert.assertNotNull("Aluno encontrado na base de dados", aluno);
	}
	
	
}
