package br.usp.ime.academicdevoir.entidade;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ListaGerada {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	private double nota;
	
	@ManyToOne
	private ListaDeExercicios lista;
	
	@ManyToMany
	private List<Aluno> alunos;
	
	private Date dataGeracao;
	private Date dataFinalizacao;
	
	private String codigoIndentificador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public ListaDeExercicios getLista() {
		return lista;
	}

	public void setLista(ListaDeExercicios lista) {
		this.lista = lista;
	}

	public Date getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(Date dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public Date getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public String getCodigoIndentificador() {
		return codigoIndentificador;
	}

	public void setCodigoIndentificador(String codigoIndentificador) {
		this.codigoIndentificador = codigoIndentificador;
	}

	

}
