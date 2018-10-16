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
<title>Lista de emprestimos</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>
<br>
<br>


	<table border="1" align="center">
		<tr>
			<th>Nome aluno</th>
			<th>Nome livro</th>
			<th>ID emprestimo</th>
		
			<th>Data de emprestimo</th>
			<th>Data de devoluçao</th>
		</tr>

		<c:forEach var="emprestimo" items="${emprestimos}">

			<tr>
				<td>${emprestimo.aluno.nome}</td>
				<td>${emprestimo.livro.nome}</td>
				<td>${emprestimo.id}</td>
				<td><fmt:formatDate value="${emprestimo.dataEmprestimo.time}"
						pattern="dd/MM/yyyy" /></td>

				<td><c:if test="${empty emprestimo.dataDevolucao }">Não finalizado</c:if>
					<c:if test="${not empty emprestimo.dataDevolucao}">
						<fmt:formatDate value="${emprestimo.dataDevolucao.time}"
							pattern="dd/MM/yyyy" />
					</c:if></td>

				<td><a
					href="/biblioteca/emprestimos/finalizar?id=${emprestimo.id}">Finalizar</a></td>

			</tr>

		</c:forEach>


	</table>
</body>
</html>