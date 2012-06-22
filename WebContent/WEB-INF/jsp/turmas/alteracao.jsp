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
				<h1>Altera&ccedil;&atilde;o da Turma</h1>

	
	<form action='altera' method="post" accept-charset="utf-8">	
	<fieldset>	
		<input type="hidden" size="30" name="id" value="${turma.id }"/> <br />
		<p><label>Nome: </label><input type="text" size="30" name="novoNome" value="${turma.nome }"/></p>
		<p><label>Incluir ou Excluir prazo de matricula?</label>
			<input type="radio" name="novoTemPrazo" value="sim" checked/>Incluir
			<input type="radio" name="novoTemPrazo" value="nao"/>Excluir</p>
    	
    	<p><label for="prazoDeMatricula">Novo Prazo de matr&iacute;cula:</label></p><br/>
		
					<p><label for="dia">Dia:<br/></label>
						<select name="prazoDeMatricula[0]">
						<c:forEach var="i" begin="1" end="31" step="1" varStatus="status">
							<c:if test="${ diaAtual == i}">
								<option value="${i}" selected>${i}</option>
							</c:if>
							<c:if test="${ diaAtual != i}">
								<option value="${i}">${i}</option>
							</c:if>
						</c:forEach>
						</select> 
					</p>
					<p><label for="mes">Mês:<br/></label>
						<select name="prazoDeMatricula[1]">
						<c:forEach var="i" begin="1" end="12" step="1" varStatus="status">
							<c:if test="${ mesAtual == i}">
								<option value="${i}" selected>${i}</option>
							</c:if>
							<c:if test="${ mesAtual != i}">
								<option value="${i}">${i}</option>
							</c:if>
						</c:forEach>
						</select> 
					</p>
					
					<p><label for="ano">Ano:<br/></label>
						<select name="prazoDeMatricula[2]">
							<option value="${anoAtual}" selected>${anoAtual}</option>
						<c:forEach var="i" begin="${anoAtual + 1}" end="${anoAtual + 5}" step="1" varStatus="status">
							<option value="${i}">${i}</option>
						</c:forEach>
						</select> 
					</p>	
		
	<p class="submit"><input type="submit" value="Alterar"/></p>
	</fieldset>
	</form>

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