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
				document.getElementById("results").appendChild(createRow(res.data));
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
			JSON.parse(res.data).forEach(function(item) {
				document.getElementById("results").appendChild(createRow(item));
				createRowListener();
			});
		} else {
			document.getElementById("xhr-message").innerHTML = "Errore nell'ottenere gli User";
		}
	};
	req.open("GET", "http://localhost:8000/" + "user");
	req.send();
}();

function createRow(item) {
	//creo una riga
	let row = document.createElement("div");
	row.className = "row";
	//creo una colonna
	let col = document.createElement("div");
	col.className = "col-label";
	col.innerHTML = item.id;
	//aggiungo la colonna alla riga
	row.appendChild(col);
	//creo una colonna	
	col = document.createElement("div");
	col.className = "col";
	col.innerHTML = item.name;
	//aggiungo la colonna alla riga	
	row.appendChild(col);
	//creo una colonna	
	col = document.createElement("div");
	col.className = "col";
	col.innerHTML = item.surname;
	//aggiungo la colonna alla riga	
	row.appendChild(col);
	//creo una colonna	
	col = document.createElement("div");
	col.className = "col";
	col.innerHTML = item.email;
	//aggiungo la colonna alla riga	
	row.appendChild(col);
	//creo una colonna	
	col = document.createElement("div");
	col.className = "col";
	col.innerHTML = item.password;
	//aggiungo la colonna alla riga	
	row.appendChild(col);
	//creo una colonna	
	col = document.createElement("div");
	col.className = "col";
	col.innerHTML = item.registration;
	//aggiungo la colonna alla riga	
	row.appendChild(col);
	//creo una colonna		
	col = document.createElement("div");
	col.className = "col-btn";
	//creo un tag A	Modifica	
	let updBtn = document.createElement("a");
	updBtn.setAttribute("data-id", item.id);
	updBtn.className = "update-row";
	updBtn.innerHTML="Modifica";
	updBtn.setAttribute('href', "#");
	//aggiungo il pulsante alla colonna	
	col.appendChild(updBtn);	
	//creo un tag A	Cancella	
	let delBtn = document.createElement("a");
	delBtn.setAttribute("data-id", item.id);
	delBtn.className = "delete-row";
	delBtn.innerHTML="Cancella";
	delBtn.setAttribute('href', "#");
	//aggiungo il pulsante alla colonna	
	col.appendChild(delBtn);
	//aggiungo la colonna alla riga	
	row.appendChild(col);
	return row;
}

function createRowListener() {
	document.querySelector('.update-row').addEventListener('click', function(event) {
		let formUser = document.getElementById("user-form").elements;
		formUser["id"].value = this.getAttribute("data-id");
	});
}