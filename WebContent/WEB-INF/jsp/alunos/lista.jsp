<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<!-- Website template by freewebsitetemplates.com -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java"
import="java.sql.*" errorPage="" %>

<html>
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
				<div class="welcome">Você logou como Aluno da Silva (<a href="/logout">Sair</a>)</div>
				<h1><a href="index.html">Lista de Alunos</a></h1>
	
        <form action='cadastro'>
        	<!-- input type="submit" value="Inserir"/-->
        	<a href="<c:url value='/alunos/cadastro'/>">Inserir</a><br/>
        </form>

    
	<table>
    <thead>
        <tr>
        <th>id</th>
        <th>Nome</th>
        <th>E-mail</th>
        <th>Login</th>
        <th>Senha</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listaDeAlunos}" var="aluno">
            <tr>
                <td>${aluno.id}</td>
                <td>${aluno.nome}</td>
                <td>${aluno.email}</td>
                <td>${aluno.login}</td>
                <td>${aluno.senha}</td>
                <td><a href="./alteracao?id=${aluno.id}">  Alterar</a> <a href="./remove?id=${aluno.id}">  Excluir</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div id="link"><a href="<c:url value='/login'/>">Sair</a></div>
<div id="link"><a href="<c:url value='/professores/home'/>">Voltar</a></div><br/>


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