package br.usp.ime.academicdevoir.entidade;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Turma {
	/**
	 * @uml.property  name="id"
	 */
	@Id
	@GeneratedValue
	private Long id;
	/**
	 * @uml.property  name="nome"
	 */
	private String nome;
	/**
	 * @uml.property  name="professor"
	 * @uml.associationEnd  inverse="turmas:br.usp.ime.academicdevoir.entidade.Professor"
	 */
	@ManyToOne
	private Professor professor;
	/**
	 * @uml.property  name="alunos"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="turmas:br.usp.ime.academicdevoir.entidade.Aluno"
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "Turma_Aluno", joinColumns = @JoinColumn(name = "turma_id"), inverseJoinColumns = @JoinColumn(name = "aluno_id"))
	@OrderBy("nome")
	private Collection<Aluno> alunos = new ArrayList<Aluno>();
	/**
	 * @uml.property  name="disciplina"
	 * @uml.associationEnd  
	 */
	@ManyToOne
	private Disciplina disciplina;

	/**
	 * @uml.property  name="listasDeExercicios" 
	 */
	 
	@OneToMany(mappedBy = "turma")
	private Collection<ListaDeExercicios> listasDeExercicios;
	
	
	
	/**
	 * @return
	 * @uml.property  name="disciplina"
	 */
	public Disciplina getDisciplina() {
		return disciplina;
	}

	/**
	 * @param disciplina
	 * @uml.property  name="disciplina"
	 */
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Collection<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Collection<Aluno> alunos) {
		this.alunos = alunos;
	}

	/**
	 * @return
	 * @uml.property  name="nome"
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 * @uml.property  name="nome"
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return
	 * @uml.property  name="professor"
	 */
	public Professor getProfessor() {
		return professor;
	}

	/**
	 * @param professor
	 * @uml.property  name="professor"
	 */
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	/**
	 * @return
	 * @uml.property  name="id"
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 * @uml.property  name="id"
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public Collection<ListaDeExercicios> getListas() {
		return listasDeExercicios;
	}

	public void setListas(Collection<ListaDeExercicios> listas) {
		this.listasDeExercicios = listas;
	}

}
