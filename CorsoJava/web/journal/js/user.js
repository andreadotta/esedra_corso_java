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
			if (res.status === "ok") { //il backend ha risposto positivamente; quindi procedo ad aggiornare la pagina (DOM)
				document.getElementById("xhr-message").innerHTML = "Salvataggio riuscito"; //imposto un messaggio di successo
				//vado a cercare una riga che abbia data-id con valore uguale al valore del campo "id" dell'oggetto 
				//restituito dal backend
				let foundRow = document.querySelector("[data-id='" + res.data.id + "']"); //utilizzo query selector: mi rende il primo elemento trovato
				if (foundRow) { //se trovo un elemento con data-id
					foundRow.innerHTML = ""; //pulisco la riga che ho trovato...
					createRowElements(res.data, foundRow); //...e poi vado a inserire il contenuto
				} else { //non ho trovato nessun data-id corrispondente; quindi si tratta di un nuvo record
					document.getElementById("results").appendChild(createRow(res.data)); //creo una nuova riga e la appendo al result set
				}
			} else {
				document.getElementById("xhr-message").innerHTML = "Salvataggio fallito";
			}
		};
		req.open("POST", "http://localhost:8080/" + "users");

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
			});
		} else {
			document.getElementById("xhr-message").innerHTML = "Errore nell'ottenere gli User";
		}
	};
	req.open("GET", "http://localhost:8080/" + "users");
	req.send();
}();
/**
 * Utilizzo questo metodo per creare una nuova riga
 * @param item: oggetto con i dati
 */
function createRow(item) {
	//creo una riga
	let row = document.createElement("div");
	row.className = "row"; //setto la classe
	row.setAttribute("data-id", item.id); //setto l'attributo "data-id"
	return createRowElements(item, row);
}
/**
 * Utilizzo questo metodo per creare gli elementi della riga
 * @param item: oggetto con i dati
 * @param row: elemento HTML che � la riga
 */
function createRowElements(item, row) {
	row.appendChild(createRowDataCell("id", item.id)); //aggiungo la colonna alla riga
	row.appendChild(createRowDataCell("name", item.name)); //aggiungo la colonna alla riga
	row.appendChild(createRowDataCell("surname", item.surname)); //aggiungo la colonna alla riga
	row.appendChild(createRowDataCell("email", item.email)); //aggiungo la colonna alla riga
	row.appendChild(createRowDataCell("password", item.password)); //aggiungo la colonna alla riga
	row.appendChild(createRowDataCell("registration", item.registration)); //aggiungo la colonna alla riga
	//creo una colonna BOTTONI
	col = document.createElement("div");
	col.className = "col-btn";
	//creo un tag A Modifica	
	let updBtn = document.createElement("a");
	updBtn.className = "update-row";
	updBtn.setAttribute("data-id", item.id);
	updBtn.innerHTML="Seleziona";
	updBtn.setAttribute('href', "#");
	updBtn.addEventListener("click", function () {
		let targetRow = document.querySelector("[data-id='" + this.getAttribute("data-id") + "']");
		let name = targetRow.querySelector("[data-name]");
		let surname = targetRow.querySelector("[data-surname]");
		let email = targetRow.querySelector("[data-email]");
		let password = targetRow.querySelector("[data-password]");
		let registration = targetRow.querySelector("[data-registration]");
		formUser = document.getElementById("user-form").elements;
		formUser["id"].value = this.getAttribute("data-id");
		formUser["name"].value = name.innerHTML;
		formUser["surname"].value = surname.innerHTML;
		formUser["email"].value = email.innerHTML;
		formUser["password"].value = password.innerHTML;
		formUser["registration"].value = registration.innerHTML;
	});
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
/**
 * creo una "data cell", cio� una cella contenente i dati
 * @param name: nome colonna
 * @param value: valore
 */
function createRowDataCell(name, value) {
	col = document.createElement("div");
	col.className = "col";
	col.setAttribute("data-" + name, value); //setto l'attributo data-name
	col.innerHTML = value; //setto il contenuto visibile della cella
	return col;
}
	