package br.usp.ime.academicdevoir.dao;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.Assert;

import org.hibernate.Session;
import org.jstryker.database.DBUnitHelper;
import org.jstryker.database.HibernateHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import br.usp.ime.academicdevoir.entidade.Aluno;
import br.usp.ime.academicdevoir.entidade.Turma;
import br.usp.ime.academicdevoir.entidade.Usuario;



public class TurmasDaoTest{
	private static final String DATASET_TURMA = "/br/usp/ime/academicdevoir/xml/Turma.xml";
	private static final String DATASET_USUARIO = "/br/usp/ime/academicdevoir/xml/Usuario.xml";
	private static final String DATASET_TURMA_ALUNO = "/br/usp/ime/academicdevoir/xml/turma_aluno.xml";
	private static final String DATASET_DISCIPLINA = "/br/usp/ime/academicdevoir/xml/Disciplina.xml";

	private TurmaDao turmaDao;
	private UsuarioDao usuarioDao;
	private Session session;
	
	private DBUnitHelper dbUnitHelper = new DBUnitHelper();
	
	@Before
	public void setUp() {
		dbUnitHelper.insert(DATASET_DISCIPLINA);
		dbUnitHelper.insert(DATASET_USUARIO);
		dbUnitHelper.insert(DATASET_TURMA);
		dbUnitHelper.insert(DATASET_TURMA_ALUNO);
		session = HibernateHelper.currentSession();
		turmaDao = new TurmaDao(session);
	}
	
	@After
	public void tearDown() {
		dbUnitHelper.disableMysqlForeignKeyChecks(session.connection());
		dbUnitHelper.deleteAll(DATASET_TURMA_ALUNO, session.connection());
		dbUnitHelper.deleteAll(DATASET_TURMA, session.connection());
		dbUnitHelper.deleteAll(DATASET_USUARIO, session.connection());
		dbUnitHelper.delete(DATASET_DISCIPLINA);
	}
	
	
	@Test
	public void listaFiltrada(){
		/*Turma Acadastrada = turmaDao.carrega(100L);
		Turma Bcadastrada = turmaDao.carrega(101L);
		Turma CNaocadastrada = turmaDao.carrega(102L);
		Usuario aluno = usuarioDao.fazLogin("alunow", "alunow");
		Collection<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add((Aluno) aluno);
		Acadastrada.setAlunos(alunos);
		Bcadastrada.setAlunos(alunos);
		
		List<Turma> turmas = new ArrayList<Turma>();
		turmas = turmaDao.listaTurmasFiltradas(3L);
		
		Assert.assertEquals(1, turmas.size());*/
	}
	
}
