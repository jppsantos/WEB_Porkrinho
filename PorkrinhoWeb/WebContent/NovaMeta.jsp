<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link 	rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
		crossorigin="anonymous">
		
		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Nova Meta</title>
</head>
<body>
	<div class="container">
		<div class="card text-center">
			<%-- <%@include file="/WEB-INF/jsp/MenuBar.jsp"%> --%>
			<div class="card-body">
				<h2>Insira aqui os dados da sua nova Meta</h2>
				<form action="Meta" method="post">
					<input type="hidden" name="logica" value="CadastrarMeta">
					
					<div class="form-group row">
						<label class="col-sm-2">Titulo</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="txtTitulo"
								placeholder="Digite aqui um belo titulo para sua Meta">
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-sm-2">Descricao</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="txtDescricao"
								placeholder="Explique aqui do que exatamente se trata a sua Meta">
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-sm-2">Valor Alvo</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="txtValor"
							placeholder="Este eh o valor que você deseja atingir" >
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-sm-2">Data Limite</label>
						<div class="col-sm-7">
							<input type="datetime" class="form-control" name="txtData"
							placeholder="Em que data espera que sua data se cumpra?">
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-sm-2">Sua meta eh publica?</label>
						<div class="col-sm-7">
							<input type="checkbox" class="form-control" name="ehPublico">
						</div>
					</div>
					
					<button type="submit" class="btn btn-primary">Cadastrar Meta</button>
				</form>
			</div>
		</div>

	</div>
</body>
</html>