<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java"
import="java.sql.*" errorPage="" %>

<html>
<head><title>Academic Devoir</title>
<style type="text/css">
<%@ include file="/css/form2.css" %>
</style> 
</head>

<body>
    <div id="wrapper"> 
	<div id="header"> <%@ include file="/css/header.jsp" %></div> <br/>
	<div id="left"><fieldset><%@ include file="/css/menu.jsp" %></fieldset></div>
	<div id="right">
    <div id="menu">${turma.disciplina.nome} - ${turma.nome}</div>
    <br/><br/>
    
  	<div>
		<ul>
			<c:if test ="${usuarioSession.usuario.privilegio == 'PROFESSOR' || usuarioSession.usuario.privilegio == 'ADMINISTRADOR'}">
				<c:forEach items="${listaDeListas }" var="lista">
        			<li><a href="<c:url value="/listasDeExercicios/${lista.id }"/>">${lista.propriedades.nome }</a></li>
        		</c:forEach>              
    		</c:if>
                	
            <c:if test ="${usuarioSession.usuario.privilegio == 'ALUNO'}">
            	<!-- Listas de Exerc&iacute;cios corrigidas -->
            	<c:forEach items="${listaDeListas }" var="lista">
					<%boolean flag=true;%>
                	<c:forEach items="${lista.respostas }" var="resposta">
                		<c:if test ="${resposta.aluno.id == usuarioSession.usuario.id}">
        					<c:if test ="${resposta.propriedades.estado == 'CORRIGIDA'}">
        						<li><a href="<c:url value="/listasDeExercicios/resolver/${lista.id }"/>">${lista.propriedades.nome }</a> - Corrigida</li>
        						<%flag=false;%>
        					</c:if>
        		<!-- Listas de Exerc&iacute;cios finalizadas -->
        					<c:if test ="${resposta.propriedades.estado == 'FINALIZADA'}">
        						<li><a href="<c:url value="/listasDeExercicios/resolver/${lista.id }"/>">${lista.propriedades.nome }</a> - Finalizada</li>
        						<%flag=false;%>
        					</c:if>
        		<!-- Listas de Exerc&iacute;cios salvas -->
        					<c:if test ="${resposta.propriedades.estado == 'SALVA'}">
        						<li><a href="<c:url value="/listasDeExercicios/resolver/${lista.id }"/>">${lista.propriedades.nome }</a> - Salva</li>
        						<%flag=false;%>
        					</c:if>
        		<!-- Listas de Exerc&iacute;cios inicializdas -->        					
        					<c:if test ="<%=flag%>" >
        						<li><a href="<c:url value="/listasDeExercicios/resolver/${lista.id }"/>">${lista.propriedades.nome }</a> - Inicializada</li>
        						<%flag=false;%>
        					</c:if>
        				</c:if>
        			</c:forEach>
        		<!-- Listas de Exerc&iacute;cios não inicializadas -->
        			<c:if test ="<%=flag%>" >
	       				<li><a href="<c:url value="/listasDeExercicios/resolver/${lista.id }"/>">${lista.propriedades.nome }</a> - Não inicializada</li>
     				</c:if>
        		</c:forEach>        			
			</c:if>

		</ul>
	</div>	
    
    <c:if test="${usuarioSession.usuario.privilegio == 'ALUNO'}">
    <form action='../removeMatricula'>
        <input type="hidden" name="idAluno" value="${usuarioSession.usuario.id}">
        <input type="hidden" name="idTurma" value="${turma.id}">
        <p class="submit"><input type="submit" value="Sair da turma"/></p>
     </form>
     </c:if>
    
    <form action='../../listasDeExercicios/cadastro' method="get">
        <c:if test ="${usuarioSession.usuario.privilegio != 'ALUNO' && usuarioSession.usuario.privilegio != 'MONITOR'}">
        	<a href="<c:url value='../../listasDeExercicios/cadastro'/>">Criar lista de exerc&iacute;cios</a><br/>	         
 		</c:if>
    </form>
     <form action='../../listasDeExercicios/listasTurma/${turma.id}' method="get">
        <c:if test ="${usuarioSession.usuario.privilegio != 'ALUNO' && usuarioSession.usuario.privilegio != 'MONITOR'}">
            <a href="<c:url value='../../listasDeExercicios/listasTurma/${turma.id}'/>">Listas de exerc&iacute;cios</a><br/>           
        </c:if>
    </form>
    <form action='../listaAlunosEListas' method="get">
        <input type="hidden" value="${turma.id}" name="idTurma"/>
        <c:if test ="${usuarioSession.usuario.privilegio != 'ALUNO' && usuarioSession.usuario.privilegio != 'MONITOR'}">
        	<a href="<c:url value='../listaAlunosEListas?idTurma=${turma.id}'/>">Listas entregues (por aluno)</a><br/>	         
 		</c:if>
    </form>
    <form action='../listaAlunos' method="get">
        <input type="hidden" value="${turma.id}" name="idTurma">
        <c:if test ="${usuarioSession.usuario.privilegio != 'ALUNO' && usuarioSession.usuario.privilegio != 'MONITOR'}">
        	<a href="<c:url value='../listaAlunos?idTurma=${turma.id}'/>">Gerenciar alunos</a><br/>	         
 		</c:if>
    </form>
 
    
    
    
    <form action='../alteracao' method="get">
        <input type="hidden" value="${turma.id}" name="id"/>
        <c:if test ="${usuarioSession.usuario.privilegio != 'ALUNO' && usuarioSession.usuario.privilegio != 'MONITOR'}">
        	<a href="<c:url value='../alteracao?id=${turma.id}'/>">Alterar informações da turma</a>         
 		</c:if>
    </form>
    <form action='../remove' method="get">
        <input type="hidden" value="${turma.id}" name="id">
        <c:if test ="${usuarioSession.usuario.privilegio != 'ALUNO' && usuarioSession.usuario.privilegio != 'MONITOR'}">
        	<a href="<c:url value='../remove?id=${turma.id}'/>">Excluir Turma</a><br/>	         
 		</c:if>
    </form>
    
    </div>
    </div>
</body>
</html>