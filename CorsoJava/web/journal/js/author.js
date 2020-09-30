document.addEventListener("DOMContentLoaded", function() {
	
	document.querySelector('#submit-author').addEventListener('click', function(event) {
		submitAuthor(event);	
	});
	
});
/**
 * Effettua il submit del form
 */
function submitAuthor(event) {
	//impedisco il submit del form
	event.preventDefault();
	//creo un oggetto che rappresenta il form e ottendo i campi del form
	//sotto forma di array
	let formAuthor = document.getElementById("author-form").elements;
	//ottengo i campi usando il valore dell'attributo NAME del tag INPUT come indice dell'array
	let name = formAuthor["name"];
	let email = formAuthor["email"];
	//richiamo il metodo validate il quale valida i campi (controlla che siano presenti quelli obbligatori e il loro tipo sia quello atteso)
	if (!validate(formAuthor)) {
		return;
	}
	//proseguo
    console.log(name.value);
    console.log(email.value);

}
/**
* Valida il form
* Controlla che siano presenti quelli obbligatori e il loro tipo sia quello atteso 
*/
function validate(formAuthor) {
	let name = formAuthor["name"];
	let email = formAuthor["email"];
	//verifica che i campi abbamo un valore
	if (name.value == '' || email.value == '') {
		alert("I campi nome e email devono essere presenti");
		return false;		
	}
	return true;
		
}