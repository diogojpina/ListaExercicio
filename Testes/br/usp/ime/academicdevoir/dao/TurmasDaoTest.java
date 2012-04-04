package br.usp.ime.academicdevoir.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import br.usp.ime.academicdevoir.entidade.Aluno;
import br.usp.ime.academicdevoir.entidade.Disciplina;
import br.usp.ime.academicdevoir.entidade.Turma;

public class TurmasDaoTest {

	List<Turma> turmasList;
	Turma turmaMAC110;
	Turma turmaMAC122;
	Turma turmaNaoCadastrada;
	Aluno aluno;
	Disciplina disciplina;
	TurmaDao turmaDao;
	private @Mock Session session;
	private @Mock Transaction tx;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		when(session.beginTransaction()).thenReturn(tx);
		
		turmaDao = new TurmaDao(session);
		
		turmasList = new ArrayList<Turma>();
		turmaMAC110 = new Turma();
		turmaMAC122 = new Turma();
		turmaNaoCadastrada = new Turma();
		disciplina = new Disciplina();
		aluno = new Aluno();
		aluno.setId(666L);
	}
	
	public void shouldSaveTurma(){
		criaTurmas();
		turmaDao.salvaTurma(turmaMAC110);
		
		/*turmaDao.salvaTurma(turmaMAC122);
		turmaDao.salvaTurma(turmaNaoCadastrada);
		*/
		verify(session).save(turmaMAC110);
	}
	@Test
	public void listaFiltrada(){
		List<Turma> naoCadastradas = new ArrayList<Turma>();

		criaTurmas();
		
		turmaDao.salvaTurma(turmaMAC110);
		Long alunoId = aluno.getId();
		naoCadastradas = turmaDao.listaTudo();
		
		assertEquals(1, naoCadastradas.size());
		
		/*assertEquals(turmaMAC110, naoCadastradas.get(0));*/
	}
	
	private void criaTurmas() {
		Collection<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(aluno);
		disciplina.setId(2L);
		
		turmaMAC110.setId(110L);
		turmaMAC110.setAlunos(alunos);
		turmaMAC110.setDisciplina(disciplina);
		turmaMAC110.setNome("MAC110");
		turmaMAC122.setId(122L);
		turmaMAC122.setAlunos(alunos);
		turmaMAC122.setDisciplina(disciplina);
		turmaMAC122.setNome("MAC122");
		turmaNaoCadastrada.setId(1L);
		turmaNaoCadastrada.setDisciplina(disciplina);
		turmaNaoCadastrada.setNome("naoCadastrada");
		
		turmasList.add(turmaMAC110);
		turmasList.add(turmaMAC122);
		turmasList.add(turmaNaoCadastrada);
		
		/*turmaDao.salvaTurma(turmaMAC110);
		
		turmaDao.salvaTurma(turmaMAC122);
		turmaDao.salvaTurma(turmaNaoCadastrada);*/
	}
}
