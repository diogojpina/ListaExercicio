package br.usp.ime.academicdevoir.dao;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.Assert;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;


import br.usp.ime.academicdevoir.entidade.Aluno;
import br.usp.ime.academicdevoir.entidade.Disciplina;
import br.usp.ime.academicdevoir.entidade.Turma;

import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



public class TurmasDaoTest{
	
	TurmaDao turmaDao;
	Disciplina disciplina;
	Aluno aluno;
	Collection<Aluno> alunos;
	Turma turmaMatriculada;
	Turma turmaNaoMatriculada;
	List<Turma> turmas;
	
	private @Mock Session session;
	private @Mock Transaction tx;
	private @Mock Criteria criteria;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		when(session.beginTransaction()).thenReturn(tx);
		turmaDao = new TurmaDao(session);

		disciplina = new Disciplina();
		disciplina.setId(1L);
		disciplina.setNome("MAC110");
		aluno = new Aluno();
		aluno.setId(10L);
		aluno.setNome("renato");
		
		alunos = new ArrayList<Aluno>();
		alunos.add(aluno);
		
		turmaMatriculada = new Turma();
		turmaMatriculada.setId(0L);
		turmaMatriculada.setNome("MAC110");
		turmaMatriculada.setDisciplina(disciplina);
		turmaMatriculada.setAlunos(alunos);
		
		turmaNaoMatriculada = new Turma();
		turmaNaoMatriculada.setId(1L);
		turmaNaoMatriculada.setNome("MAC110");
		turmaNaoMatriculada.setDisciplina(disciplina);
		
		turmas = new ArrayList<Turma>();
		turmas.add(turmaMatriculada);
		turmas.add(turmaNaoMatriculada);
		
		when(session.createCriteria(Turma.class)).thenReturn(criteria);
		when(criteria.list()).thenReturn(turmas);
		
	}
	
	@Test
	public void listaTurmasFiltradas(){
		List<Turma> t = turmaDao.listaTurmasFiltradas(aluno.getId());
		Assert.assertEquals(1, t.size());
	}
	
	@Test
	public void listaTudo(){
		List<Turma> t = turmaDao.listaTudo();
		Assert.assertEquals(turmas, t);
		verify(session).createCriteria(Turma.class);
		verify(criteria).list();
	}
	@Test
	public void salvaTurma(){
		turmaDao.salvaTurma(turmaMatriculada);
		verify(session).beginTransaction();
		verify(session).save(turmaMatriculada);
		verify(tx).commit();
	}
	
	@Test
	public void removeTurma(){
		turmaDao.removeTurma(turmaMatriculada);
		verify(session).beginTransaction();
		verify(session).delete(turmaMatriculada);
		verify(tx).commit();
	}
	
	@Test
	public void atualizaTurma(){
		turmaDao.atualizaTurma(turmaMatriculada);
		verify(session).beginTransaction();
		verify(session).update(turmaMatriculada);
		verify(tx).commit();
	}
	
	@Test
	public void recarregaTurma(){
		turmaDao.recarrega(turmaMatriculada);
		verify(session).refresh(turmaMatriculada);
	}
}