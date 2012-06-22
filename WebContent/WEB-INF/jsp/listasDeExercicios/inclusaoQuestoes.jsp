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
				<div class="welcome">Você acessou como ${usuarioSession.usuario.nome } (<a href="<c:url value="/logout" />">Sair</a>)</div>
				<h1>Incluir Questões na Lista</h1>
	
		
		<form style="width: 25em;" id="formIncluirQuestao" action="<c:url value="/listasDeExercicios/${idDaListaDeExercicios }/inclusaoQuestoes"/>" method="get">
			<!--  <fieldset>
				<legend>Filtrar por Tags</legend> -->
				<span>Filtra por Tags: </span>
				<input type="hidden" id="proxPag" name="proxPagina" value="1" />
				<input type="text" id="filtro" name="filtro" />
				<input type="submit" value="Filtrar"  />
			<!--  </fieldset> -->
		</form>
		
	
	<br/>
		
	
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Enunciado</th>
					<th>Inclusão</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaDeQuestoes}" var="questao">
					<tr>
						<td>${questao.id }</td>
						<td>${questao.enunciado }</td>
						<td>
							<form style="width: 25em;" id="formIncluirQuestao" action="<c:url value="/listasDeExercicios/${idDaListaDeExercicios }/questoes/inclui"/>" method="post">
								<fieldset class="fieldsetSemFormatacao">
									<input id="idDaQuestao" type="hidden" name="idDaQuestao" value="${questao.id }" />
									<label id="labelPesoDaQuestao" for="pesoDaQuestao">Peso:</label>
									<input id="pesoDaQuestao" type="text" size="6" maxlength="6" name="pesoDaQuestao" value="1"/>
									<button id="incluiQuestao" type="submit" name="_method" value="put">Incluir</button>
								</fieldset>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

			<span>Páginas: </span>
			
			<c:if test ="${pagina > 1}">
				<c:if test="${filtroAtual.lenght == 0} }">
					${filtroAtual} = "VouF"
				</c:if>
				<span>&nbsp;&nbsp;</span><a href="<c:url value="inclusaoQuestoes?proxPagina=${pagina - 1}&filtro=VouF"/>">&lt;&lt;</a>
			</c:if>
			
			<!--<c:forEach items="${listaDePaginasAnteriores }" var="numeroPagina">
				<a href="<c:url value="${listaDeExercicios.id }/inclusaoQuestoes?proxPagina=${numeroPagina}"/>">&nbsp;&nbsp;${numeroPagina}</a>
			</c:forEach>-->
			
			<span>&nbsp;&nbsp;${pagina}</span>
			
			<!--<c:forEach items="${listaDePaginasPosteriores }" var="numeroPagina">
				<a href="<c:url value="${listaDeExercicios.id }/inclusaoQuestoes?proxPagina=${numeroPagina}"/>">&nbsp;&nbsp;${numeroPagina}</a>
			</c:forEach>-->
						
			<c:if test ="${pagina < ultimaPagina}">
				<span>&nbsp;&nbsp;</span><a href="<c:url value="inclusaoQuestoes?proxPagina=${pagina + 1}&filtro=VouF"/>">&gt;&gt;</a>
			</c:if>

	<br/>
	<form id="cadastrarQuestao" action="/academic-devoir/questoes/cadastro">
		<fieldset class="fieldsetSemFormatacao">
			<!--input type="submit" value="Cadastrar nova questão"></input-->
			<a href="<c:url value='/questoes/cadastro'/>">Cadastrar nova questão</a>
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