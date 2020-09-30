document.addEventListener("DOMContentLoaded", function() {

	document.querySelector('#submit-user').addEventListener('click', function(event) {
		submitUser(event);
	});

});

function submitUser(event) {
	// Impedisco il submit del form
	event.preventDefault();
	// Creo un oggetto che rappresenta il form e ottengo i campi del form
	// sottoforma di array
	let formUser = document.getElementById("user-form").elements;
	// Ottengo i campi usando il valore dell'attributo NAME del tag INPUT come indice dell'array'
	let name = formUser["name"];
	let surname = formUser["surname"];
	let email = formUser["email"];
	let password = formUser["password"];
	let registration = formUser["registration"];
	// Richiamo il metodo validate il quale valida i campi (controlla che siano presenti quelli obbligatori e il loro tipo sia quello atteso)
	if (!validate(formUser)) {
		return;
	}

	// Proseguo
	console.log(name.value);
	console.log(surname.value);
	console.log(email.value);
	console.log(password.value);
	console.log(registration.value);

}
/**
* Valida il form
* Controlla che siano presenti quelli obbligatori e il loro tipo sia quello atteso
 */
function validate(formUser) {
	let name = formUser["name"];
	let surname = formUser["surname"];
	let email = formUser["email"];
	let password = formUser["password"];
	let registration = formUser["registration"];
	// Verifica che i campi abbiano un valore
	if (name.value == ' ' || surname.value == ' ' || email.value == ' ' || password.value == ' ' || registration.value == ' ') {
		alert("I campi nome, cognome, email, password e registrazione devono essere presenti");
		return false;
	}
	return true;

}

