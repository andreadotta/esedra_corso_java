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
	/* Valida il form
	* Controlla che siano presenti quelli obbligatori e il loro tipo sia quello atteso */
	user.isValid = function() {
		if (user.name == '' || user.surname == '' || user.email == '' || user.password == '' || user.registration == '') {
			return false;
		}
		return true;
	};
	user.save = function() {
		
		let formData = new FormData();
		
		formData.append("name", user.name);
		formData.append("surname", user.surname);
		formData.append("email", user.email);
		formData.append("password", user.password);
		formData.append("registration", user.registration);
		
		var req = new XMLHttpRequest();
		req.onload = function() {
			console.log(this.responseText);
		};
		req.open("POST", "http://localhost:8000/" + "user");
		/*req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
		req.setRequestHeader('Access-Control-Allow-Headers', '*');
		req.setRequestHeader('Access-Control-Allow-Origin', '*');*/
		//req.withCredentials = true;

		req.send(formData);
		
	};

	return user;
}

/**
* Effettua il submit del form
 */
function submitUser(event) {
	// Impedisco il submit del form
	event.preventDefault();
	// Richiamo il metodo validate il quale valida i campi
	// (controlla che siano presenti quelli obbligatori e il loro tipo sia quello atteso)
	let user = createUser();
	if (!user.isValid()) {
		alert("I campi nome, cognome, email, password e data di registrazione devono essere presenti")
		return;
	}
	
	// Effettuo save
	user.save();

}