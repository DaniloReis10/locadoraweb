function checkPWD(pwd, pwd_conf) {

    var pwd = document.forms["client-form"]["pwd"].value;
    var pwd_conf = document.forms["client-form"]["pwd-conf"].value;
    if (pwd != pwd_conf) {
        document.forms["client-form"]["pwd-conf"].setCustomValidity('Senha diferente');
        return false;
    }

    return true;
}

function getDados(dados) {
    if (!("erro" in dados)) {
        document.getElementById('street').value = (dados.logradouro);
        document.getElementById('area').value = (dados.bairro);
    } else{
        document.forms["client-form"]["zipcode"].setCustomValidity('CEP não encontrado');
    }
}

function checkCode(code) {

    var api = "http://api.postmon.com.br/v1/cep/";
    var url = api.concat(code);
    var script = document.createElement('script');
    script.src = 'http://viacep.com.br/ws/' + code + '/json/?callback=getDados';
    document.body.appendChild(script);
}
