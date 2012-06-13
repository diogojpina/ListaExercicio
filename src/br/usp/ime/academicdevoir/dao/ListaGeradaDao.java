package br.usp.ime.academicdevoir.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.usp.ime.academicdevoir.entidade.Aluno;
import br.usp.ime.academicdevoir.entidade.ListaDeExercicios;
import br.usp.ime.academicdevoir.entidade.ListaGerada;

@Component
public class ListaGeradaDao {

	
	private Session session;

	public ListaGeradaDao(Session session) {
		this.session = session;
	}
	
	public void salvar(ListaGerada lista) {
	    Transaction tx = session.beginTransaction();
		session.save(lista);
		tx.commit();
	}

	public ListaGerada buscar(ListaDeExercicios lista, Aluno aluno) {
		return (ListaGerada) session.createQuery("From ListaGerada listaGerada Where listaGerada.aluno.id = :aluno and listaGerada.lista.id = :lista")
				.setParameter("aluno", aluno.getId())
				.setParameter("lista", lista.getId())
				.uniqueResult();
	}
	
}
