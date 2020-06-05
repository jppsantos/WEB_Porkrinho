
function rentCar(id) {
    url = 'http://localhost:8080/Prova01/CarServlet';
    data = 'id='+ id + '&btnSubmit=' + $('#btnSubmit').val();
    this.sendRequest(url, data);
}

function remCar(id) {
    url = 'http://localhost:8080/Prova01/CarServlet';
    data = 'id='+ id + '&btnSubmit=' + $('#btnRem').val();
    this.sendRequest(url, data);
}

function editCar(id, brand, model, year_model, chassi, plate_license, availability) {
    localStorage.setItem("idCar", id);
    localStorage.setItem("brandCar", brand);
    localStorage.setItem("modelCar", model);
    localStorage.setItem("yearModelCar", year_model);
    localStorage.setItem("chassiCar", chassi);
    localStorage.setItem("plateLicenseCar", plate_license);
    localStorage.setItem("availabilityCar", availability);
    window.location = "editCar.jsp";
}

function sendRequest(url, data) {
    $.ajax({
        url: url,
        type: 'POST',
        data: data,
        succes: function(message) {
            console.log(message);
        },
        error: function(message) {
            console.log(message);
        }
    }).done(function() {
        window.location.reload();
    });
}