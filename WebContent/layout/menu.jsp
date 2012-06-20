<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<!-- Website template by freewebsitetemplates.com -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java"
import="java.sql.*" errorPage="" %>
<div class="menu_left">
      <h1>Minhas Turmas</h1>
<ul>
<c:forEach items="${usuarioSession.usuario.turmas}" var="t">
   <li class='active '><a href='<c:url value="/turmas/home/${t.id}"/>'><span>${t.disciplina.nome} - ${t.nome}</span></a></li>
</c:forEach>   
</ul>
</div>
<div class="menu_left">
      <h1>Menu</h1>
<ul>
	<c:if test ="${usuarioSession.usuario.privilegio == 'ADMINISTRADOR'}">
		<li><a href="<c:url value='/disciplinas/cadastro'/>">Cadastrar disciplina</a></li>
	</c:if>
	<c:if test ="${usuarioSession.usuario.privilegio == 'PROFESSOR'}">
		<li><a href="<c:url value='/professores/home'/>">Página Principal</a></li>
		<li><a href="<c:url value='/professores/alteracao?id=${usuarioSession.usuario.id}'/>">Alterar meus dados</a></li>
		<li><a href="<c:url value='/professores/listaTurmas?idProfessor=${usuarioSession.usuario.id}'/>">Turmas ministradas</a></li>
		<li><a href="<c:url value='/turmas/nova'/>">Criar Turma</a></li>
		<li><a href="<c:url value='/disciplinas/lista'/>">Listar disciplinas</a></li>
		<li><a href="<c:url value='/questoes/cadastro'/>">Cadastrar quest&atilde;o</a></li>
		<li><a href="<c:url value='/listasDeExercicios/cadastro'/>">Cadastrar Lista</a></li>
		<li>&nbsp;</li>
		<li><a href="<c:url value='/logout'/>">Sair</a></li>
	</c:if>
	<c:if test ="${usuarioSession.usuario.privilegio == 'ALUNO' || usuarioSession.usuario.privilegio == 'MONITOR'}">
		<li><a href="<c:url value='/alunos/home'/>">Página Principal</a></li>
		<li><a href="<c:url value='/alunos/alteracao?id=${usuarioSession.usuario.id}'/>">Alterar meus dados</a></li>
		<li><a href="<c:url value='/alunos/listaTurmas?idAluno=${usuarioSession.usuario.id}'/>">Minhas Turmas</a></li>
		<li><a href="<c:url value='/alunos/matricula'/>">Matrícula</a></li>
		<li>&nbsp;</li>
		<li><a href="<c:url value='/logout'/>">Sair</a></li>
	</c:if>    
</ul>
</div>