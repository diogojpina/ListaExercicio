package br.usp.ime.academicdevoir.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import br.usp.ime.academicdevoir.entidade.Aluno;
import br.usp.ime.academicdevoir.entidade.Turma;

public class TurmasDaoTest {

	Turma turmaNaoCadastrada = new Turma();
	Turma turmaMAC110 = new Turma();
	Turma turmaMAC122 = new Turma();
	Aluno aluno = new Aluno();
	List<Turma> turmasList = new ArrayList<Turma>();
	TurmaDao turmaDao;
	AlunoDao alunoDao;
	private @Mock Session session;
	
	@Before
	public void preparaTestes(){
		turmaMAC110.setId(110L);
		turmaMAC122.setId(122L);
		turmaNaoCadastrada.setId(1L);
		aluno.setId(666L);
		session = new Configuration().configure().buildSessionFactory().openSession();
		turmaDao = new TurmaDao(session);
		alunoDao = new AlunoDao(session);
	}
	@Test
	public void listaFiltrada(){
		List<Turma> naoCadastradas = new ArrayList<Turma>();

		turmaDao.salvaTurma(turmaMAC110);
		turmaDao.salvaTurma(turmaMAC122);
		turmaDao.salvaTurma(turmaNaoCadastrada);
		turmasList.add(turmaMAC110);
		turmasList.add(turmaMAC122);
		aluno.setTurmas(turmasList);
		alunoDao.salvaAluno(aluno);
		
		Long alunoId = aluno.getId();
		naoCadastradas = turmaDao.listaTurmasFiltradas(alunoId);
		
		assertEquals(1, naoCadastradas.size());
		
		assertEquals(turmaNaoCadastrada, naoCadastradas.get(0));
	}
}
