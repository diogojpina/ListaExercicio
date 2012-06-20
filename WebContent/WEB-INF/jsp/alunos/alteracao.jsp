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

<script type="text/javascript" charset="utf-8" src="<c:url value="/javascript/jquery-1.7.1.min.js"/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value="/javascript/jquery.validate.min.js"/>"></script>
<script type="text/javascript" charset="utf-8">

$.validator.setDefaults({
    submitHandler: function() { document.forms["cadastro"].submit(); }
});

$().ready(function() {

    // validate signup form on keyup and submit
    $("#alteracao").validate({
        rules: {
        	"novoNome": {
        		required: true,
        		minlength: 5
        	},
            "novaSenha": {
                required: false,
                minlength: 5
            },
            "novoEmail": {
                required: true,
                email: true
            },
            "confirmaSenha": {
            	required: false,
            	equalTo: '#senha'
            }
        },
        messages: {
        	"novoNome": {
        		required: "Por favor, digite um nome.",
        		minlength: "Seu nome deve ter no mínimo 5 caracteres."
        	},
            "novaSenha": {
                required: "Por favor, digite uma senha.",
                minlength: "Sua senha deve ter no mínimo 5 caracteres."
            },
            "confirmaSenha": {
            	required: "Por favor, digite sua senha novamente.",
            	equalTo: "As senhas digitadas não coincidem."
            },
            "novoEmail": "Entre com um e-mail válido."
        }
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
				<h1><a href="index.html">Alterar dados cadastrais</a></h1>

	<form id="alteracao" action='altera' method="post" accept-charset="utf-8">	
	<fieldset>
		Digite os novos dados cadastrais
		<input type="hidden" size="30" name="id" value="${aluno.id}"/>
		<p><label>Nome: </label><input type="text" size="50" name="novoNome" value="${aluno.nome}"/></p>
		<p><label>E-mail : </label><input type="text" size="30" name="novoEmail" value="${aluno.email}"/></p>
		<p><label>Senha : </label><input id="senha" type="password" size="32" name="novaSenha"/></p>
		<p><label>Confirmar senha : </label><input type="password" size="32" name="confirmaSenha"/></p>
	<p class="submit"><input type="submit" value="Enviar"/><br/></p>
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