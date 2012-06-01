package br.usp.ime.academicdevoir.dao;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class AlternativasMultiplaEscolhaDao {

	private final Session session;
	
	public AlternativasMultiplaEscolhaDao(Session session){
		this.session = session;
	}
}
