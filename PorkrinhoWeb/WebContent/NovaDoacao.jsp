<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link 	rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
		crossorigin="anonymous">
	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova Doacao</title>
</head>
<body>
	<div class="container">
		<div class="card text-center">
			<div class="card-body">
				<h2>Insira aqui os dados da sua nova doacao</h2>
				<form action="DoacaoServlet" method="post">
					<input type="hidden" name="logica" value="CadastrarDoacao">
					
					<div class="form-group row">
						<label class="col-sm-2">Id da Meta:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="idMeta" value="${idMeta}" readonly>
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-sm-2">Valor</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="txtValor"
								placeholder="Valor">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-2">Mensagem</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="txtMensagem"
								placeholder="Digite uma mensagem para quem vai receber sua doação">
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-sm-2">Tornar contribuicao anonima</label>
						<div class="col-sm-7">
							<input type="checkbox" class="form-control" name="txtEhAnonimo" >
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-sm-2">Deseja receber notificacões?</label>
						<div class="col-sm-7">
							<input type="checkbox" class="form-control" name="txtEhNotificado">
						</div>
					</div>
					
					<button type="submit" class="btn btn-primary">Cadastrar</button>
					
				</form>
				<h6 class="text-danger">${erro}</h6>
			</div>
		</div>

	</div>
</body>
</html>