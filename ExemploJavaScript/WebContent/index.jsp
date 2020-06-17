<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

//Converter string em array
function exemplo1(){
	var meuArray = Array.from("JOAO");
	document.getElementById("mostrar").innerHTML = meuArray;
}

// Verifica se determinado valor existe no array
function exemplo2() {
	var nomes = ["Bernardo","Joao","Caio","Ana","Tiago"];
	var existsInArray = nomes.includes("Caio");
	document.getElementById("mostrar").innerHTML = existsInArray;
}

// Insere um novo valor no array
function exemplo3() {
	var nomes = ["Bernardo","Joao","Caio","Ana","Tiago"];
	nomes.push("Aline");
	document.getElementById("mostrar").innerHTML = nomes;
}

// Remover o ultimo valor no array  
function exemplo4() {
	var nomes = ["Bernardo","Joao","Caio","Ana","Tiago"];
	nomes.pop();
	document.getElementById("mostrar").innerHTML = nomes;
}

//Unir/Concaternar valores dois arrays 
function exemplo5() {
	var nomes = ["Bernardo","Joao","Caio","Ana","Tiago"];
	var nomes2 = ["Gerson","Tito","Marcos","Bartolomeu","Ferreira"];
	var num = [1,2,4];
	var concat = nomes.concat(nomes2).concat(num);
	document.getElementById("mostrar").innerHTML = concat;
}

// Encontrar o maior valor em um array
function exemplo6() {
	document.getElementById("mostrar").innerHTML = Math.max(5,8,2,5,7);
}

//Encontrar o menor valor em um array
function exemplo7() {
	document.getElementById("mostrar").innerHTML = Math.min(5,8,2,5,7);
}
</script>

<meta charset="UTF-8">
<title>Exemplo Javascript</title>
</head>
<body>

<p>Bom dia pessoal. Vamos iniciar nossa <mark>semana programando!</mark></p>

<div id = "mostrar">
	
</div>

<input type = "button" value="Chamar funcao" onclick="exemplo7();">

</body>
</html>