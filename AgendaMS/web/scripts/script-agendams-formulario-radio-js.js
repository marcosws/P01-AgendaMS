/*
Agenda MS - 2018
Desenvolvido por: Marcos Willian de Souza
*/

function operacao(){
	
	var opnome = document.getElementById('opnome').checked;
	var opsenha = document.getElementById('opsenha').checked;
	var opexcluir = document.getElementById('opexcluir').checked;
	
	if(opnome){
		document.getElementById('form1').style.display = 'inline';
		document.getElementById('form2').style.display = 'none';
		document.getElementById('form3').style.display = 'none';
	}
	else if(opsenha){
		document.getElementById('form1').style.display = 'none';
		document.getElementById('form2').style.display = 'inline';
		document.getElementById('form3').style.display = 'none';
	}
	else if(opexcluir){
		document.getElementById('form1').style.display = 'none';
		document.getElementById('form2').style.display = 'none';
		document.getElementById('form3').style.display = 'inline';
	}
}