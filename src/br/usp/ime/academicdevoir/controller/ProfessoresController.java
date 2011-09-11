package br.usp.ime.academicdevoir.controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.usp.ime.academicdevoir.dao.ProfessorDao;
import br.usp.ime.academicdevoir.entidade.Professor;

@Resource
public class ProfessoresController {
	private final Result result;
	private ProfessorDao professorDao;

	public ProfessoresController(Result result, ProfessorDao professorDao) {
		this.result = result;
		this.professorDao = professorDao;
	}

	public void home() {
	}

	public void lista() {
		result.include("professorDao", professorDao);
	}

	public void cadastro() {
	}

	public void cadastra(final Professor novo) {
		professorDao.salvaProfessor(novo);
		result.redirectTo(ProfessoresController.class).lista();
	}

	public void alteracao() {
	}

	public void altera(Long id, String novoNome, String novoEmail, String novaSenha) {
		Professor p = professorDao.carregaPelaId(id);
		p.setNome(novoNome);
		p.setEmail(novoEmail);
		p.setSenha(novaSenha);
		professorDao.alteraProfessor(p);
		result.redirectTo(ProfessoresController.class).lista();
	}
	
	public void remocao() {
	}

	public void remove(final Long id) {
		Professor professor = professorDao.carregaPelaId(id);
		professorDao.removeProfessor(professor);
		result.redirectTo(ProfessoresController.class).lista();
	}
}
