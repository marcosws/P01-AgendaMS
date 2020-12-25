/*
Agenda MS - 2018
Desenvolvido por: Marcos Willian de Souza
*/
function validaFormulario(){
	
	var msg = "Pendências: ";
	var valida = true;
	
	var nome = document.getElementById('nome').value;
	var cpf = document.getElementById('cpf').value;
	var telefone = document.getElementById('telefone').value;
	var celular = document.getElementById('celular').value;
	var email = document.getElementById('email').value;
 /* var site = document.getElementById('site').value; */
	
	if(nome === ""){
		msg += "\nO Nome é obrigatório!";
		valida = false;
	}
	
	if(cpf === ""){
		msg += "\nCPF é obrigatório!";
		valida = false;
	}
	else if(!validaCpf(cpf)){
		msg += "\nCPF Inválido!";
		valida = false;
	}
	
	if(telefone !== ""){
		if(!validaTelefone(telefone)){
			msg += "\nFormato do Telefone Inválido!";
			valida = false;
		}
	}
	
	if(celular !== ""){
		if(!validaCelular(celular)){
			msg += "\nFormato do Celular Inválido!";
			valida = false;
		}
	}
	
	if(email === ""){
		msg += "\nE-Mail é obrigatório!";
		valida = false;
	}
	else if(!validaEmail(email)){
		msg += "\nFormato de E-Mail Inválido!";
		valida = false;
	}
	
	if(!valida)
		alert(msg);
	
	return valida
}









