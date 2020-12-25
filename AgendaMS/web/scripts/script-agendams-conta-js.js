/*
Agenda MS - 2018
Desenvolvido por: Marcos Willian de Souza
*/

function validaFormulario(){
	
	var opnome = document.getElementById('opnome').checked;
	var opsenha = document.getElementById('opsenha').checked;
	var opexcluir = document.getElementById('opexcluir').checked;
	
	if(opnome){
		
		var nome = document.getElementById('nome').value;
		if(nome === ""){
			alert("Nome deve ser preenchido!");
			return false;
		}
		
	}
	else if(opsenha){
		
		var atualsenha = document.getElementById('atualsenha').value;
		var novasenha = document.getElementById('novasenha').value;
		var confsenha = document.getElementById('confsenha').value;
		
		if(atualsenha === ""){
			alert("A Senha atual deve ser informada!");
			return false;
		}
		
		if(novasenha === ""){
			alert("A Nova Senha deve ser informada!");
			return false;
		}
		
		if(atualsenha === novasenha){
			alert("A Nova Senha deve ser diferente da senha Atual!");
			return false;
		}
		
		if(confsenha === ""){
			alert("Confirme a nova Senha!");
			return false;
		}
		
		if(novasenha !== confsenha){
			alert("A Senha não confere!");
			return false;
		}
		
	}
	else if(opexcluir){
		
		var confirma = confirm("Deseja Excluir a sua Conta?\nSeus Contatos Tambem serão Apagados!\nEsta Operação não pode ser Desfeita.");
		return confirma;
		
	}
	return true;
}