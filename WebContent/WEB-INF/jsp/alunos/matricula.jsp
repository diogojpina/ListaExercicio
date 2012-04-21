<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java"
import="java.sql.*" errorPage="" %>

<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<style type="text/css">
<%@ include file="/css/form2.css" %>
</style>
<title>Matricula</title>
</head>

<body>
	<div id="wrapper">
	<div id="header"> <%@ include file="/css/header.jsp" %></div> <br/>
	<div id="left"><fieldset><%@ include file="/css/menu.jsp" %></fieldset></div>
	<div id="right">
	<div id="menu">Matricular-se em uma turma:</div>
	<form action='inscreve' accept-charset="utf-8">
	<input type="hidden" name="idAluno" value="${usuarioSession.usuario.id}">
	 Olá, ${usuarioSession.usuario.nome}, selecione a turma na qual você quer se matricular.<br/><br/>
	<select name="idTurma">
    <c:forEach items="${listaDeTurmas}" var="turma">
          <option value="${turma.id }">${turma.disciplina.nome } - ${turma.nome }</option> 
    </c:forEach>
    </select>
        <br /><br />        
    <input type="submit" value="Ok"/>
    <c:forEach items="${matriculaInvalida}" var="matricula">
    	<br><br>${matricula}
    </c:forEach>
    <br><br>${prazoMaximoAtingido}</br></br>
	</form>
	</div>
	</div>
	</body>
</html>