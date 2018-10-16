<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de alunos</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
table {
	border-collapse: collapse;
	width: 95%;
	font-family: "Comic Sans MS", cursive, sans-serif;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #B4CDCD;
	color: black;
}
</style>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>
	<h1>Lista de alunos</h1>

	<table border="1" align="center">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Turma</th>
			<th>Endereço</th>
			<th>Telefone</th>
			<th>Remover</th>
			<th>Alterar</th>
			<th>Cadastrar Livro</th>
			<th>Listar Livro</th>
		</tr>

		<c:forEach var="aluno" items="${alunos}">

			<tr>
				<td>${aluno.id}</td>
				<td>${aluno.nome}</td>
				<td>${aluno.turma}</td>
				<td>${aluno.endereco}</td>
				<td>${aluno.telefone}</td>

				<td><center>
						<a href="/biblioteca/alunos/remover?id=${aluno.id}"><i
							class="glyphicon glyphicon-remove-circle"
							style="font-size: 15px; color: black;"></i></a>
					</center></td>
				<td><center>
						<a href="/biblioteca/alunos/selecionar?id=${aluno.id}"><i
							class="glyphicon glyphicon-user"
							style="font-size: 15px; color: black;"></i></a>
					</center></td>
				<td><center>
						<a href="/biblioteca/livros/form?id=${aluno.id}"><i
							class="material-icons" style="font-size: 17px; color: black;">book</i></a>
					</center></td>
				<td><center>
						<a href="/biblioteca/livros?id=${aluno.id}"><i
							class="glyphicon glyphicon-cloud"
							style="font-size: 15px; color: black;"></i></a>
					</center></td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>