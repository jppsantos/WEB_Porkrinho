
<meta charset="UTF-8">
 <h3>Page Initial</h3>
	
<a href="TratarMeta/FormCadastrarMeta.jsp" class="btn btn-outline-primary text-center">Cadastrar Meta</a>

<form method="get" action="MetaServlet">
	<div class="form-group row">
		<div class="col-sm-8">
			<input type="text" class="form-control" placeholder="Search..." name="search">
		</div>
		<input type="hidden" value="BuscarMeta" name="logica">
		<input type="submit" class="btn secondary" value="Search">
	</div>
</form>

<!-- <div class="card-header">
	<ul class="nav nav-tabs card-header-tabs nav-justified">
		<li class="nav-item">
			<a class="nav-link active" href="http://localhost:8080/AvaliacaoMVCLocadora/MetaServlet?logica=ListarCarro">Metas</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="http://localhost:8080/AvaliacaoMVCLocadora/MetaServlet?logica=ListarCarrosDisponiveis">Alugar</a>
		</li>
	</ul>
	
</div> -->