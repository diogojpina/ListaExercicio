package br.usp.ime.academicdevoir.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.usp.ime.academicdevoir.entidade.ListaQuestao;

@Component
public class ListaQuestaoDao {

	private Session session;
	
	public ListaQuestaoDao(Session session) {
		this.session = session;
	}

	public void salvar(ListaQuestao listaQuestao) {
		Transaction tx = session.beginTransaction();
		session.save(listaQuestao);
		tx.commit();
	}

}
