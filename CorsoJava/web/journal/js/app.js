/**
	Guida Ajax
	https://www.html.it/guide/guida-ajax/
	
	Server locale : http://localhost:8000/author/
	
	L'Oggetto XMLHttpRequest
	
 */

document.addEventListener("DOMContentLoaded", function() {
	
	document.querySelector('#button-test-server').addEventListener('click', function(event) {
			testServer();
	});


	function testServer() {
		var req = new XMLHttpRequest();
		req.onload = function () { 
			console.log("Ho ottenuto il risultato " + Date.now());		
			document.getElementById("test-server").innerHTML = this.responseText; 
		};
		req.open("GET", "http://localhost:8000/author/");
		req.send();	
		console.log("Ho fatto la chiamata " + Date.now());	
			
	}
	
});
	
	


