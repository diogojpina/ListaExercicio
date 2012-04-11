package br.usp.ime.academicdevoir.dao;

import org.hibernate.Session;

import br.usp.ime.academicdevoir.entidade.Administrador;

public class AdministradorDao {
	
	/**
	 * @uml.property  name="session"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private final Session session;
	
	
	public AdministradorDao(Session session){
		this.session = session;
	}
	
	
	public Administrador carrega(Long id) {
		return (Administrador) session.load(Administrador.class, id);
	}
	

}
