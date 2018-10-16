<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	padding: 5px;
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
<title>Emprestimos</title>
</head>
<body>
<c:import url="../menu.jsp"></c:import>
<h2>Adicionando emprestimos</h2>
<form action="/biblioteca/emprestimos" method="post">
		
		
		<div>
			<label>Nome do aluno: ${aluno.nome} </label>
			<input type="hidden" name="aluno.id" value="${aluno.id }">
		</div>
		
		<div>
			<label>Nome do livro: ${livro.nome} </label>
			<select name="livro.id">
				<c:forEach var="livro" items="${livros}">
					<option value="${livro.id}">${livro.id} - ${livro.nome} - ${livro.autor} </option>
				</c:forEach>
			</select>
		</div>
		
		<div>
			<label>Editora:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label>
			<input type="text" name="editora" />
		</div>
		
		<div>
			<label>Data de Emprestimo: </label>
			<input type="text" name="dataEmprestimo" />
		</div>
		
		<div>
			<button type="submit">Adicionar</button>
		</div>
</form>
</body>
</html>