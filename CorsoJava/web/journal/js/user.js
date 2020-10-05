document.addEventListener("DOMContentLoaded", function() {

	document.querySelector('#submit-user').addEventListener('click', function(event) {
		submitUser(event);
	});

});

function createUser() {
	let formUser = document.getElementById("user-form").elements;
	const user = {};
	user.name = formUser["name"].value;
	user.surname = formUser["surname"].value;
	user.email = formUser["email"].value;
	user.password = formUser["password"].value;
	user.registration = formUser["registration"].value;
	user.isValid = function() {
		if (user.name == ' ' || user.surname == ' ' || user.email == ' ' || user.password == ' ' || user.registration == ' ') {
			return false;
		}
		return true;
	};

	return user;
}

/**
* Effettual il submit del form
 */
function submitUser(event) {
	// Impedisco il submit del form
	event.preventDefault();
	// Richiamo il metodo validate il quale valida i campi (controlla che siano presenti quelli obbligatori e il loro tipo sia quello atteso)
	let user = createUser();
	if (!user.isValid) {
		alert("I campi nome, cognome, email, password e data di registrazione devono essere presenti")
		return;
	}
	// Proseguo
	console.log(user.name);
	console.log(user.surname);
	console.log(user.email);
	console.log(user.password);
	console.log(user.registration);

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

