<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	background-color: #B4CDCD
}

th {
	background-color: #B4CDCD;
	color: white;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<c:import url="../menu.jsp"></c:import>
	<h1>Listagem de livros</h1>

	<form action="/biblioteca/livros/form">
		<input type="hidden" name="id" value="${aluno.id}">
		<button type="submit">Novo livro</button>
	</form>


	<br> ID do aluno: ${aluno.id}
	<br> Nome do aluno: ${aluno.nome}

	<table border="1">
		<tr>
			<th>ID:</th>
			<th>Nome:</th>
			<th>Editora:</th>
			<th>Autor:</th>
			<th>Remover:</th>
			<th>Adicionar:</th>
			<th>Adicionar Emprestimo:</th>
		</tr>

		<c:forEach var="l" items="${livros}">

			<tr>
				<td>${l.id}</td>
				<td>${l.nome}</td>
				<td>${l.editora}</td>
				<td>${l.autor}</td>



				<td><center>
						<a href="/biblioteca/livros/remover?id=${l.id}"><i
							class="glyphicon glyphicon-remove"
							style="font-size: 15px; color: black;"></i></a>
					</center></td>
				<!--  <td><a href="/biblioteca/livros/remover?id=${l.id}"><i class="glyphicon glyphicon-remove" style="font-size:15px;color:black;"></i></a></center></td></a></td>
			-->
				<!--  <td><a href="/biblioteca/livros/selecionar?id=${l.id}">Alterar</a></td>
			-->
				<td><center>
						<a href="/biblioteca/livros/form?id=${l.id}"><i
							class="material-icons" style="font-size: 17px; color: black;">book</i></a>
					</center></td>

				<td><center>
						<a href="/biblioteca/emprestimos/form?id=${aluno.id}"><i
							class="material-icons" style="font-size: 17px; color: black;">book</i></a>
					</center></td>

				<!--  <td><a href="/biblioteca/emprestimos/form?id=${aluno.id}">Emprestimo</a></td> -->
			</tr>

		</c:forEach>


	</table>
</body>
</html>