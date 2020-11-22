document.addEventListener("DOMContentLoaded", function() {

	document.querySelector('#submit-chapter').addEventListener('click', function(event) {
		submitChapter(event);
	});


});

function createChapter() {
	let formChapter = document.getElementById("chapter-form").elements;
	const chapter = {};
	chapter.id = parseInt(formChapter["id"].value);
	chapter.title = formChapter["title"].value;
	chapter.date = formChapter["date"].value;

	chapter.isValid = function() {
		if (chapter.title == '' || chapter.date == '') {
			return false;
		}
		return true;
	};
	chapter.save = function() {


		var req = new XMLHttpRequest();
		req.onload = function() {
			res = JSON.parse(this.responseText);
			if (res.status === "ok") {
			//il backend ha risposto positivamente quindi procedo ad aggiornare la pagina (DOM) 
			//vado a cercare una riga che abbia data-id con valore uguale al valore del campo "id" dell'oggetto 
			//restituito dal backend
				let foundRow = document.querySelector("[data-id='" + res.data.id + "']"); //utilizzo query selector: mi rende il primo elemento trovato
				if (foundRow) { //se trovo un elemento con data-id
					foundRow.innerHTML = "";//pulisco la riga che ho trovato e poi vado a inserire il contenuto
					createRowElements(res.data, foundRow);
					document.getElementById("results").appendChild(createRow(res.data));
			    }
			} else {
				document.getElementById("xhr-message").innerHTML = "Salvataggio fallito";
			}
		};
		req.open("POST", "http://localhost:8000/" + "chapter");
		
		
		req.send(JSON.stringify(chapter));
		
	};

	return chapter;
}

function submitChapter(event) {
	// Impedisco il submit del form
	event.preventDefault();
	// Richiamo il metodo validate il quale valida i campi
	// (controlla che siano presenti quelli obbligatori e il loro tipo sia quello atteso)
	let chapter = createChapter();
	if (!chapter.isValid()) {
		alert("I campi titolo e data devono essere presenti")
		return;
	}

	// Effettuo il save
	chapter.save();

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
			document.getElementById("xhr-message").innerHTML = "Errore nel ottenere i Chapters";
		}
	};
	req.open("GET", "http://localhost:8000/" + "chapter");
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
	row.setAttribute("data-id", item.id); //setto l'attrituto data-id
	return createRowElements(item, row); 
}
/**
 * Utilizzo questo metodo per creare gli elementi della riga
 * @param item: oggetto con i dati
 * @param row: elemento HTML che è la riga
 */
function createRowElements(item, row) {
	row.appendChild(createRowDataCell("id", item.id)); //aggiungo la colonna alla riga
	row.appendChild(createRowDataCell("title", item.title)); //aggiungo la colonna alla riga
	row.appendChild(createRowDataCell("date", item.date)); //aggiungo la colonna alla riga
	//creo una colonne BOTTONI
	col = document.createElement("div");
	col.className = "col-btn";
	//creo un tag A	Modifica	
	let updBtn = document.createElement("a");
	updBtn.className = "update-row";
	updBtn.setAttribute("data-id", item.id);
	updBtn.innerHTML="Seleziona";
	updBtn.setAttribute('href', "#");
	updBtn.addEventListener("click", function () {
		let targetRow = document.querySelector("[data-id='" + this.getAttribute("data-id") + "']");
		let title =  targetRow.querySelector("[data-title]");
		let date =  targetRow.querySelector("[data-date]");
		formChapter = document.getElementById("chapter-form").elements;
		formChapter["id"].value = this.getAttribute("data-id");
		formChapter["title"].value = title.innerHTML;
		formChapter["date"].value = date.innerHTML;
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
 * crea una data cell, cioè una cella contente i dati
 * @param item: oggetto con i dati
 * @param name: nome colonna
 * @param value: valore
 */
function createRowDataCell(name, value) {
	col = document.createElement("div");
	col.className = "col";
	col.setAttribute("data-" + title, + date, value);
	col.innerHTML = value; //setta il contenuto visibile della cella
	return col;
}


