package br.usp.ime.academicdevoir.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.util.test.JSR303MockValidator;
import br.com.caelum.vraptor.util.test.MockResult;
import br.usp.ime.academicdevoir.dao.DisciplinaDao;
import br.usp.ime.academicdevoir.dao.QuestaoDeSubmissaoDeArquivoDao;
import br.usp.ime.academicdevoir.dao.TagDao;
import br.usp.ime.academicdevoir.entidade.Professor;
import br.usp.ime.academicdevoir.entidade.QuestaoDeSubmissaoDeArquivo;
import br.usp.ime.academicdevoir.entidade.Tag;
import br.usp.ime.academicdevoir.infra.Privilegio;
import br.usp.ime.academicdevoir.infra.UsuarioSession;
import br.usp.ime.academicdevoir.util.Given;

public class QuestoesDeSubmissaoDeArquivoControllerTeste {
    /**
	 * @uml.property  name="questoesC"
	 * @uml.associationEnd  
	 */
    private QuestoesDeSubmissaoDeArquivoController questoesC;
    /**
	 * @uml.property  name="dao"
	 * @uml.associationEnd  
	 */
    private QuestaoDeSubmissaoDeArquivoDao dao;
    /**
	 * @uml.property  name="result"
	 * @uml.associationEnd  
	 */
    private MockResult result;
    /**
	 * @uml.property  name="validator"
	 * @uml.associationEnd  
	 */
    private JSR303MockValidator validator;
    /**
	 * @uml.property  name="usuarioSession"
	 * @uml.associationEnd
	 */
	private UsuarioSession usuarioSession;
	private TagDao tagDao;
	
	private DisciplinaDao disciplinaDao;

    
    @Before
    public void SetUp() {		
		Professor professor = new Professor();
		professor.setPrivilegio(Privilegio.ADMINISTRADOR);
		
		usuarioSession = new UsuarioSession();
		usuarioSession.setUsuario(professor);

        dao = mock(QuestaoDeSubmissaoDeArquivoDao.class);
		tagDao = mock(TagDao.class);
		disciplinaDao = mock(DisciplinaDao.class);

        result = spy(new MockResult());
        validator = spy(new JSR303MockValidator());
        questoesC = new QuestoesDeSubmissaoDeArquivoController(dao, tagDao, disciplinaDao, result,
                validator, usuarioSession);
        
		when(tagDao.buscaPeloNome(any(String.class))).thenReturn(new Tag("tagQualquer"));
    }
    
    @Test
    public void testeAdiciona() {
        QuestaoDeSubmissaoDeArquivo questao = Given.novaQuestaoDeSubmissaoDeArquivo();
        when(disciplinaDao.carrega(questao.getDisciplina().getId())).thenReturn(questao.getDisciplina());
        questoesC.cadastra(questao, new String("tagQualquer"));

        verify(validator).validate(questao);
        verify(validator).onErrorRedirectTo(QuestoesController.class);
        verify(dao).salva(questao);
        verify(result).redirectTo(questoesC);
    }
    
    @Test
    public void testeAtualiza() {
        QuestaoDeSubmissaoDeArquivo questao = new QuestaoDeSubmissaoDeArquivo();
        questao.setEnunciado("Enuciado");
        questoesC.altera(questao, new String("tagQualquer"));
        
        verify(validator).validate(questao);
        verify(validator).onErrorUsePageOf(QuestoesDeSubmissaoDeArquivoController.class);
        verify(dao).atualiza(questao);
        verify(result).redirectTo(questoesC);
    }
    
    @Test
    public void testeRemove() {
        QuestaoDeSubmissaoDeArquivo temp = new QuestaoDeSubmissaoDeArquivo();
        when(dao.carrega(0L)).thenReturn(temp);
        questoesC.remove(0L);
        
        verify(dao).remove(temp);
        verify(result).redirectTo(questoesC);
    }


}
