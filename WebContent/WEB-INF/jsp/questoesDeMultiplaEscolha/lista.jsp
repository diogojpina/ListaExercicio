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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel="stylesheet" type="text/css" charset="utf-8" media="screen" href="<c:url value="/css/jquery.ui.core.css"/>"/>
<link rel="stylesheet" type="text/css" charset="utf-8" media="screen" href="<c:url value="/css/jquery.ui.theme.css"/>"/>
<link rel="stylesheet" type="text/css" charset="utf-8" media="screen" href="<c:url value="/css/jquery.ui.resizable.css"/>"/>
<link rel="stylesheet" type="text/css" charset="utf-8" media="screen" href="<c:url value="/css/jquery.ui.dialog.css"/>"/>
<script type="text/javascript" charset="utf-8" src="<c:url value="/javascript/jquery-1.7.1.min.js"/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value="/javascript/jquery-ui/jquery.ui.core.min.js"/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value="/javascript/jquery-ui/jquery.ui.position.min.js"/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value="/javascript/jquery-ui/jquery.ui.widget.min.js"/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value="/javascript/jquery-ui/jquery.ui.mouse.min.js"/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value="/javascript/jquery-ui/jquery.ui.draggable.min.js"/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value="/javascript/jquery-ui/jquery.ui.resizable.min.js"/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value="/javascript/jquery-ui/jquery.ui.dialog.min.js"/>"></script>

<script type="text/javascript" charset="utf-8">
	
	$(document).ready(function() {
		
		$('.alterarQuestao').click(function() {
			var valor = $(this).attr('id');
			var idDaQuestao = valor.match(/\d+/g);
			var listas = 0;
			var paginaAlteracao = '<c:url value="/questoes/mult/"/>' + idDaQuestao;
			
			$.getJSON('<c:url value="/questoes/buscaListas/"/>' + idDaQuestao, function(json) {				
				$('#confirmacao').empty();
				$('<span>Modificar esta questão causará modificação nas seguintes listas: <span><br/><br/>').appendTo('#confirmacao');
				$.each(json, function() {
					$('<span>' + this.nome + '</span><br/>').appendTo('#confirmacao');
					listas++;
				});
			})
			.success(function() {
				if (listas == 0) window.location.href =  paginaAlteracao;
				else {
					$( '#confirmacao' ).dialog({
						resizable: true,
						height:400,
						modal: true,
						buttons: {
							'Criar uma nova questão': function() {
								window.location.href = '<c:url value="/questoes/copia/"/>' + idDaQuestao;
							},
							'Alterar esta questão': function() {
								window.location.href =  paginaAlteracao;
							}
						}
					});
				}
			});
		});
	});
</script>
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


				<div class="welcome">Você acessou como ${usuarioSession.usuario.nome } (<a href="/academic-devoir/logout">Sair</a>)</div>
				<h1><a href="index.html">Lista de Questões de Múltipla Escolha</a></h1>
				
	<div>
		<%@ include file="../questoes/menu.jsp" %><br/>
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Enunciado</th>
					<th>Alternativas</th>
					<th>Correta</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista }" var="questao">
					<tr>
						<td>${questao.id }</td>
						<td>${questao.enunciado }</td>
						<td>
							<ol>
								<c:forEach items="${questao.alternativas }" var="alternativa">
									<li>${alternativa.alternativa }
									(${alternativa.peso })</li><br/>
								</c:forEach>
							</ol>
						</td>					
						<td>${questao.alternativasCorretas }</td>
						<td><button id="alterarQuestao${questao.id }" class="alterarQuestao">Alterar</button></td>
						<td>
							<form action="<c:url value="/questoes/${questao.id }"/>" method="post">
									<button name="_method" value="delete">Remover</button>
							</form>
						</td>
					</tr>
				
				</c:forEach>
			</tbody>
		</table>
	</div>	
	<form action="<c:url value="/questoes/cadastro"/>">
			<!--input type="submit" value="Cadastrar nova questão"></input-->
			<a href="<c:url value='/questoes/cadastro'/>">Cadastrar nova questão</a><br/>
	</form>
	<div id="confirmacao">	
	</div>

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