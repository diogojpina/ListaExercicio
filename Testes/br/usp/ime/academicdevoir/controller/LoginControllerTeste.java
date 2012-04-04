package br.usp.ime.academicdevoir.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;
import br.usp.ime.academicdevoir.dao.UsuarioDao;
import br.usp.ime.academicdevoir.entidade.Usuario;
import br.usp.ime.academicdevoir.infra.UsuarioSession;
import br.usp.ime.academicdevoir.util.Given;

public class LoginControllerTeste {
	
	private LoginController loginController;
	private Usuario usuario;
	
	@Spy 
	private Result result = new MockResult();

	@Mock
	private UsuarioDao usuarioDao;
	private UsuarioSession usuarioSession;
	
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		usuario = Given.novoUsuario();
		usuarioSession = new UsuarioSession(); 
		usuarioSession.setUsuario(usuario);
		loginController = new LoginController(result, usuarioDao, usuarioSession);
	}
	
	@Test
	public void deveFazerLogin(){
		loginController.login();
	}
	
	@Test
	public void deveAutenticarLogin(){
		Mockito.when(usuarioDao.fazLogin(usuario.getLogin(), usuario.getSenha())).thenReturn(usuario);
		loginController.login(usuario);
	}
	
	@Test
	public void naoDeveAutenticar() {
		Mockito.when(usuarioDao.fazLogin(usuario.getLogin(), usuario.getSenha())).thenReturn(null);
		loginController.login(usuario);	
		Mockito.verify(result).include("error", "Login ou senha incorreta!");
		
	}

	
	
}
