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
      		<td width="200" align="center" valign="top">	
				<%@ include file="/layout/menu.jsp" %>
			</td>
			<td width="750" align="left" valign="top">    


				<div class="welcome">Você acessou como ${usuarioSession.usuario.nome } (<a href="<c:url value="/logout" />">Sair</a>)</div>
				<h1>Cadastro de lista de exerc&iacute;cio</h1>

		<form name="form1" style="width: 25em;" action="<c:url value="/listasDeExercicios" />" method="post" accept-charset="utf-8" >
			<c:forEach items="${errors}" var="msg">
		    	<b>${msg.message}</b><br/>
		    </c:forEach>
		    <br><br>
			<fieldset>
			
				<legend>Cadastrar lista de exerc&iacute;cios</legend>	
				
				
							
				<label for="nome">Nome:</label>
					<input id="nome" type="text" name="propriedades.nome" value="${propriedades.nome}"/>
					<br/>
				<label for="enunciado">Enunciado:</label>
					<input id="enunciado" type="text" name="propriedades.enunciado" />
					<br/>
				<label for="visivel">Vis&iacute;vel:</label>
					<input id="visivel" type="checkbox" name="propriedades.visivel" value="true" checked />
					<br/>
				<label for="Peso">Peso:</label>
					<input id="peso" type="text" size="5" maxlength="3" name="propriedades.peso" />
					<br/>
				
				<div>
				Prazo de entrega:
				<br/>
				<input id="data" type="text"  maxlength="10" name="data1" value="" size="10"/>					
				<br/>				
				<label for="hora">Hora:</label>
					<input id="hora" type="text" size="2" maxlength="2" name="prazoDeEntrega[3]"/>:
					<input id="minuto" type="text" size="2" maxlength="2" name="prazoDeEntrega[4]"/>
					<br/>
				<label for="numeroMaximoDeEnvios">N&uacute;mero M&aacute;ximo de Envios:</label>
					<input id="numeroMaximoDeEnvios" type="text" size="2" maxlength="2" name="propriedades.numeroMaximoDeEnvios" />
					<br/>
				<label for="autoCorrecao">Auto Corre&ccedil;&atilde;o:</label>
					<select id="autoCorrecao" name="propriedades.autoCorrecao">
						<option value="0">Desativada</option>
						<option value="1">Ativada</option>
					</select>
				<br/><br/>
					
				<!-- <label for="turmas">Turmas:</label>
				<br />
				<c:forEach items="${turmasDoProfessor }" var="turma">
					<input type="checkbox" name="idDasTurmas[]" value="${turma.id }" />
					<p> ${turma.disciplina.nome } - ${turma.nome }</p>
					<br />
				</c:forEach>
				-->
				
				<label for="turmas">Turmas:</label>
				<br />
				<c:forEach items="${turmasDoProfessor }" var="turma">
					<input type="radio" name="idDaTurma" value="${turma.id }" />
					 ${turma.disciplina.nome } - ${turma.nome }
					<br />
				</c:forEach>
								
				<br />
				
				<label for="geracaoAutomatica">Gerar lista automatica:</label>
					<input id="automatica" type="checkbox" name="propriedades.geracaoAutomatica" value="true" checked />
					<br/>
				<button type="submit">Enviar</button>
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