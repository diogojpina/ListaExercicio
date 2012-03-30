package br.usp.ime.academicdevoir.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.usp.ime.academicdevoir.entidade.Turma;
import br.usp.ime.academicdevoir.entidade.Disciplina;
import br.usp.ime.academicdevoir.infra.UsuarioSession;

@Component
public class TurmaDao {

	/**
	 * @uml.property  name="session"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private final Session session;

	public TurmaDao(Session session) {
		this.session = session;
	}

	/**
	 * Cadastra a turma no banco de dados.
	 * 
	 * @param turma
	 */
	@SuppressWarnings("unchecked")
	public void salvaTurma(Turma turma) {
		String nome = turma.getNome();
		Disciplina disciplina = turma.getDisciplina();
	    List<Turma> listaDeTurmas = session.createCriteria(Turma.class)
                .add(Restrictions.like("nome", nome, MatchMode.EXACT))
                .add(Restrictions.eq("disciplina", disciplina))
                .list();
        
	    if (listaDeTurmas.size() != 0) return;
	    
		Transaction tx = session.beginTransaction();
		session.save(turma);
		tx.commit();
	}
	
	/**
	 * Atualiza a turma fornecida no banco de dados.
	 *  
	 * @param turma
	 */
	@SuppressWarnings("unchecked")
	public void atualizaTurma(Turma turma) {
		String nome = turma.getNome();
		Disciplina disciplina = turma.getDisciplina();
	    List<Turma> listaDeTurmas = session.createCriteria(Turma.class)
                .add(Restrictions.like("nome", nome, MatchMode.EXACT))
                .add(Restrictions.eq("disciplina", disciplina))
                .list();
        
	    if (listaDeTurmas.size() != 0 && listaDeTurmas.get(0).getId() != turma.getId()) return;
	    
		Transaction tx = session.beginTransaction();
		session.update(turma);
		tx.commit();
	}

	/**
	 * Remove a turma fornecida do banco de dados.
	 * 
	 * @param turma
	 */
	public void removeTurma(Turma turma) {
		try {
			Transaction tx = session.beginTransaction();
			session.delete(turma);
			tx.commit();
		} catch (Exception e) { 
			return; /*Não foi possível remover a turma, pois tem alguma lista associada.*/
		}
	}

	/**
	 * Devolve uma turma com o id fornecido.
	 * 
	 * @param id
	 * @return Turma
	 */
	public Turma carrega(Long id) {
		return (Turma) session.load(Turma.class, id);
	}
	
    @SuppressWarnings("unchecked")
    /**
	 * Devolve uma lista com todas as turmas cadastradas no banco de dados.
	 * 
	 * @return List<Turma>
	 */
	public List<Turma> listaTudo() {
        List<Turma> listaDeTurmas = session.createCriteria(Turma.class).list();
		return listaDeTurmas;
	}
    
    public List<Turma> listaTurmasFiltradas(Long idAluno) {
    	List<Turma> listaTudo = listaTudo();
    	List<Turma> listaFinal = new ArrayList<Turma>();
    	
    	for(int i = 0; i < listaTudo.size(); i++){
    		if(!listaTudo.get(i).alunoMatriculado(idAluno))
    			listaFinal.add(listaTudo.get(i));
    	}
    	
    	return listaFinal;
    }

    /**
     * Carrega os dados da questão fornecida a partir do banco de dados.
     * @param turma
     */
	public void recarrega(Turma turma) {
		session.refresh(turma);
	}
}
