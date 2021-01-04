document.addEventListener("DOMContentLoaded", function() {
	document.querySelector('#submit-author').addEventListener('click',
			function(event) {
				submitAuthor(event);
			});

});

function createAuthor() {
	let formAuthor = document.getElementById("author-form").elements;
	const author = {};
	author.id = parseInt(formAuthor["id"].value);
	author.name = formAuthor["name"].value;
	author.email = formAuthor["email"].value;
	/*
	 * Valida il form Controlla che siano presenti quelli obbligatori e il loro
	 * tipo sia quello atteso
	 */
	author.isValid = function() {
		if (author.name == '' || author.email == '') {
			return false;
		}
		return true;
	};
	author.save = function() {

		var req = new XMLHttpRequest();
		req.onload = function() {
			res = JSON.parse(this.responseText);
			if (res.status === "ok") { // il backend ha risposto positivamente;
										// quindi procedo ad aggiornare la
										// pagina (DOM)
				document.getElementById("xhr-message").innerHTML = "Salvataggio riuscito"; // imposto
																							// un
																							// messaggio
																							// di
																							// successo
				// vado a cercare una riga che abbia data-id con valore uguale
				// al valore del campo "id" dell'oggetto
				// restituito dal backend
				let foundRow = document.querySelector("[data-id='" + res.data.id + "']"); // utilizzo
																							// query
																							// selector:
																							// mi
																							// rende
																							// il
																							// primo
																							// elemento
																							// trovato
				if (foundRow) { // se trovo un elemento con data-id
					foundRow.innerHTML = ""; // pulisco la riga che ho
												// trovato...
					createRowElements(res.data, foundRow); // ...e poi vado a
															// inserire il
															// contenuto
				
				} else { // non ho trovato nessun data-id corrispondente;
							// quindi si tratta di un nuovo record
					document.getElementById("results").appendChild(createRow(res.data)); // creo
																							// una
																							// nuova
																							// riga
																							// e la
																							// appendo
																							// al
																							// result
																							// set
				}	
			
			
			} else {
				document.getElementById("xhr-message").innerHTML = "Salvataggio fallito";
			}

		};

		req.open("POST", "http://localhost:8080/" + "authors");

		req.send(JSON.stringify(author));

	};

	return author;
}
/**
 * Effettua il submit del formData
 */
function submitAuthor(event) {
	// impedisco il submit del form
	event.preventDefault();
	// richiamo il metodo validate il quale valida i campi (controlla che siano
	// presenti quelli obbligatori e il loro tipo sia quello atteso)
	let author = createAuthor();
	if (!author.isValid()) {
		alert("I campi nome e email devono essere presenti");
		return;
	}

	author.save();

}

function printError(error) {
	document.getElementById("xhr-message").innerHTML = "Errore: " + error;
}

function Test(data) {
	return `<div><h2>${data}</h2></div>`;
}

var getall = function getAll() {
	const render = function(res) {
		try {
			//document.querySelector("test").innerHTML = Test(res);
			Test(res);
			res.forEach(
				function(item) {
					document.getElementById("results").appendChild(
						createRow(item));
			});
		} catch(error) {
			console.log(error);
		}
	}
	// JavaScript FETCH
	var requestOptions = {
			  method: 'GET',
			  mode: 'cors',
			  cache: 'no-cache',
			  credentials: 'omit',
			  headers: {
				  "Content-Type":"application/json",
			  },
			  redirect: 'follow'
			};
			
			fetch("http://localhost:8080/authors/", requestOptions)
			  .then(response => response.json())
			  .then(result => render(result))
			  .catch(error => console.log('error', error));
	}();

/**
 * Utilizzo questo metodo per creare una nuova riga
 * 
 * @param item:
 *            oggetto con i dati
 */
function createRow(item) {
	// creo una riga
	let row = document.createElement("div");
	row.className = "row"; // setto la classe
	row.setAttribute("data-id", item.id); // setto l'attrituto data-id
	return createRowElements(item, row); 
}

function createRowElements(item,row) {

	row.appendChild(createRowDataCell("id", item.id)); // aggiungo la colonna
														// alla riga
	row.appendChild(createRowDataCell("name", item.name));// aggiungo la
															// colonna alla riga
	row.appendChild(createRowDataCell("email", item.email));
	// creo una colonne BOTTONI
	col = document.createElement("div");
	col.className = "col-btn";
	// creo un tag A Modifica
	let updBtn = document.createElement("a");
	updBtn.className = "update-row";
	updBtn.setAttribute("data-id", item.id);
	updBtn.innerHTML="Seleziona";
	updBtn.setAttribute('href', "#");
	updBtn.addEventListener("click", function () {
		let targetRow = document.querySelector("[data-id='" + this.getAttribute("data-id") + "']");
		let name =  targetRow.querySelector("[data-name]");
		let email =  targetRow.querySelector("[data-email]");
		formAuthor = document.getElementById("author-form").elements;
		formAuthor["id"].value = this.getAttribute("data-id");
		formAuthor["name"].value = name.innerHTML;
		formAuthor["email"].value = email.innerHTML;
	});
	// aggiungo il pulsante alla colonna
	col.appendChild(updBtn);	
	// creo un tag A Cancella
	let delBtn = document.createElement("a");
	delBtn.setAttribute("data-id", item.id);
	delBtn.className = "delete-row";
	delBtn.innerHTML="Cancella";
	delBtn.setAttribute('href', "#");
	// aggiungo il pulsante alla colonna
	col.appendChild(delBtn);
	// aggiungo la colonna alla riga
	row.appendChild(col);
	return row;
}

/**
 * crea una data cell, cioé una cella contente i dati
 * 
 * @param item:
 *            oggetto con i dati
 * @param name:
 *            nome colonna
 * @param value:
 *            valore
 */
function createRowDataCell(name, value) {
	col = document.createElement("div");
	col.className = "col";
	col.setAttribute("data-" + name, value); // setta l'attributo data-name
	col.innerHTML = value; // setta il contenuto visibile della cella
	return col;
}
// x

