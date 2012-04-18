package br.usp.ime.academicdevoir.dao;

import java.util.Arrays;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;


import br.usp.ime.academicdevoir.entidade.Disciplina;

public class DisciplinaDaoTest {

	private @Mock Session session;
	private @Mock Disciplina disciplina;
	private @Mock Transaction transaction;
	private @Mock Criteria criteria;

	@Before
	public void iniciaMocks(){
		MockitoAnnotations.initMocks(this);
		when(session.beginTransaction()).thenReturn(transaction);
	}
	
	@Test
	public void salvaDisciplinaRetornaErroQuandoJahExisteUmaComOMesmoNome(){
		when(disciplina.getNome()).thenReturn("Lab XP");
		when(session.createCriteria(Disciplina.class)).thenReturn(criteria);
		when(criteria.list()).thenReturn(Arrays.asList(disciplina));
		when(criteria.add(any(Criterion.class))).thenReturn(criteria);
		DisciplinaDao dao = new DisciplinaDao(session);
		dao.salvaDisciplina(disciplina);
		verify(session,never()).save(anyObject());
		
	}
	
}
