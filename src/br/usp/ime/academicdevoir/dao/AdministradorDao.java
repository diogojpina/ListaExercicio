package br.usp.ime.academicdevoir.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.usp.ime.academicdevoir.entidade.Administrador;

@Component
public class AdministradorDao {

	/**
	 * @uml.property name="session"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	private final Session session;

	public AdministradorDao(Session session) {
		this.session = session;
	}

	public Administrador carrega(Long id) {
		return (Administrador) session.load(Administrador.class, id);
	}

	public void atualizaAdministrador(Administrador a) {
		Transaction tx = session.beginTransaction();
		session.update(a);
		tx.commit();

	}

}
