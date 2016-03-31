function validateForm() {

    var cep = document.forms["client-form"]["zipcode"].value;
    var pwd = document.forms["client-form"]["pwd"].value;
    var pwd_conf = document.forms["client-form"]["pwd-conf"].value;

    if (pwd == pwd_conf) {
        clearForm();
        return true;
    }


}

function getDados(dados) {
    alert("here");
    document.getElementById('rua').value = (dados.logradouro);
    document.getElementById('bairro').value = (dados.bairro);
    document.getElementById('cidade').value = (dados.localidade);
    document.getElementById('estado').value = (dados.estado);
    document.getElementById('cidade').value = (dados.cidade);
}

function checkCode(code) {
    var api = "http://api.postmon.com.br/v1/cep/";
    var url = api.concat(code);
    var script = document.createElement('script');
    //insertReply("igor");
    script.src = 'http://api.postmon.com.br/v1/cep/' + code + '?callback=getDados';
    document.body.appendChild(script);
}

function clearForm() {
    document.getElementById('name').value = ("");
    document.getElementById('last-name').value = ("");
    document.getElementById('sex').value = ("");
    document.getElementById('pwd').value = ("");
    document.getElementById('pwd-conf').value = ("");
    document.getElementById('area').value = ("");
    document.getElementById('number').value = ("");
    document.getElementById('zipcode').value = ("");
}
