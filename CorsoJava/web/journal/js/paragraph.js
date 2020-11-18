document.addEventListener("DOMContentLoaded", function() {

	document.querySelector('#submit-paragraph').addEventListener('click',
			function(event) {
				submitParagraph(event);
			});

});
function createParagraph() {
	let formParagraph = document.getElementById("paragraph-form").elements;
	const paragraph = {};
	paragraph.id = parseInt(formParagraph["id"].value);
	paragraph.text = formParagraph["text"].value;

	paragraph.isValid = function() {
		if (paragraph.text == '') {
			return false;
		}
		return true;
	}
	paragraph.save = function() {

		var req = new XMLHttpRequest();
		req.onload = function() {
			res = JSON.parse(this.responseText);
			if (res.status === "ok") { // il backend ha risposto positivamente
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
				let foundRow = document.querySelector("[data-id='"
						+ res.data.id + "']"); // utilizzo query selector: mi
												// rende il primo elemento
												// trovato
				if (foundRow) { // se trovo un elemento con data-id
					foundRow.innerHTML = "";// pulisco la riga che ho trovato e
											// poi vado a inserire il contenuto
					createRowElements(res.data, foundRow);
				} else { // non ho trovato nessun data-id corrispondente
							// quindi si tratta di un nuvo record.
					document.getElementById("results").appendChild(
							createRow(res.data)); // creo una nuova riga e la
													// appendo al result set
				}

			} else {
				document.getElementById("xhr-message").innerHTML = "Salvataggio fallito";
			}

		};
		req.open("POST", "http://localhost:8000/" + "paragraph");
		req.send(JSON.stringify(paragraph));
	};

	return paragraph;
};

function submitParagraph(event) {
	event.preventDefault();

	let paragraph = createParagraph();

	if (!paragraph.isValid()) {
		alert("il campo text deve essere present");
		return;
	}

	// proseguo
	paragraph.save();

}

var getall = function getAll() {
	var req = new XMLHttpRequest();
	req.onload = function() {
		res = JSON.parse(this.responseText);
		if (res.status === "ok") {
			JSON.parse(res.data).forEach(
					function(item) {
						document.getElementById("results").appendChild(
								createRow(item));
						createRowListener();
					});
		} else {
			document.getElementById("xhr-message").innerHTML = "Errore nel ottenere i Paragraphs";
		}
	};
	req.open("GET", "http://localhost:8000/" + "paragraph");
	req.send();
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
/**
 * Utilizzo questo metodo per creare gli elementi della riga
 * 
 * @param item:
 *            oggetto con i dati
 * @param row:
 *            elemento HTML che è la riga
 */

function createRowElements(item, row) {
	row.appendChild(createRowDataCell(item, "id", item.id)); // aggiungo la
																// colonna alla
																// riga
	row.appendChild(createRowDataCell("text", item.text)); // aggiungo la
															// colonna alla riga
	// creo una colonne BOTTONI
	col = document.createElement("div");
	col.className = "col-btn";
	// creo un tag A Modifica
	let updBtn = document.createElement("a");
	updBtn.className = "update-row";
	updBtn.setAttribute("data-id", item.id);
	updBtn.innerHTML = "Seleziona";
	updBtn.setAttribute('href', "#");
	updBtn.addEventListener("click", function() {
		let targetRow = document.querySelector("[data-id='"
				+ this.getAttribute("data-id") + "']");
		let text = targetRow.querySelector("[data-text]");
		formParagraph = document.getElementById("paragraph-form").elements;
		formParagraph["id"].value = this.getAttribute("data-id");
		formParagraph["text"].value = text.innerHTML;
	});
	// aggiungo il pulsante alla colonna
	col.appendChild(updBtn);
	// creo un tag A Cancella
	let delBtn = document.createElement("a");
	delBtn.setAttribute("data-id", item.id);
	delBtn.className = "delete-row";
	delBtn.innerHTML = "Cancella";
	delBtn.setAttribute('href', "#");
	// aggiungo il pulsante alla colonna
	col.appendChild(delBtn);
	// aggiungo la colonna alla riga
	row.appendChild(col);
	return row;
}
/**
 * crea una data cell, cioè una cella contente i dati
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
