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
			if (res.status === "ok") {
				document.getElementById("xhr-message").innerHTML = "Salvataggio riuscito";
				formAuthor["id"].value = res.data.id;
				document.getElementById("results").appendChild(
						createRow(res.data));
			} else {
				document.getElementById("xhr-message").innerHTML = "Salvataggio fallito";
			}

		};

		req.open("POST", "http://localhost:8000/" + "author");

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
			document.getElementById("xhr-message").innerHTML = "Errore nel ottenere i Authors";
		}
	};
	req.open("GET", "http://localhost:8000/" + "author");
	req.send();
}();

function createRow(item) {
	// creo una riga
	let row = document.createElement("div");
	row.className = "row";
	// creo una colonna
	let col = document.createElement("div");
	col.className = "col-label";
	col.innerHTML = item.id;
	// aggiungo la colonna alla riga
	row.appendChild(col);
	// creo una colonna
	col = document.createElement("div");
	col.className = "col";
	col.innerHTML = item.name;
	// aggiungo la colonna alla riga
	row.appendChild(col);
	//creo una colonna
	col = document.createElement("div");
	col.className = "col";
	col.innerHTML = item.email;
	// aggiungo la colonna alla riga
	row.appendChild(col);
	// creo una colonna
	col = document.createElement("div");
	col.className = "col-btn";
	// creo un tag A Modifica
	let updBtn = document.createElement("a");
	updBtn.setAttribute("data-id", item.id);
	updBtn.className = "update-row";
	updBtn.innerHTML = "Modifica";
	updBtn.setAttribute('href', "#");
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
/*
 * function createRowListener() {
 * document.querySelector('.update-row').addEventListener('click',
 * function(event) { let formJournal =
 * document.getElementById("journal-form").elements; formJournal["id"].value =
 * this.getAttribute("data-id"); }); }
 */

