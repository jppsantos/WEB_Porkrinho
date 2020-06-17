<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="br.com.porkrinho.bean.MetaBean"%>    
<%@page import="br.com.porkrinho.dao.MetaDAO"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script type="text/javascript" src="JavaScript/script.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<meta charset="UTF-8">
	<title>Principal</title>
</head>
<body>
<div class="container col-sm-12">
	<div class="card text-center">
		<%@include file="/Menu.jsp" %>
		<div class="card-body">
	    	<div class="row">
  				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>Titulo</th>
							<th>Descricao</th>
							<th>Valor Atual</th>
							<th>Valor Alcançado</th>
							<th>Data Limite</th>
							<th>Id Dono</th>
							<th>Opções</th>
						</tr>
						
					</thead>
					<tr>
					<%-- <% 
					List<MetaBean> lista = new MetaDAO().listarTodasMetas();
					
					for(MetaBean meta : lista){%>
					
						<td><%=meta.getTitulo()%></td>
						<td><%=meta.getDescricao() %></td>
						<td><%=meta.getValorMeta() %></td>
						<td><%=meta.getValorAtual() %></td>
						<td><%=meta.getDataLimite() %></td>
						<td><%=meta.getUsuarioId() %></td>
						<td>
							<a href="http://localhost:8080/PorkrinhoWeb/DoacaoServlet?logica=CadastrarDoacao&idMeta=<%=meta.getId() %>&action=form" class="fas">Doar</a>
						</td>
					  <% } %>
			        </tr> --%>
					<c:forEach items="${lista}" var="meta">
					<tr>
						<td>${meta.getTitulo()}</td>
						<td>${meta.getDescricao()}</td>
						<td>${meta.getValorMeta()}</td>
						<td>${meta.getValorAtual()}</td>
						<td>${meta.getDataLimite()}</td>
						<td>${meta.getUsuarioId()}</td>	
						<td>
							<a href="http://localhost:8080/PorkrinhoWeb/DoacaoServlet?logica=CadastrarDoacao&idMeta=${meta.getId()}&action=form" class="fas">Doar</a>
						</td>						
					</tr>
					</c:forEach>
			    </table>
			</div>
		</div>
	</div>
</div>
				

</body>
</html>