package br.usp.ime.academicdevoir.dao;

import org.hibernate.HibernateException;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.usp.ime.academicdevoir.entidade.Usuario;
import br.usp.ime.academicdevoir.infra.Criptografia;

@Component
public class UsuarioDao {
	
	/**
	 * @uml.property  name="session"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="br.usp.ime.academicdevoir.entidade.Usuario"
	 */
	private final Session session;
	
	public UsuarioDao(Session session){
		this.session = session;
	}
 
    public Usuario fazLogin(String login, String senha){
    	System.out.println(login + " / " + senha);
    	System.out.println(new Criptografia().geraMd5(senha));
    	
    	try{

    		Usuario usuario = (Usuario) session.createCriteria(Usuario.class)
	                .add(Restrictions.eq("login", login))
	                .add(Restrictions.eq("senha", new Criptografia().geraMd5(senha)))
	                .uniqueResult();

    		System.out.println(usuario + " aqui o usuario");
    		
	        return usuario;
    	} catch(HibernateException ex){
    		return null;
    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	}
    }
}
