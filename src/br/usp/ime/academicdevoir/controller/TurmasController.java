package br.usp.ime.academicdevoir.controller;

import java.util.List;

import com.sun.xml.internal.ws.wsdl.writer.UsingAddressing;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.usp.ime.academicdevoir.dao.AlunoDao;
import br.usp.ime.academicdevoir.dao.DisciplinaDao;
import br.usp.ime.academicdevoir.dao.ProfessorDao;
import br.usp.ime.academicdevoir.dao.TurmaDao;
import br.usp.ime.academicdevoir.entidade.Aluno;
import br.usp.ime.academicdevoir.entidade.Professor;
import br.usp.ime.academicdevoir.entidade.QuestaoDeMultiplaEscolha;
import br.usp.ime.academicdevoir.entidade.Turma;
import br.usp.ime.academicdevoir.entidade.Usuario;
import br.usp.ime.academicdevoir.infra.UsuarioSession;

@Resource
/**
 * Controlador de turmas.
 */
public class TurmasController {
    /**
     * @uml.property name="result"
     * @uml.associationEnd multiplicity="(1 1)"
     */
    private final Result result;
    /**
     * @uml.property name="turmaDao"
     * @uml.associationEnd multiplicity="(1 1)"
     */
    private TurmaDao turmaDao;
    /**
     * @uml.property name="disciplinaDao"
     * @uml.associationEnd multiplicity="(1 1)"
     */
    private DisciplinaDao disciplinaDao;
    /**
     * @uml.property name="alunoDao"
     * @uml.associationEnd multiplicity="(1 1)"
     */
    private AlunoDao alunoDao;
    /**
     * @uml.property name="usuarioSession"
     * @uml.associationEnd multiplicity="(1 1)"
     */
    private UsuarioSession usuarioSession;

    /**
     * @param result
     *            para interação com o jsp da turma.
     * @param turmaDao
     *            para interação com o banco de dados
     * @param disciplinaDao
     *            para interação com o banco de dados
     * @param alunoDao
     *            para interação com o banco de dados
     */
    public TurmasController(Result result, TurmaDao turmaDao,
            DisciplinaDao disciplinaDao, AlunoDao alunoDao,
            UsuarioSession usuarioSession) {
        this.result = result;
        this.turmaDao = turmaDao;
        this.disciplinaDao = disciplinaDao;
        this.alunoDao = alunoDao;
        this.usuarioSession = usuarioSession;
    }

    /**
     * Método associado à home page da turma com id fornecido.
     * 
     * @param id
     */
    @Path("/turmas/home/{id}")
    public void home(Long id) {
        Turma turma = turmaDao.carrega(id);
        result.include("turma", turma);
    }

    /**
     * Método associado ao menu da pagina da turma.
     */
    public void menu() {

    }

    /**
     * Método associado ao .jsp que lista as turmas cadastradas no banco de
     * dados.
     */
    public void lista() {
        result.include("listaDeTurmas", turmaDao.listaTudo());
    }

    /**
     * Método associado ao .jsp que lista os alunos inscritos na turma
     * 
     * @param idTurma
     *            id da turma
     */
    public void listaAlunos(long idTurma) {
        result.include("turma", turmaDao.carrega(idTurma));
    }

    /**
     * Método está associado ao .jsp do formulário de cadastro de uma turma no
     * sistema.
     */
    public void cadastro() {
        result.include("listaDeDisciplinas", disciplinaDao.listaTudo());
    }

    /**
     * Cadastra uma turma nova no sistema.
     * 
     * @param nova
     */
    public void cadastra(final Turma nova) {
        turmaDao.salvaTurma(nova);
        result.redirectTo(ProfessoresController.class).listaTurmas(
                nova.getProfessor().getId());
    }

    /**
     * Método associado ao .jsp com formulário para alteração de cadastro de
     * turma.
     */
    public void alteracao(Long id) {
        Turma turma = turmaDao.carrega(id);
        Professor p = (Professor) usuarioSession.getUsuario();
        if (p.getId() == turma.getProfessor().getId()) {
            result.include("turma", turma);
        } else
            result.redirectTo(LoginController.class).acessoNegado();
    }

    /**
     * Altera uma turma no banco de dados com o id fornecido e set o nome da
     * turma para novoNome.
     * 
     * @param id
     */
    public void altera(Long id, String novoNome) {
        Turma t = turmaDao.carrega(id);
        if (!novoNome.equals(""))
            t.setNome(novoNome);
        turmaDao.atualizaTurma(t);
        result.redirectTo(TurmasController.class).home(t.getId());
    }

    /**
     * Método associado ao .jsp com formulário para remoção de cadastro de
     * turma.
     */
    public void remocao() {
    }

    /**
     * Remove uma turma do banco de dados com o id fornecido.
     * 
     * @param id
     */
    public void remove(final Long id) {
        Turma turma = turmaDao.carrega(id);
        turmaDao.removeTurma(turma);
        result.redirectTo(TurmasController.class).lista();
    }

    /**
     * Remove a matricula do aluno na turma.
     * 
     * @param idAluno
     *            id do aluno
     * @param idTurma
     *            id da turma
     */
    public void removeMatricula(Long idAluno, Long idTurma) {
        Aluno aluno = alunoDao.carrega(idAluno);
        Turma turma = turmaDao.carrega(idTurma);
        alunoDao.removeMatricula(aluno, turma);
        result.redirectTo(TurmasController.class).listaAlunos(idTurma);
    }
}
