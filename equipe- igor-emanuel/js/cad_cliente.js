function validateForm(){

    var cep = document.forms["client-form"]["zipcode"].value;
    var pwd = document.forms["client-form"]["pwd"].value;
    var pwd_conf = document.forms["client-form"]["pwd-conf"].value;

    if(pwd == pwd_conf){
        clearForm();
        return true;
    }

    getZipCode(cep);

}

function getZipCode(code){
    script.src = '//viacep.com.br/ws/'+ code + '/json/?callback=meu_callback';

}

function clearForm(){
    document.getElementById('name').value=("");
    document.getElementById('last-name').value=("");
    document.getElementById('sex').value=("");
    document.getElementById('pwd').value=("");
    document.getElementById('pwd-conf').value=("");
    document.getElementById('area').value=("");
    document.getElementById('number').value=("");
    document.getElementById('zipcode').value=("");
}
