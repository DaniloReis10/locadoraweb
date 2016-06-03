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
        document.getElementById('city').value = (dados.localidade);
        document.getElementById('state').value = (dados.uf);
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

function iniciarRequisicao() {
	
	 var request = false;  
	             try 
	             {  
	                 request = new XMLHttpRequest();  
	             }
	             catch (trymicrosoft) 
	             {  
	                 try 
	                 {  
	                     request = new ActiveXObject("Msxml2.XMLHTTP");  
	                 } 
	                 catch (othermicrosoft) 
	                 {  
	                     try 
	                     {  
	                         request = new ActiveXObject("Microsoft.XMLHTTP");  
	                     } catch (failed) 
	                     {  
	                         request = false;  
	                     }    
	                 }
	                 
	             }  
	return request;
}

function cadastrarCliente()
{
	
	var nome = document.getElementsByName("name")[0].value;
	var sobrenome= document.getElementsByName("last-name")[0].value;
	var email = document.getElementsByName("email")[0].value;
	var nascimento = document.getElementsByName("date")[0].value;
	var genero = document.getElementsByName("sex")[0].value;
	var senha = document.getElementsByName("pwd")[0].value;
	var cep = document.getElementsByName("zipcode")[0].value;
	var estado= document.getElementsByName("state")[0].value;
	var cidade = document.getElementsByName("city")[0].value;
	var rua = document.getElementsByName("street")[0].value;
	var bairro = document.getElementsByName("area")[0].value
	var numero = document.getElementsByName("number")[0].value;
	
	var url=null;
	
	url="../ajax/ajaxClientes.jsp?comando=cadastrarCliente&nome="+nome+"&email="+email+"&sobrenome="+sobrenome+"&nascimento="+nascimento+"&genero="+genero+"&senha="+senha+"&cep="+cep+"&estado="+estado+"&cidade="+cidade+"&rua="+rua+"&bairro="+bairro+"&numero="+numero;
	
	var requisicaoLocal=iniciarRequisicao();
	requisicaoLocal.onreadystatechange=function()
		{
		respostaCadastrarCliente(requisicaoLocal);
		};
	requisicaoLocal.open("POST",url,'false');
	requisicaoLocal.send(null);

}
         
function respostaCadastrarCliente(requisicao) 
{
	if(requisicao.readyState==4)
	{
		if(requisicao.status==200)
		{
			var xml;
			eval("xml="+requisicao.responseText);
			var status=xml.root.validacao;
			
			if(status == 0)
				alert("Cadastro efetuado com sucesso!");
				else
				alert("N�o foi possivel efetuar o cadastro!");					
		}
	}
}

function cadastrarFuncionario()
{
	
	var nome = document.getElementsByName("name")[0].value;
	var sobrenome= document.getElementsByName("last-name")[0].value;
	var email = document.getElementsByName("email")[0].value;
	var nascimento = document.getElementsByName("date")[0].value;
	var cpf = document.getElementsByName("cpf")[0].value;
	var pis = document.getElementsByName("pis")[0].value;
	var genero = document.getElementsByName("sex")[0].value;
	var departamento= document.getElementsByName("dpt")[0].value;
	var senha = document.getElementsByName("pwd")[0].value;
	var cep = document.getElementsByName("zipcode")[0].value;
	var rua = document.getElementsByName("street")[0].value;
	var estado = document.getElementsByName("state")[0].value;
	var cidade = document.getElementsByName("city")[0].value;
	var bairro= document.getElementsByName("area")[0].value;
	var numero = document.getElementsByName("number")[0].value;
	
	var url=null;
	
	url="../ajax/ajaxFuncionarios.jsp?comando=cadastrarFuncionario&nome="+nome+"&email="+email+"&sobrenome="+sobrenome+"&nascimento="+nascimento+"&cpf="+cpf+"&pis="+pis+"&genero="+genero+"&departamento="+departamento+"&senha="+senha+"&cep="+cep+"&rua="+rua+"&estado="+estado+"&cidade="+cidade+"&bairro="+bairro+"&numero="+numero;
	
	var requisicaoLocal=iniciarRequisicao();
	requisicaoLocal.onreadystatechange=function()
		{
		respostaCadastrarFuncionario(requisicaoLocal);
		};
	requisicaoLocal.open("POST",url,'false');
	requisicaoLocal.send(null);

}
         
function respostaCadastrarFuncionario(requisicao) 
{
	if(requisicao.readyState==4)
	{
		if(requisicao.status==200)
		{
			var xml;
			eval("xml="+requisicao.responseText);
			var status=xml.root.validacao;
			
			if(status == 0)
				alert("Cadastro efetuado com sucesso!");
				else
				alert("N�o foi possivel efetuar o cadastro!");					
		}
	}
}
