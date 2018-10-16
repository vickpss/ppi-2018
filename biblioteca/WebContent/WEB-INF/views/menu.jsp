<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #000080;
    border: 2px solid #00FFFF;
    border-radius: 20px;
    
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 100px;
    text-decoration: none;
    font-family: "Comic Sans MS", cursive, sans-serif;
    
}

li a:hover:not(.active) {
    background-color: DeepSkyBlue;
}

.active {
    background-color: SteelBlue;
}
</style>
</head>
<body>
<c:import url="cabecalho.jsp" />
<br>

<ul>
  <li><a class="active" href="/biblioteca/"> Inicio</a></li>
  <li><a href="/biblioteca/alunos/form">Novo aluno</a></li>
  <li><a href="/biblioteca/alunos">Listar alunos</a></li>
  <li><a href="/biblioteca/emprestimos">Listar emprestimos</a></li>
</ul>

</body>
</html>
