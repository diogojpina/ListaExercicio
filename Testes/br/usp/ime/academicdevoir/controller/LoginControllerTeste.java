package br.usp.ime.academicdevoir.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.vraptor.util.test.MockResult;
import br.usp.ime.academicdevoir.dao.UsuarioDao;
import br.usp.ime.academicdevoir.entidade.Usuario;
import br.usp.ime.academicdevoir.infra.UsuarioSession;

public class LoginControllerTeste {
	
	private LoginController loginController;
	private Usuario usuario;
	
	
	private MockResult result;

	private UsuarioDao usuarioDao;
	private UsuarioSession usuarioSession;
	
	
	@Before
	public void setUp(){
		usuarioDao = Mockito.mock(UsuarioDao.class);
		result = Mockito.spy(new MockResult());
		usuario = new Given().novoUsuario();
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
