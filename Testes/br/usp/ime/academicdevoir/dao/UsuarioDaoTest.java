package br.usp.ime.academicdevoir.dao;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
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

		session = new AnnotationConfiguration().configure()
				.buildSessionFactory().openSession();
		usuarioDao = new UsuarioDao(session);
		usuario = new Given().novoUsuario();

	}

	@Test
	public void naoDeveFazerLogin(){
		Usuario usuario1 = usuarioDao.fazLogin(usuario.getLogin(), usuario.getSenha());
		Assert.assertNull("Nao logou", usuario1);
	}
	
	
}
