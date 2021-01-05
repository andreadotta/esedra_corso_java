/**
 * On choisit un chiffre RANDOM
 * DEMANDE a l'utilisteur de rentrer un chiffre
 * TANT QUE le chiffre n'est pas bon
 * si le chiffre est au dessus
 * Alert au desus
 * Si NON
 * Alert en dessous
 * 
 * Demander encore a l'itulisateur de rentrer un chiffre
 * 
 * FIN TANT QUE
 * alert success
 * 
 */ 

(function(){ 
	
	var Adeviner = Math.round(Math.RANDOM()*10)
 var Essai = windows.prompt("entrer un chiffre")
 Essai = parseInt(Essai,10)
 while(Essai != Adeviner){
 if(Essai > Adeviner){
	 
	 alert("tu es au dessus")

		 } else{
	 alert("tu es en dessous")
 }
  Essai = windows.prompt("retenter votre chance") 
}
alert("Bravo")

})()