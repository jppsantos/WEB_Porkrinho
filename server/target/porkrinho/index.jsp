<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css%22%3E">
    <script type="text/javascript" src="script.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js%22%3E"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js%22%3E"></script>
    <meta charset="UTF-8">


    <title>Listar Metas</title>
</head>
<body style="background-color:#FAE4E5;" onload="getAllMarks();">

  <script>
  	fetch("./navBar.htm").then(response => {
  			return response.text();
  	}).then(data => {
  			document.querySelector("header").innerHTML = data;
  	});
  </script>
  <div class="container">
  	<header></header>
  </div>

    <div class="container col-sm-12 mt-5">
        <div class="card text-center ">
            <div class="card-body">
                <div class="row">

                </div>
                <table class="table" id="table">
                <thead class="thead-light">
                    <tr>
                        <th>Titulo</th>
                        <th>Descricao</th>
                        <th>Valor Atual</th>
                        <th>Valor Alcançado</th>
                        <!-- <th>Data Limite</th> -->
                        <th>Opções</th>
                    </tr>
                </thead>

                </table>
            </div>
        </div>
        <div class="card text-center">
            <h3 id="error" class="text-danger"></h3>
            <!-- <input type="button" class="btn btn-secondary btn-small col-md-4 mt-5 " id="bt" onclick="doar();" value="Doe"> -->
        </div>
    </div>

    <!-- Form de busca -->
			<form action="#" method="get">
				<div class="form-inline row mx-0 mb-3 justify-content-end">
					<input class="form-control text-center col" name="filter" type="search" placeholder="Pesquisar marca ou modelo" aria-label="Pesquisar marca ou modelo" required>
					<button class="btn btn-outline-primary ml-2 col-2 col-sm-1" type="submit"><i class="fas fa-search"></i>Search</button>
				</div>
			</form>

			<div class="row row-cols-1 row-cols-md-3">
        <div class="col-md-3">
          <div class="card">
						<div class="text-center h-10 ">
							<svg class="bi bi-person" width="10em" height="10em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" d="M13 14s1 0 1-1-1-4-6-4-6 3-6 4 1 1 1 1h10zm-9.995-.944v-.002.002zM3.022 13h9.956a.274.274 0 0 0 .014-.002l.008-.002c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664a1.05 1.05 0 0 0 .022.004zm9.974.056v-.002.002zM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
              </svg>
						</div>

            <div class="card-body">
              <h4 class="card-title"><a>Card title</a></h4>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                content.</p>
            </div>
            <div class="card-footer">
  						<button type="button" class="btn btn-primary w-100">Detalhes</button>
  					</div>
          </div>
				</div>
        <div class="col-md-3">
          <div class="card">
						<div class="text-center h-10 ">
							<svg class="bi bi-person" width="10em" height="10em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" d="M13 14s1 0 1-1-1-4-6-4-6 3-6 4 1 1 1 1h10zm-9.995-.944v-.002.002zM3.022 13h9.956a.274.274 0 0 0 .014-.002l.008-.002c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664a1.05 1.05 0 0 0 .022.004zm9.974.056v-.002.002zM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
              </svg>
						</div>

            <div class="card-body">
              <h4 class="card-title"><a>Card title</a></h4>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                content.</p>
            </div>
            <div class="card-footer">
  						<button type="button" class="btn btn-primary w-100">Detalhes</button>
  					</div>
          </div>
				</div>

        <div class="col-md-3">
          <div class="card">
						<div class="text-center h-10 ">
							<svg class="bi bi-person" width="10em" height="10em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" d="M13 14s1 0 1-1-1-4-6-4-6 3-6 4 1 1 1 1h10zm-9.995-.944v-.002.002zM3.022 13h9.956a.274.274 0 0 0 .014-.002l.008-.002c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664a1.05 1.05 0 0 0 .022.004zm9.974.056v-.002.002zM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
              </svg>
						</div>

            <div class="card-body">
              <h4 class="card-title"><a>Card title</a></h4>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                content.</p>
            </div>
            <div class="card-footer">
  						<button type="button" class="btn btn-primary w-100">Detalhes</button>
  					</div>
          </div>
				</div>
        <div class="col-md-3">
          <div class="card">
						<div class="text-center h-10 ">
							<svg class="bi bi-person" width="10em" height="10em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" d="M13 14s1 0 1-1-1-4-6-4-6 3-6 4 1 1 1 1h10zm-9.995-.944v-.002.002zM3.022 13h9.956a.274.274 0 0 0 .014-.002l.008-.002c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664a1.05 1.05 0 0 0 .022.004zm9.974.056v-.002.002zM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
              </svg>
						</div>

            <div class="card-body">
              <h4 class="card-title"><a>Card title</a></h4>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                content.</p>
            </div>
            <div class="card-footer">
  						<button type="button" class="btn btn-primary w-100">Detalhes</button>
  					</div>
          </div>
				</div><div class="col-md-3 mt-2">
          <div class="card">
						<div class="text-center h-10 ">
							<svg class="bi bi-person" width="10em" height="10em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" d="M13 14s1 0 1-1-1-4-6-4-6 3-6 4 1 1 1 1h10zm-9.995-.944v-.002.002zM3.022 13h9.956a.274.274 0 0 0 .014-.002l.008-.002c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664a1.05 1.05 0 0 0 .022.004zm9.974.056v-.002.002zM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
              </svg>
						</div>

            <div class="card-body">
              <h4 class="card-title"><a>Card title</a></h4>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                content.</p>
            </div>
            <div class="card-footer">
  						<button type="button" class="btn btn-primary w-100">Detalhes</button>
  					</div>
          </div>
				</div>
      </div>
</body>
</html>
