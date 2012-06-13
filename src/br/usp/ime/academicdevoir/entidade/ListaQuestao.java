package br.usp.ime.academicdevoir.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ListaQuestao {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private ListaGerada listaGerada;
	
	@ManyToOne
	private Questao questao;
	
	public ListaQuestao(ListaGerada listaGerada, Questao questao) {
		this.listaGerada = listaGerada;
		this.questao = questao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ListaGerada getListaGerada() {
		return listaGerada;
	}

	public void setListaGerada(ListaGerada listaGerada) {
		this.listaGerada = listaGerada;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
	
}
