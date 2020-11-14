document.addEventListener("DOMContentLoaded", function() {

	document.querySelector('#submit-user').addEventListener('click', function(event) {
		submitUser(event);
	});

});

function createUser() {
	let formUser = document.getElementById("user-form").elements;
	const user = {};
	user.id = parseInt(formUser["id"].value);
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

		var req = new XMLHttpRequest();
		req.onload = function() {
			res = JSON.parse(this.responseText);
			if (res.status === "ok") {
				document.getElementById("xhr-message").innerHTML = "Salvataggio riuscito";
				formUser["id"].value = res.data.id;
			} else {
				document.getElementById("xhr-message").innerHTML = "Salvataggio fallito";
			}
		};
		req.open("POST", "http://localhost:8000/" + "user");

		req.send(JSON.stringify(user));

	}

	return user;
};

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

var getall = function getAll() {
	var req = new XMLHttpRequest();
	req.onload = function() {
		res = JSON.parse(this.responseText);
		if (res.status === "ok") {
			console.log(res.data);
		} else {
			document.getElementById("xhr-message").innerHTML = "Errore nel ottenere i Journals";
		}
	};
	req.open("GET", "http://localhost:8000/" + "user");
	req.send();
}();