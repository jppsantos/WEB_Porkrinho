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


function getAllGoals() {

  // Exemplo de requisição GET
  var ajax = new XMLHttpRequest();

  // Seta tipo de requisição e URL com os parâmetros
  ajax.open("GET", urlRoot + "/goal/all", true);

  // Envia a requisição
  ajax.send();

  // Cria um evento para receber o retorno.
  ajax.onreadystatechange = function () {
    // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
    if (this.readyState == 4 && this.status == 200) {

      // var tb = document.getElementById('table');
      // while (tb.rows.length > 1) {
      //   tb.deleteRow(1);
      // }

      var data = JSON.parse(this.response);

      data.forEach(goal => {

        const divSize = document.createElement('div');
        divSize.setAttribute('class', 'col-md-4 mt-3');

        const divCard = document.createElement('div');
        divCard.setAttribute('class', 'card');
        divCard.setAttribute('style', 'height: 500px');
        //
        const img = document.createElement('img');
        img.setAttribute('width', '200px');
        img.setAttribute('src', 'default.png');
        //
        const divCardBody = document.createElement('div');
        divCardBody.setAttribute('class', 'card-body');
        divCardBody.setAttribute('style', 'height: 600px');
        //
        const title = document.createElement('h4');
        title.setAttribute('class', 'card-title text-center');
        title.innerHTML = goal.title;
        //
        const percent = document.createElement('h6');
        percent.setAttribute('class', 'card-text text-right mt-2');
        percent.innerHTML = ((goal.value * 100) / goal.goalValue).toFixed() + '%';
        //
        const progress1 = document.createElement('div');
        progress1.setAttribute('class', 'progress');
        //
        const progress2 = document.createElement('div');
        progress2.setAttribute('class', 'progress-bar progress-bar-striped progress-bar-animated');
        progress2.setAttribute('style', 'width:' + (goal.value * 100) / goal.goalValue + '%; background-color:#F7ABAE;');

        //
        progress1.appendChild(progress2);
        //
        const metaValue = document.createElement('h6');
        metaValue.setAttribute('class', 'card-text text-left mt-3');
        metaValue.innerHTML = "Meta: R$" + goal.goalValue;
        //
        const description = document.createElement('p');
        description.setAttribute('class', 'card-text text-justify');
        goal.description = goal.description.substring(0, 360);
        description.innerHTML = goal.description + "...";
        //
        const divFooter = document.createElement('div');
        divFooter.setAttribute('class', 'card-footer');
        //
        const button1 = document.createElement('button');
        button1.setAttribute('class', 'btn btn-primary w-100');
        button1.innerHTML = 'Detalhes';
        button1.addEventListener("click", function () {
          vaiPageDoar(goal.idGoal);
        })
        //
        divFooter.appendChild(button1);
        //
        divCardBody.appendChild(title);
        divCardBody.appendChild(percent);
        divCardBody.appendChild(progress1);
        divCardBody.appendChild(metaValue);
        divCardBody.appendChild(description);
        divCardBody.appendChild(divFooter);
        //
        divCard.appendChild(img);
        divCard.appendChild(divCardBody);
        //
        divSize.appendChild(divCard);
        //
        document.getElementById("cards").appendChild(divSize);
        document.getElementById("error").innerHTML = "";
      });

    } else {
      document.getElementById("error").innerHTML = "Erro" + this.response;
    }
  }

}

/*
Lista usuários
*/
function getAllUsers() {

  // Exemplo de requisição GET
  var ajax = new XMLHttpRequest();

  // Seta tipo de requisição e URL com os parâmetros
  ajax.open("GET", urlRoot + "/user/all", true);

  // Envia a requisição
  ajax.send();

  // Cria um evento para receber o retorno.
  ajax.onreadystatechange = function () {
    // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
    if (this.readyState == 4 && this.status == 200) {

      var data = JSON.parse(this.response);

      data.forEach(mark => {

        document.getElementById("error").innerHTML = this.response;
      });

    } else {
      document.getElementById("error").innerHTML = "Erro";
    }
  }
}

/**
Vai para a página doar.htm
*/
function vaiPageDoar(idMeta) {
  if (verifiyUser()) {
    sessionStorage.setItem("idMeta", idMeta);
    // parent.location = 'createDonationScreen.htm';
    window.location = 'createDonationScreen.htm';
  }
}

/**
 * Carrega os dados da meta na página de doação pelo id
 */
function setDataDoacao() {
  // Exemplo de requisição GET
  var ajaxGoal = new XMLHttpRequest();

  // Seta tipo de requisição e URL com os parâmetros
  ajaxGoal.open("GET", urlRoot + "/goal/getbyid/" + sessionStorage.getItem('idMeta'), true);

  // Envia a requisição
  ajaxGoal.send();

  // Cria um evento para receber o retorno.
  ajaxGoal.onreadystatechange = function () {
    // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
    if (this.readyState == 4 && this.status == 200) {

      var data = JSON.parse(this.response);

      var idGoal = document.getElementById('idGoal');
      idGoal.value = data.idGoal;

      var title = document.getElementById('title');
      title.innerHTML = data.title;

      var value = document.getElementById('value');
      value.innerHTML = "R$" + data.value;

      var percent = document.getElementById('progress');
      percent.setAttribute('style', 'width:' + (data.value * 100) / data.goalValue + '%; background-color:#F7ABAE;');

      var valueGoal = document.getElementById('valueGoal');
      valueGoal.innerHTML = "Meta: R$" + data.goalValue;

      var date = document.getElementById('createDate');
      date.innerHTML = data.createDate;

      var description = document.getElementById('description');
      description.innerHTML = data.description;

      document.getElementById("error").innerHTML = "";
    } else {
      document.getElementById("error").innerHTML = "Erro ao buscar dados da meta.";
    }
  }

  // Exemplo de requisição GET
  var ajaxUser = new XMLHttpRequest();

  // Seta tipo de requisição e URL com os parâmetros
  ajaxUser.open("GET", urlRoot + "/user/getbyid/" + sessionStorage.getItem('idUser'), true);

  // Envia a requisição
  ajaxUser.send();

  // Cria um evento para receber o retorno.
  ajaxUser.onreadystatechange = function () {
    // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
    if (this.readyState == 4 && this.status == 200) {

      var data = JSON.parse(this.response);

      var dono = document.getElementById('dono');
      dono.innerHTML = data.name + " " + data.lastName;

      document.getElementById("error").innerHTML = "";
    } else {
      document.getElementById("error").innerHTML = "Erro ao buscar Usuário";
    }
  }

  // Exemplo de requisição GET
  var ajaxGoalDonations = new XMLHttpRequest();

  // Seta tipo de requisição e URL com os parâmetros
  ajaxGoalDonations.open("GET", urlRoot + "/donation/goaldonations/" + sessionStorage.getItem('idMeta'), true);

  // Envia a requisição
  ajaxGoalDonations.send();

  // Cria um evento para receber o retorno.
  ajaxGoalDonations.onreadystatechange = function () {
    // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
    if (this.readyState == 4 && this.status == 200) {

      var data = JSON.parse(this.response);

      data.forEach(donation => {

        var line = document.createElement("tr");
        line.name = "line"
        var column1 = document.createElement("th");
        if (donation.isAnonymous) {
          column1.innerHTML = "Anônimo";
        } else {
          column1.innerHTML = donation.idUser;
        }

        line.appendChild(column1);

        var column2 = document.createElement("th");
        column2.innerHTML = donation.value;
        line.appendChild(column2);

        var column3 = document.createElement("th");
        column3.setAttribute('class', 'text-left');
        column3.innerHTML = donation.message;

        line.appendChild(column3);

        var column4 = document.createElement("th");
        column4.innerHTML = donation.date;
        line.appendChild(column4);

        document.getElementById("table").appendChild(line);
        document.getElementById("error").innerHTML = "";
      });

    } else {
      document.getElementById("error").innerHTML = "Erro ao buscar contribuições da meta.";
    }
  }
}

/**
Vai para a página doar.htm
*/
// function createMark() {
//   if (verifiyUser()) {
//     // sessionStorage.setItem("idUser", idUser);
//     // parent.location = 'createMarkScreen.htm';
//     window.location = "createMarkScreen.htm";
//   } else {
//     sessionStorage.setItem("page", "createMarkScreen.htm");


//   }
// }



/*
Verifica se o usuário está logado
*/
function verifiyUser() {
  if (sessionStorage.getItem('idUser') == null) {
    logOut();
    return false;
  }
  return true;
}

/*
Desloga o usuário e manda para a página de login
*/
function logOut() {
  sessionStorage.removeItem('idUser');
  // parent.location = "loginScreen.htm";
  window.location = "loginScreen.htm";
}

/*
Valida o login do usuário
*/
function login(cpf, password) {

  // Exemplo de requisição GET
  var ajaxUser = new XMLHttpRequest();

  // Seta tipo de requisição e URL com os parâmetros
  ajaxUser.open("POST", urlRoot + "/user/login", true);

  // Seta tipo de requisição e URL com os parâmetros
  ajaxUser.open("POST", urlRoot + "/user/login", true);
    
   ajaxUser.setRequestHeader("Content-Type", "application/json");

  // Envia a requisição
    var text = '{"cpf": "' + cpf + '", "password": "'+ password + '"}';
  ajaxUser.send(text);
  
  // Cria um evento para receber o retorno.
  ajaxUser.onreadystatechange = function () {
    // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
    if (this.readyState == 4 && this.status == 200) {

      var user = JSON.parse(this.response);

      sessionStorage.setItem('idUser', user.idUser);

      parent.location = 'index.htm';

      document.getElementById("error").innerHTML = "";
    } else {
      alert("Usuário e/ou senha errado(s)! Tente novamente!");
      document.getElementById("error").innerHTML = "Usuário e/ou senha errado(s)! Tente novamente!";
    }
  }

}

/*
Cadastra usuário
*/
function addUser() {
  // Exemplo de requisição GET
  var ajax = new XMLHttpRequest();
  // Seta tipo de requisição e URL com os parâmetros
  ajax.open("POST", urlRoot + "/user", true);
  ajax.setRequestHeader("Content-Type", "application/json");

  //Obtem os valores dos campos
  var name = document.getElementById("name").value;
  var lastName = document.getElementById("lastName").value;
  var cpf = document.getElementById("cpf").value;
  // var age = document.getElementById("age").value;
  var email = document.getElementById("email").value;
  var password = document.getElementById("password").value;
  var phone = document.getElementById("phone").value;
  var idBank = document.getElementById("idBank").value;
  var agency = document.getElementById("agency").value;
  var account = document.getElementById("account").value;
  // var pathImg = document.getElementById("pathImg").value;



  //converte os valores para json e manda no param
  var text = '{"name":"' + name +
    '","lastName":"' + lastName +
    '","cpf":"' + cpf +
    '","email":"' + email +
    '","phone":"' + phone +
    '","password":"' + password +
    '","bankAgency":"' + agency +
    '","bankAccount":"' + account +
    '","idBank":"' + idBank +
    '","imgPath":"sdfg"}';

  alert("text: " + text);

  // Envia a requisição
  ajax.send(text);
  // Cria um evento para receber o retorno.
  ajax.onreadystatechange = function () {
    // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
    if (this.readyState == 4 && this.status == 200) {
      var data = JSON.parse(this.response);
      alert("Cadastro realizado com sucesso! Seja Bem vindo ao Porkrinho ☺️!");
      document.getElementById("error").innerHTML = "";
      parent.location = "loginScreen.htm"
    } else {
      alert("Erro no Cadastro 😞 Tenta de Novo ☺️");
    }
  }
}

/*
Cadastra Meta
*/
function addMark() {

  if (verifiyUser()) {
    // Exemplo de requisição GET
    var ajax = new XMLHttpRequest();
    // Seta tipo de requisição e URL com os parâmetros
    ajax.open("POST", urlRoot + "/goal", true);
    // ajax.setRequestHeader("Content-Type", "application/json", "charset", "utf-8");
    ajax.setRequestHeader("Content-Type", "application/json");

    //Obtem os valores dos campos
    var idUser = sessionStorage.getItem('idUser');
    var title = document.getElementById("title").value;
    var description = document.getElementById("description").value;
    var goalDate = document.getElementById("goalDate").value;
    var goalValue = document.getElementById("markValue").value;
    var isPublic = document.getElementById("isPublic").value == "on" ? true : false;
    // var pathImg = document.getElementById("pathImg").value;

    //converte os valores para json e manda no param
    // var text = '{"idUser":'+ idUser +',"title":"'+ title +'","description":"'+ description +'","currentValue":0.0,"markValue":'+ markValue +',"pathImg":"undefined","isPublic":'+ isPublic +'}';
    // var text = '{"idUser":0,"title":"atom","description":"veio do atom","currentValue":0.0,"markValue":dfgh,"pathImg":"undefined","isPublic":0}';

    //converte os valores para json e manda no param
    var text = '{"title":"' + title +
      '","description":"' + description +
      '","value":"' + 0.0 +
      '","goalValue":"' + goalValue +
      '","goalDate":"' + goalDate +
      '","createDate":"' + "30-02-2020" +
      '","isPublic":"' + isPublic +
      '","idUser":"' + idUser +
      '","imgPath":"defaultImg"}';
    alert(text);

    // Envia a requisição
    ajax.send(text);

    // ajax.send(JSON.parse({ "name": "aaa", "lastName": "gomes", "cpf": "1234", "email": "wer@ffg", "password": "pass", "phone": "2345", "idBank": "0", "agency": "23", "account" : "123", "pathImg": "dsfgdsfg" }));
    // Cria um evento para receber o retorno.
    ajax.onreadystatechange = function () {
      // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
      if (this.readyState == 4 && this.status == 200) {
        var data = JSON.parse(this.response);
        document.getElementById("error").innerHTML = "foi " + data;
        alert("Meta cadastrada com sucesso! Agora só falta ela se realizar ☺️!");
      } else {
        document.getElementById("error").innerHTML = "Erro " + this.response;
      }

    }

  }
}

function findUserByCpf(cpf) {
  // Exemplo de requisição GET
  var ajax = new XMLHttpRequest();

  // Seta tipo de requisição e URL com os parâmetros
  ajax.open("POST", urlRoot + "/user/find/" + cpf, true);

  // Envia a requisição
  ajax.send();

  // Cria um evento para receber o retorno.
  ajax.onreadystatechange = function () {
    // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
    if (this.readyState == 4 && this.status == 200) {
      var cpf = JSON.parse(this.response);
      // cpf.forEach(user => {
      //
      // });
      document.getElementById("error").innerHTML = "";
    } else {
      document.getElementById("error").innerHTML = "Erro";
    }
  }
}

function search(content) {
  var searchedItem = document.getElementById("search").value;
  sessionStorage.setItem("searchedItem", searchedItem);
  alert(searchedItem);
  // parent.location = "index.jsp";
}


function getUserMarks() {

  // Exemplo de requisição GET
  var ajax = new XMLHttpRequest();

  var idUser = sessionStorage.getItem('idUser');
  // Seta tipo de requisição e URL com os parâmetros
  ajax.open("GET", urlRoot + "/goal/usergoals/" + idUser, true);

  // Envia a requisição
  ajax.send();

  // Cria um evento para receber o retorno.
  ajax.onreadystatechange = function () {
    // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
    if (this.readyState == 4 && this.status == 200) {

      var tb = document.getElementById('table');
      while (tb.rows.length > 1) {
        tb.deleteRow(1);
      }
      alert("dados: " + this.response);
      var data = JSON.parse(this.response);

      
      data.forEach( goal => {
        var line = document.createElement("tr");
        line.name = "line"

        var column1 = document.createElement("th");
        var button2 = document.createElement("input");
        button2.type = "button";
        button2.value = goal.idGoal;
        button2.addEventListener("click", function () {
          vaiPageDoar(goal.idGoal);
        })
        button2.setAttribute('class', 'btn btn-link btn-success');
        column1.appendChild(button2);
        line.appendChild(column1);

        var column2 = document.createElement("th");
        column2.innerHTML = goal.title;
        line.appendChild(column2);

        var column3 = document.createElement("th");
        column3.innerHTML = goal.createDate;
        line.appendChild(column3);

        var column4 = document.createElement("th");
        column4.innerHTML = goal.value;
        line.appendChild(column4);

        var column5 = document.createElement("th");

        var button = document.createElement("input");
        button.type = "button";
        button.value = "Sacar";
        button.addEventListener("click", function () {
          sacar(goal.idGoal);
        })
        button.setAttribute('class', 'btn btn-link btn-success');

        column5.appendChild(button);

        line.appendChild(column5);

        document.getElementById("table").appendChild(line);
        //document.getElementById("error").innerHTML = "";
      });

    } else {
      document.getElementById("error").innerHTML = "Erro" + this.response;
    }
  }

}

function sacar(idGoal) {
  alert("Saque relaizado com sucesso 😃!");
}

function profile() {
  if (verifiyUser()) {
    window.location = 'profile.htm';
  } else {
    window.location = 'loginScreen.htm';
  }
}

