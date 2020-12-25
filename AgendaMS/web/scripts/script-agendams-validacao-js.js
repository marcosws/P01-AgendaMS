/*
Agenda MS - 2018
Desenvolvido por: Marcos Willian de Souza
*/

function validaCelular(celular){
	var res = celular.match(/[\(][0-9]{2}[\)][9][0-9]{4}[\-][0-9]{4}$/g);
	if(res === null)
		return false;
	else
		return true;
}
function validaTelefone(telefone){
	var res = telefone.match(/[\(][0-9]{2}[\)][0-9]{4}[\-][0-9]{4}$/g);
	if(res === null)
		return false;
	else
		return true;
}
function validaEmail(email){
	var res = email.match(/^([\w\-]+\.)*[\w\- ]+@([\w\- ]+\.)+([\w\-]{2,3})$/g);
	if(res === null)
		return false;
	else
		return true;
}
function validaCpf(cpf){
	
	cpf = cpf.toString();
	cpf = cpf.replace(/[^0-9]/g, '');
	
	if(cpf.length != 11)
		return false;
	
	var rep = 0;
	for(var r = 0; r < 10; r++){
		if(cpf.substr(r,1) === cpf.substr(10,1))
			rep += 1;
		if(rep === 10)
			return false;
	}
	
	var soma = 0;
	var valida = false;
	var peso_mult1 = [10,9,8,7,6,5,4,3,2];
	var peso_mult2 = [11,10,9,8,7,6,5,4,3,2];
	
	for(var i = 0; i < 9; i++)
		soma += peso_mult1[i] * parseInt(cpf.substr(i,1));
	
	var resto = soma % 11;
	if(resto < 2)
		resto = 0;
	else
		resto = 11 - resto;
	
	var digito = resto.toString();
	var parc_cpf = cpf.substr(0,9) + digito;
	soma = 0;
	
	for(var j = 0; j < 10; j++)
		soma += peso_mult2[j] * parseInt(parc_cpf.substr(j,1));
	
	resto = soma % 11;
	if(resto < 2)
		resto = 0;
	else
		resto = 11 - resto;
	
	digito += resto.toString();
	if(cpf.substr(9,2) === digito)
		valida = true;

	return valida;
}