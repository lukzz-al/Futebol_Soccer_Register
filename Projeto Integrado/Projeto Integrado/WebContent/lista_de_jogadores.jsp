<%@page import="java.util.ArrayList"%>
<%@page import="br.uninove.modelo.Jogadores"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Jogadores Cadastrados!</title>
<link rel="stylesheet" href="lista.css">
</head>
<body>
	<header>
		<ul>
			<li><a href="https://www.uefa.com/uefachampionsleague/index.html" target="_blank" >Pagina da Champions </a></li>
							
			<li><a href="http://localhost:8080/Projeto_Integrado/cadastrarJogador.html?" target="_blank">Cadastrar Jogador(es)</a></li>
		</ul>
			<div class="efeito1">
				<h1>Lista de Jogadores</h1>
			</div>
	</header>
	
	<%ArrayList<Jogadores> jog_list = (ArrayList<Jogadores>) request.getAttribute("lista_de_jogadores"); %>
	
	

	
	<div class="fundotransparente">
	<table>
		<thead>
			<tr class="cabeçalho">
				<th>Nome</th>
				<th>Time</th>
				<th>Idade</th>
				<th>Peso</th>
				<th>RG</th>
				<th>Altura</th>
				<th>Camisa</th>
				<th>Salario</th>
				<th>Posicao</th>
				<th>Contrato</th>
				<th colspan="2">Ação</th>
			</tr>
		</thead>

		<tbody>
			<%
				for(Jogadores jog:jog_list){
			%>
			<tr>
				<td><%=jog.getNome()%></td>
				<td><%=jog.getTimes().getNm_time()  %></td>
				<td><%=jog.getIdade() %></td>
				<td><%=jog.getPeso() %></td>
				<td><%=jog.getRg()  %></td>
				<td><%=jog.getTamanho()  %></td>
				<td><%=jog.getTimes().getCamisa()  %></td>
				<td><%=jog.getTimes().getSalario()  %></td>
				<td><%=jog.getTimes().getPosicao()  %></td>
				<td><%=jog.getTimes().getContrato()  %></td>
				
				
				<td><a id="efeito" href="alterarjogador.do?rg=<%=jog.getRg()  %>"> Alterar </a></td>
				<td><a id="efeito" href="removerjogador.do?rg=<%=jog.getRg() %>"> Excluir </a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>
	
	<footer>
		<h6>  Lucas Figueiredo de Almeida RA: 918115158 ©</h6>
	</footer>
	
</body>
</html>