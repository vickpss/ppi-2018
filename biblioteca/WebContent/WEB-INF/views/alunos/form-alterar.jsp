<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=text], select {
	width: 30%;
	padding: 5px 5px;
	margin: 8px 0;
	display: block;
	border-radius: 20px;
	box-sizing: border-box;
	border: 2px solid #1E90FF;
	border-right-width: 50%;

}

input[type=submit] {
	width: 30%;
	background-color: red;
	color: red;
	padding: 5px 5px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
	
}

div {
	border-radius: 1px;
	background-color: #ffffff;
	padding: 1px;
	font-family: "Comic Sans MS", cursive, sans-serif;
}

h2 {
	font-family: "Comic Sans MS", cursive, sans-serif;
}

button {
	font-family: "Comic Sans MS", cursive, sans-serif;
	border: 2px solid #1E90FF;
	border-radius: 15px;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Aluno</title>
</head>
<body>
<c:import url="../menu.jsp"></c:import>
<h2>Alterando aluno</h2>
<form action="/biblioteca/alunos/alterar" method="post">
	
	<div>
		<label>ID: </label>
		<input type="text" name="id" value="${aluno.id}" readonly="readonly" />
	</div>
	
	<div>
		<label>Nome:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		<input type="text" name="nome" value="${aluno.nome}" />
	</div>
	
	<div>
		<label>Turma:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label>
		<input type="text" name="turma" value="${aluno.turma}" />
	</div>

	<div>
		<label>Endere�o: </label>
		<input type="text" name="endereco" value="${aluno.endereco}" />
	</div>
	
	<div>
		<label>Telefone:&nbsp; </label>
		<input type="text" name="telefone" value="${aluno.telefone}" />
	</div>
	
	<div>
		<button type="submit">Alterar</button>
	</div>
</form>
</body>
</html>