/*
 * script-agendams-common-js.js 
 * autor: marcos Willian de Souza
 * Data: 20/07/2019
 */

function ajustaContainer(){
	
	//var screenWidth = screen.width;
	var screenHeight = screen.height;
	
	if((screenHeight <= 780)){
		//document.getElementById('container').style.marginLeft = '-420px';
		document.getElementById('container').style.marginTop = '-290px';
	}
	else{
		//document.getElementById('container').style.marginLeft = '-420px';
		document.getElementById('container').style.marginTop = '-370px';
	}

}
function redimencionaContainer(){
	
	//var windowWidth = window.innerWidth;
    var windowHeight = window.innerHeight;
	
	if((windowHeight <= 780)){
		//document.getElementById('container').style.marginLeft = '-420px';
		document.getElementById('container').style.marginTop = '-290px';
	}
	else{
		//document.getElementById('container').style.marginLeft = '-420px';
		document.getElementById('container').style.marginTop = '-370px';
	}
	
}

