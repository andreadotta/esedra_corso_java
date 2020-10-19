/**
 * 
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
		req.open("GET", "https://postman-echo.com/get?foo1=bar1&foo2=bar2/ajax/ ");
		req.send();	
		console.log("Ho fatto la chiamata " + Date.now());	
			
			
	}
	
});
	