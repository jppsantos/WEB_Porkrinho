// import * as userBean from '/br.com.porkrinho.bean.UserBean.java';
var urlRoot = "http://localhost:8080/porkrinho/api";

// function getAllUsers(){
//     // Exemplo de requisição GET
//     var ajax = new XMLHttpRequest();
//
//     // Seta tipo de requisição e URL com os parâmetros
//     ajax.open("GET", urlRoot + "/user/all", true);
//
//     // Envia a requisição
//     ajax.send();
//
//     // Cria um evento para receber o retorno.
//     ajax.onreadystatechange = function() {
//     // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
//         if (this.readyState == 4 && this.status == 200) {
//             var data = JSON.parse(this.response);
//             data.forEach(user => {
//                 document.getElementById("error").innerHTML = "";
//             });
//         }else{
//
//             document.getElementById("error").innerHTML = "erro";
//         }
//     }
//   }


function getAllMarks(){

    // Exemplo de requisição GET
    var ajax = new XMLHttpRequest();

    // Seta tipo de requisição e URL com os parâmetros
    ajax.open("GET", urlRoot + "/mark/all", true);

    // Envia a requisição
    ajax.send();

    // Cria um evento para receber o retorno.
    ajax.onreadystatechange = function() {
    // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
        if (this.readyState == 4 && this.status == 200) {
           
          var tb = document.getElementById('table');
          while(tb.rows.length > 1) {
            tb.deleteRow(1);
          }

            var data = JSON.parse(this.response);

            data.forEach(mark => {
              // alert("entroou");
                var line = document.createElement("tr");
                line.name = "line"
                var column1 = document.createElement("th");
                column1.innerHTML = mark.title;
                line.appendChild(column1);

                var column2 = document.createElement("th");
                column2.innerHTML = mark.description;
                line.appendChild(column2);

                var column3 = document.createElement("th");
                column3.innerHTML = mark.currentValue;
                line.appendChild(column3);

                var column4 = document.createElement("th");
                column4.innerHTML = mark.markValue;
                line.appendChild(column4);

                var column5 = document.createElement("th");

                var button = document.createElement("input");
                button.type = "button";
                button.value = "Doar";
                button.addEventListener("click", function(){
                  doar(mark.idUser, mark.idMark);
                })
                button.setAttribute('class', 'btn btn-link');

                column5.appendChild(button);

                line.appendChild(column5);

                document.getElementById("table").appendChild(line);
                document.getElementById("error").innerHTML = "";
            });

        }else{
            document.getElementById("error").innerHTML = "Erro  dd" + this.response ;
        }
    }
}

function getAllUsers(){

    // Exemplo de requisição GET
    var ajax = new XMLHttpRequest();

    // Seta tipo de requisição e URL com os parâmetros
    ajax.open("GET", urlRoot + "/user/all", true);

    // Envia a requisição
    ajax.send();

    // Cria um evento para receber o retorno.
    ajax.onreadystatechange = function() {
    // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
        if (this.readyState == 4 && this.status == 200) {

            var data = JSON.parse(this.response);

            data.forEach(mark => {

                document.getElementById("error").innerHTML = this.response;
            });

        }else{
            document.getElementById("error").innerHTML = "Erro";
        }
    }
}

function printIDinDonation() {
    var idUser = sessionStorage.getItem('idUser');
    var idMeta = sessionStorage.getItem('idMeta');

    // document.getElementById("idUser").innerHTML.value = idUser;
    document.getElementById("idMeta").value = idMeta;
}

/**
Vai para a página doar.htm
*/
function doar(idUser,idMeta){
    sessionStorage.setItem("idUser", idUser);
    sessionStorage.setItem("idMeta", idMeta);
    parent.location  = 'createDonationScreen.htm';
}

function getMovie(){
  var favoriteMovie = sessionStorage.getItem('favoriteMovie');
  // alert(favoriteMovie);
}

function addUser(){
    // Exemplo de requisição GET
    var ajax = new XMLHttpRequest();
    // Seta tipo de requisição e URL com os parâmetros
    ajax.open("POST", urlRoot + "/user/add", true);
    ajax.setRequestHeader("Content-Type", "application/json",);
    
    //Obtem os valores dos campos
    var name = document.getElementById("name").value;
    var lastName = document.getElementById("lastName").value;
    var cpf = document.getElementById("cpf").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var phone = document.getElementById("phone").value;
    var idBank = document.getElementById("idBank").value;
    var agency = document.getElementById("agency").value;
    var account = document.getElementById("account").value;
    var pathImg = document.getElementById("pathImg").value;

    

    //converte os valores para json e manda no param
    var text = '{"name":"'+ name +'","lastName":"'+ lastName +'","cpf":"'+ cpf +'","email":"'+ email +'","password":"'+ password +'","phone":"'+ phone +'","idBank":"'+ idBank +'","agency":"'+ agency +'","account":"'+ account +'","pathImg":"sdfg"}'

    // Envia a requisição
    ajax.send(text);

    // Cria um evento para receber o retorno.
    ajax.onreadystatechange = function() {
    // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
        if (this.readyState == 4 && this.status == 200) {
            var data = JSON.parse(this.response);

            document.getElementById("error").innerHTML = "";
        }else{

        }
        document.getElementById("error").innerHTML = "Error: " + this.response;
    }
}

function addMark(){
    
    // Exemplo de requisição GET
    var ajax = new XMLHttpRequest();
    // Seta tipo de requisição e URL com os parâmetros
    ajax.open("POST", urlRoot + "/mark", true);
    ajax.setRequestHeader("Content-Type", "application/json",);

     //Obtem os valores dos campos
    var idUser = sessionStorage.getItem('idUser');
    var title = document.getElementById("title").value;
    var description = document.getElementById("description").value;
    var markValue = document.getElementById("markValue").value;
    var isPublic = document.getElementById("isPublic").value == "on" ? true : false;
    // var pathImg = document.getElementById("pathImg").value;

    //converte os valores para json e manda no param
    var text = '{"idUser":'+ idUser +',"title":"'+ title +'","description":"'+ description +'","currentValue":0.0,"markValue":'+ markValue +',"pathImg":"undefined","isPublic":'+ isPublic +'}';

    // Envia a requisição
    ajax.send(text);

    // ajax.send(JSON.parse({ "name": "aaa", "lastName": "gomes", "cpf": "1234", "email": "wer@ffg", "password": "pass", "phone": "2345", "idBank": "0", "agency": "23", "account" : "123", "pathImg": "dsfgdsfg" }));
    // Cria um evento para receber o retorno.
    ajax.onreadystatechange = function() {
    // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
    alert("readyState : " + this.readyState + " space/ status: " + this.status + " s: " + this.response);
        if (this.readyState == 4 && this.status == 200) {
            var data = JSON.parse(this.response);
            document.getElementById("error").innerHTML = data;
        }else{
          document.getElementById("error").innerHTML = "Erro " + this.response;
        }
    }
}

function findUserByCpf(cpf){
    // Exemplo de requisição GET
    var ajax = new XMLHttpRequest();

    // Seta tipo de requisição e URL com os parâmetros
    ajax.open("POST", urlRoot + "/user/find/" + cpf, true);

    // Envia a requisição
    ajax.send();

    // Cria um evento para receber o retorno.
    ajax.onreadystatechange = function() {
    // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
        if (this.readyState == 4 && this.status == 200) {
            var cpf = JSON.parse(this.response);
            // cpf.forEach(user => {
            //
            // });
            document.getElementById("error").innerHTML = "";
        }else{
            document.getElementById("error").innerHTML = "Erro";
        }
    }
}
