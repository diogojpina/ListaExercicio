package br.usp.ime.academicdevoir.util;

import java.util.List;

import br.usp.ime.academicdevoir.entidade.Aluno;
import br.usp.ime.academicdevoir.entidade.Disciplina;
import br.usp.ime.academicdevoir.entidade.Professor;
import br.usp.ime.academicdevoir.entidade.QuestaoDeSubmissaoDeArquivo;
import br.usp.ime.academicdevoir.entidade.QuestaoDeTexto;
import br.usp.ime.academicdevoir.entidade.QuestaoDeVouF;
import br.usp.ime.academicdevoir.entidade.Turma;
import br.usp.ime.academicdevoir.entidade.Usuario;
import br.usp.ime.academicdevoir.infra.Privilegio;

public class Given {

	public static Usuario novoUsuario() {
		
		Usuario usuario = new Usuario();
		usuario.setId(1l);
		usuario.setLogin("login-1");
		usuario.setEmail("usuarior@ime.usp.br");
		usuario.setPrivilegio(Privilegio.ALUNO);
		usuario.setSenha("senha-1");
		return usuario;
	}

	public static Aluno novoAluno() {
		Aluno aluno = new Aluno();
		aluno.setId(1L);
		aluno.setNome("aluno");
		aluno.setLogin("aluno");
		aluno.setEmail("aluno@usp.br");
		aluno.setSenha("senha");
		return aluno;

	}
	
	public static  List<Integer>  prazoDeMatricula() {
		
		return null;
	}

	public static Turma novaTurma() {
		
		Turma turma = new Turma();
		turma.setDisciplina(novaDisciplina());
		return turma;

	}
	
	public static Professor novoProfessor() {
		Professor professor = new Professor();
		professor.setId(1l);
		return professor;
	}
	
	public static QuestaoDeVouF novaQuestaoDeVouF() {
		QuestaoDeVouF questao = new QuestaoDeVouF();
        questao.setEnunciado("Enuciado");
        Disciplina disciplina = novaDisciplina();
        questao.setDisciplina(disciplina);
        return questao;
	}

	public static QuestaoDeTexto novaQuestaoDeTexto() {
		QuestaoDeTexto questao = new QuestaoDeTexto();
        questao.setEnunciado("Enuciado");
        Disciplina disciplina = novaDisciplina();
        questao.setDisciplina(disciplina);
        return questao;
	}

	public static QuestaoDeSubmissaoDeArquivo novaQuestaoDeSubmissaoDeArquivo() {
        QuestaoDeSubmissaoDeArquivo questao = new QuestaoDeSubmissaoDeArquivo();
        questao.setEnunciado("Enuciado");
        Disciplina disciplina = novaDisciplina();
        questao.setDisciplina(disciplina);
        return questao;
	}

	public static Disciplina novaDisciplina() {
		Disciplina disciplina = new Disciplina();
        disciplina.setId(1l);
		return disciplina;
	}
	
}
