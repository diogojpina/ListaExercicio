package br.usp.ime.academicdevoir.entidade;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import br.usp.ime.academicdevoir.dao.TagDao;

@Entity
/**
 * Entidade que representa uma disciplina cadastrada no sistema.
 * @author Vinicius Rezende
 */
public class Disciplina {
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
	 * @uml.property  name="turmas" multiplicity="(0 -1)"
	 */
    @OneToMany(mappedBy = "disciplina")
    private Collection<Turma> turmas;
    //TODO: estava assim: private Collection<Turma> turmas = new ArrayList<Turma>();

    @OneToMany(mappedBy = "disciplina")
    private Collection<Questao> questoes;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tags_disciplinas", joinColumns = { @JoinColumn(name = "id_disciplina") }, inverseJoinColumns = { @JoinColumn(name = "id_tag") })
	protected List<Tag> tags = new ArrayList<Tag>();
    /**
	 * @return  id da disciplina
	 * @uml.property  name="id"
	 */
    public Long getId() {
        return id;
    }

    /**
	 * @param id  id da disciplina
	 * @uml.property  name="id"
	 */
    public void setId(Long id) {
        this.id = id;
    }

    /**
	 * @return  nome da disciplina
	 * @uml.property  name="nome"
	 */
    public String getNome() {
        return nome;
    }

    /**
	 * @param nome  nome da disciplina
	 * @uml.property  name="nome"
	 */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return lista de turmas da disciplina
     */
    public Collection<Turma> getTurmas() {
        return turmas;
    }

    /**
     * @param turmas lista de turmas da disciplina
     */
    public void setTurmas(Collection<Turma> turmas) {
        this.turmas = turmas;
    }
    
    public Collection<Questao> getQuestoes(){
    	return questoes;
    }
    
    public void setQuestoes(Collection<Questao> questoes){
    	this.questoes = questoes;
    }
    
    public List<Tag> getTags() {
		return tags;
	}
    
    public void setTags(String stringTags, TagDao dao) {
		if (stringTags == null || stringTags.equals(""))
			return;

		List<String> tags = Arrays.asList(stringTags.split(",[ ]*"));
		for (String nome : tags) {
			Tag tag = dao.buscaPeloNome(nome);
			if (tag == null) {
				tag = new Tag(nome);
				dao.salva(tag);
			}
			if(!this.tags.contains(tag))
				this.tags.add(tag);
		}
	}

}
