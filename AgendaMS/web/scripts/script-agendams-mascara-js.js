/*
Agenda MS - 2018
Desenvolvido por: Marcos Willian de Souza
*/

function mascaraTelefone(){
	var telefone = document.getElementById('telefone').value;
	telefone = telefone.toString();
	telefone = telefone.replace(/[^0-9]/g, '');
	var mascara = "(" + telefone.substring(0,2) + ")";
	mascara += telefone.substring(2,6) + "-";
	mascara += telefone.substring(6,10);
	if(mascara.replace(/[^0-9]/g, '') !== ""){
		document.getElementById('telefone').value = mascara;
	}
	else{
		document.getElementById('telefone').value = "";
	}
}
function mascaraCelular(){
	var celular = document.getElementById('celular').value;
	celular = celular.toString();
	celular = celular.replace(/[^0-9]/g, '');
	var mascara = "(" + celular.substring(0,2) + ")";
	mascara += celular.substring(2,7) + "-";
	mascara += celular.substring(7,11);
	document.getElementById('celular').value = mascara;
	if(mascara.replace(/[^0-9]/g, '') !== ""){
		document.getElementById('celular').value = mascara;
	}
	else{
		document.getElementById('celular').value = "";
	}
}
function mascaraCpf(){
	var cpf = document.getElementById('cpf').value;
	cpf = cpf.toString();
	cpf = cpf.replace(/[^0-9]/g, '');
	var mascara = cpf.substring(0,3) + ".";
	mascara += cpf.substring(3,6) + ".";
	mascara += cpf.substring(6,9)+ "-";
	mascara += cpf.substring(9,11);
	document.getElementById('cpf').value = mascara;
	if(mascara.replace(/[^0-9]/g, '') !== ""){
		document.getElementById('cpf').value = mascara;
	}
	else{
		document.getElementById('cpf').value = "";
	}
}