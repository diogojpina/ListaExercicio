<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRUD</title>
<style type="text/css">
body
{
background-color:#ffcfeb;
}
h1
{
background-color:#fea8ce;
font-family: "Times New Roman";
color:black;
}
div
{
background-color:#fec2e5;
}
</style> 
</head>
<body>
	<h1>CRUD</h1>
	<form action='formulario' method="get">
	<input type="submit" value="Adicionar produto"/>
	</form>
	<form action='listarproduto' method="get">
	<input type="submit" value="Listar produto"/>
	</form>
	<form action='remocao' method="get">
	<input type="submit" value="Remover produto"/>
	</form>
</body>
</html>