package br.usp.ime.academicdevoir.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AlternativasMultiplaEscolha {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne	
	private QuestaoDeMultiplaEscolha questao;
	
	private String alternativa;
	private int peso;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAlternativa() {
		return alternativa;
	}
	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}
	
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public QuestaoDeMultiplaEscolha getQuestao() {
		return questao;
	}
	public void setQuestao(QuestaoDeMultiplaEscolha questao) {
		this.questao = questao;
	}
	
	@Override
	public String toString() {
		return this.alternativa;
	}
	

}
