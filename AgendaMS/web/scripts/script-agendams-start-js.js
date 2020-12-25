/*
Agenda MS - 2018
Desenvolvido por: Marcos Willian de Souza
*/
function validaFormulario(){
	
	
	var login = document.getElementById('login').value;
	var senha = document.getElementById('senha').value;
	
	if(login === ""){
		alert("Digite o login de Usuário!");
		return false;
	}
	
	if(senha === ""){
		alert("Digite a senha de Usuário!");
		return false;
	}
	
	return true;
}