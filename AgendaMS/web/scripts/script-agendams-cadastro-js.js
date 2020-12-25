/*
Agenda MS - 2018
Desenvolvido por: Marcos Willian de Souza
*/
function validaFormulario(){
	
	var nome = document.getElementById('nome').value;
	var login = document.getElementById('login').value;
	var senha = document.getElementById('senha').value;
	var confsenha = document.getElementById('confsenha').value;
	
	if(nome === ""){
		alert("Nome de usuário é Obrigatório!");
		return false;
	}
	
	if(login === ""){
		alert("Login de usuário é Obrigatório!");
		return false;
	}
	
	if(senha === ""){
		alert("Senha de usuário é Obrigatório!");
		return false;
	}
	
	if(confsenha === ""){
		alert("Confirme sua Senha!");
		return false;
	}
	
	if(confsenha !== senha){
		alert("Senha não Confere!");
		return false;
	}
	
	return true;
}