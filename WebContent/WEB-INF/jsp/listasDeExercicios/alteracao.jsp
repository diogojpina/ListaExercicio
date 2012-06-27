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
	
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.21/themes/base/jquery-ui.css" type="text/css" media="all" />

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.8.21/jquery-ui.min.js" type="text/javascript"></script>
	

<script language='javascript'>

$(function(){
	$("#data").datepicker({
	dateFormat: 'dd/mm/yy',
	dayNames: [
	'Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'
	],
	dayNamesMin: [
	'D','S','T','Q','Q','S','S','D'
	],
	dayNamesShort: [
	'Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'
	],
	monthNames: [
	'Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro',
	'Outubro','Novembro','Dezembro'
	],
	monthNamesShort: [
	'Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set',
	'Out','Nov','Dez'
	],
	nextText: 'Próximo',
	prevText: 'Anterior'

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
				<div class="welcome">Você acessou como ${usuarioSession.usuario.nome } (<a href="<c:url value="/logout" />">Sair</a>)</div>
				<h1>Altera&ccedil;&atilde;o da lista de exerc&iacute;cios</h1>
	
	<div>
		<br/>
		<form style="width: 25em;" action="<c:url value="/listasDeExercicios/${listaDeExercicios.id }"/>" method="post" accept-charset="utf-8">
			<fieldset>
				<legend>Alterar lista de exercícios</legend>
				<label for="nome">Nome:</label>
					<input id="nome" type="text" name="propriedades.nome" value="${listaDeExercicios.propriedades.nome }"/>
					<br/>
				<label for="enunciado">Enunciado:</label>
					<input id="enunciado" type="text" name="propriedades.enunciado" value="${listaDeExercicios.propriedades.enunciado }"/>
					<br/>
				<label for="visivel">Visível:</label>
					<c:choose>
						<c:when test="${listaDeExercicios.propriedades.visivel }">
							<input id="visivel" type="checkbox" checked="checked" name="propriedades.visivel" value="true"/>
						</c:when>
						<c:otherwise>
							<input id="visivel" type="checkbox" name="propriedades.visivel" value="true"/>
						</c:otherwise>
					</c:choose>
					<br/>
				<label for="Peso">Peso:</label>
					<input id="peso" type="text" size="5" maxlength="3" name="propriedades.peso" value="${listaDeExercicios.propriedades.peso }"/>
					<br/>
				<label for="prazoDeEntrega">Prazo de entrega:</label>
				<br/>
				<input id="data" type="text"  maxlength="10" name="data1" value="" size="10"/>
					<br/>
				<label for="hora">Hora:</label>
					<input id="hora" type="text" size="2" maxlength="2" name="prazoDeEntrega[3]" value="${prazo[3] }"/>:
					<input id="minuto" type="text" size="2" maxlength="2" name="prazoDeEntrega[4]" value="${prazo[4] }"/>
					<br/>
				<label for="numeroMaximoDeEnvios">Número Máximo de Envios:</label>
					<input id="numeroMaximoDeEnvios" type="text" size="2" maxlength="2" name="propriedades.numeroMaximoDeEnvios" value="${listaDeExercicios.propriedades.numeroMaximoDeEnvios }"/>
					<br/>
				<label for="autoCorrecao">Auto Correção:</label>
					<select id="autoCorrecao" name="propriedades.autoCorrecao">
						<c:choose>
							<c:when test="${listaDeExercicios.propriedades.autoCorrecao eq 'DESATIVADA' }">
								<option selected="selected" value="0">Desativada</option>
								<option value="1">Ativada</option>
							</c:when>
							<c:otherwise>
								<option value="0">Desativada</option>
								<option selected="selected" value="1">Ativada</option>
							</c:otherwise>
						</c:choose>						
					</select>
					<br/><br/>
				<button type="submit" name="_method" value="put">Salvar Alterações</button>
			</fieldset>
		</form>
		<br/>
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