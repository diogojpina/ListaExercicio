<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRUD</title>
<style type="text/css">
body
{
background-color:#dfdfdf;
}
h1
{
color:black;
text-align:center;
}
p
{
font-family:"Verdana";
font-size:18px;
}
</style> 
</head>
<body>
	<h1>Academic Devoir</h1>
	<p>Alterar disciplina</p>
	<form action='altera'>	
		Id da turma a alterar: <input type="text" name="id" /> <br />
		Novo Nome: <input type="text" name="novoNome"/><br/>
	<input type="submit" value="OK"/>
	</form>
</body>
</html>