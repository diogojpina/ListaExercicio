<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	language="java" import="java.sql.*" errorPage=""%>

<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<style type="text/css">
</style>
<title>Academic Devoir</title>
</head>

<body>
	<h1>Academic Devoir</h1>
	<h2>Grupo 1 - Engenharia de Software</h2>
	<p>Lista de Disciplinas</p>
	<br />

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaDisciplinas}" var="d">
				<tr>
					<td>${d.id}</td>
					<td>${d.nome}</td>
					<td><a href="./alteracao?id=${d.id}"> Alterar</a> <a
						href="./remove?id=${d.id}"> Excluir</a></td>
				</tr>
			</c:forEach>
			</form>
		</tbody>
	</table>
	<a href="<c:url value='/login'/>">Sair</a>
	<a href="<c:url value='/administrador/home'/>">Voltar</a>
	<br />


</body>
</html>