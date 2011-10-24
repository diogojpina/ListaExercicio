<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=utf-8" language="java"
import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<style type="text/css">
body
{
background-color:#f0ecc6;
}
h1 
{
color: black;
text-align: center;
font-size: 40px;
font-family:"Times New Roman";
font-style: italic;
font-variant: small-caps;
}
h2
{
color: black;
text-align: center;
font-size: 20px;
font-family:"Times New Roman";
}
.fieldsetSemFormatacao{
	border:none;
	padding: 0px;
}
</style>
</head>
<body>
	<h1>Academic Devoir</h1>
	<h2>Grupo 1 - Engenharia de Software</h2>
	<div id="menu">
		<%@ include file="menu.jsp" %><br/>
	</div>
	
	<h3>Todas as Questões</h3>
		
	<div>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Enunciado</th>
					<th>Alterar</th>
					<th>Remover</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista }" var="questao">
					<tr>
						<td>${questao.id }</td>
						<td>${questao.enunciado }</td>
						<td><a href="<c:url value="/questoes/${questao.id }"/>">Alterar</a></td>
						<td>
							<form action="<c:url value="/questoes/${questao.id }"/>" method="post">
								<fieldset class="fieldsetSemFormatacao">
									<button name="_method" value="delete">Remover</button>
								</fieldset>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<form id="cadastrarQuestao" action="/academic-devoir/questoes/cadastro">
		<fieldset class="fieldsetSemFormatacao">
			<!--input type="submit" value="Cadastrar nova questão"></input-->
			<a href="<c:url value='questoes/cadastro'/>">Cadastrar nova questão</a>
		</fieldset>
	</form>
	<a href="<c:url value='/login'/>">Sair</a>
    <a href="<c:url value='/professores/home'/>">Página Principal</a><br/>
</body>
</html>