<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<!-- Website template by freewebsitetemplates.com -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java"
import="java.sql.*" errorPage="" %>

<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
	<title>Academic Devoir - IME USP</title>
	<link rel="stylesheet" type="text/css" charset="utf-8" media="screen" href="<c:url value="/css/style.css"/>"/>
	<link rel="stylesheet" type="text/css" charset="utf-8" media="screen" href="<c:url value="/css/menu.css"/>"/>
	<!--[if IE 9]>
		<link rel="stylesheet" type="text/css" charset="utf-8" media="screen" href="<c:url value="/css/ie9.css"/>"/>
	<![endif]-->
	<!--[if IE 8]>
		<link rel="stylesheet" type="text/css" charset="utf-8" media="screen" href="<c:url value="/css/ie8.css"/>"/>
	<![endif]-->
	<!--[if IE 7]>
		<link rel="stylesheet" type="text/css" charset="utf-8" media="screen" href="<c:url value="/css/ie7.css"/>"/>
	<![endif]-->
</head>

<body>
<%@ include file="/layout/header.jsp" %>
<div id="content">
	<div id="body">
  	<table border="0">
    	<tr>
      		<td width="200" align="center">	
				<%@ include file="/layout/menu.jsp" %>
			</td>
			<td width="750" align="left" valign="top">    
				<div class="welcome">Você acessou como ${usuarioSession.usuario.nome } (<a href="<c:url value="/logout" />">Sair</a>)</div>
				<h1>Lista de Alunos</h1>
    
    <table border="1">
    <thead>
        <tr>
        <th>Nome</th>
        <c:forEach items="${turma.listas}" var="lista">
            <th>${lista.propriedades.nome}</th>
        </c:forEach>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${turma.alunos}" var="aluno">
            <tr>
                <td>${aluno.nome}</td>
                <c:forEach items="${turma.listas}" var="lista">
                    <td>
                    <c:forEach items="${lista.respostas}" var="resposta">    
                        <c:if test ="${resposta.aluno.id == aluno.id}">
                            ${lista.propriedades.nome}
                        </c:if>
                    </c:forEach>
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </tbody>
</table> 
		</td>
		</tr>
	</table>    			
	<!-- body -->
	</div>
<!-- content -->
</div>
<%@ include file="/layout/footer.jsp" %>	
</body>
</html>