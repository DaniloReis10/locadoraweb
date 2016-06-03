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

function logarCliente()
{
	
	var login = document.getElementById("login").value;
	var senha = document.getElementById("senha").value;
	
	var url=null;
	
	url="../ajax/ajaxLogins.jsp?comando=logarCliente&login="+login+"&senha="+senha;
	
	var requisicaoLocal=iniciarRequisicao();
	requisicaoLocal.onreadystatechange=function()
		{
		respostaLogarCliente(requisicaoLocal);
		};
	requisicaoLocal.open("POST",url,'false');
	requisicaoLocal.send(null);

}
          
function respostaLogarCliente(requisicao) 
{
	if(requisicao.readyState==4)
	{
		if(requisicao.status==200)
		{
			var xml;
			eval("xml="+requisicao.responseText);
			var status=xml.root.validacao;
			
			if(status)
			{
				alert("Login efetuado com sucesso!");
				window.location.href ='central.jsp';
			}else
				alert("Login ou senha incorretos!");					
		}
	}
}

function logarFuncionario()
{
	
	var login = document.getElementById("login").value;
	var senha = document.getElementById("senha").value;
	
	var url=null;
	
	url="../ajax/ajaxLogins.jsp?comando=logarFuncionario&login="+login+"&senha="+senha;
	
	var requisicaoLocal=iniciarRequisicao();
	requisicaoLocal.onreadystatechange=function()
		{
		respostaLogarFuncionario(requisicaoLocal);
		};
	requisicaoLocal.open("POST",url,'false');
	requisicaoLocal.send(null);

}
          
function respostaLogarFuncionario(requisicao) 
{
	if(requisicao.readyState==4)
	{
		if(requisicao.status==200)
		{
			var xml;
			eval("xml="+requisicao.responseText);
			var status=xml.root.validacao;
			
			if(status)
			{
				alert("Login efetuado com sucesso!");
				window.location.href ='central.jsp';
			}else
				alert("Login ou senha incorretos!");					
		}
	}
}