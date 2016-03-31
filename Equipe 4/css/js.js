function alerta_excluir(){
	alert("Você irá excluir!");
}

function cadastrar(){
	var responsa = document.getElementById('responsavel');
	var cod_car = document.getElementById('codigo_carro');
	var nome = document.getElementById('nome_cliente');
	var data = document.getElementById('datepicker');

	if (responsa.value==""||cod_car.value==""||nome.value==""||data.value=="") {
		alert("Você deve preencher todos os campos!")
	} else {
		if(confirm("Deseja cadastrar outra OS?")==true){
			location.replace('cadastra_os.html');
		}
	}
	
}

function salvadado(){
	var endereco = document.getElementById('endereco');
	var cep = document.getElementById('cep');
	var cidade = document.getElementById('cidade');
	var telefone = document.getElementById('telefone');
	var email = document.getElementById('email');
	var domain = document.getElementById('domain');

	if (endereco.value==""||cep.value==""||cidade.value==""||telefone.value==""||e-mail.value==""||domain.value=="") {
		alert("Você deve preencher todos os campos!")
	} else {
		location.replace('lista_os.html');
	}
	
}




function salvarentrega(){
	var responsaEntrega = document.getElementById('responsavel');
	var hora_entrega = document.getElementById('hora_entrega');
	var tanq = document.getElementById('tanque');
	var data = document.getElementById('datepicker');
	var km1 = document.getElementById('km');

	if (responsaEntrega.value==""||hora_entrega.value==""||tanq.value==""||data.value==""||km1.value=="") {
		alert("Você deve preencher todos os campos!")
	} else {
		if(confirm("Deseja salvar a entrega?")==true){
			location.replace('lista_os.html');
		} 
	}
	
}

function salvardevolucao(){
	var responsa = document.getElementById('responsavel');
	var hora_devolucao = document.getElementById('horadevolucao');
	var tanq = document.getElementById('tanquedevolucao');
	var data = document.getElementById('datepicker');
	var km1 = document.getElementById('kmdevolucao');

	if (responsa.value==""||hora_devolucao.value==""||tanq.value==""||data.value==""||km1.value=="") {
		alert("Você deve preencher todos os campos!")
	} else {
		if(confirm("Deseja salvar a devolucão?")==true){
			location.replace('lista_os.html');
		} 
	}
	
}

function ciclo_vida_os(){
	
	
			location.replace('status_entrega.html');
	
	
}


function editar(){
	var responsa = document.getElementById('edit_responsavel');
	var cod_car = document.getElementById('edit_codigo_carro');
	var nome = document.getElementById('edit_nome_cliente');

	if (responsa.value==""||cod_car.value==""||nome.value=="") {
		alert("Você deve preencher todos os campos!")
	} else {
		if(confirm("Você tem certeza que deseja salvar?")==true){
			location.replace('lista_os.html');
		} 
	}
	
}

$(document).ready(function() {
    $( '#datepicker' ).datepicker();
  });

$(document).ready(function(){
	$('#formulario').submit(function(){

		var $this = $(this);
		var tr = '<tr>'+
		'<td>'+$this.find("input[name='nome']").val()+'</td>'+
		'<td>'+$this.find("input[name='codigo-carro']").val()+'</td>'+
		'<td>'+$this.find("input[name='responsavel']").val()+'</td>'+
		'<td>Entrega</td>'+
		'<a href="edita_os.html"><img src="images/pencil.png" alt="Editar" id="editar" title="Editar">'+
		'</a>&#160;&nbsp;&nbsp;<a href=""><img src="images/delete.png" onclick="alerta_excluir();"'+
		' alt="Excluir" id="excluir" title="Excluir"></a></td>'+
		'</tr>'

		$('#lista_os').find('tbody').append(tr);

	});

});

