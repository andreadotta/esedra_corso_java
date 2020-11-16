document.addEventListener("DOMContentLoaded", function() {

	document.querySelector('#submit-journal').addEventListener('click', function(event) {
		submitJournal(event);
	});
	

});

function createJournal() {
	let formJournal = document.getElementById("journal-form").elements;
	const journal = {};
	journal.id = parseInt(formJournal["id"].value);
	journal.name = formJournal["name"].value;

	journal.isValid = function() {
		if (journal.name == '') {
			return false;
		}
		return true;
	};
	journal.save = function() {


		var req = new XMLHttpRequest();
		req.onload = function() {
			res = JSON.parse(this.responseText);
			if (res.status === "ok") {
				document.getElementById("xhr-message").innerHTML = "Salvataggio riuscito";
				formJournal["id"].value = res.data.id;
				document.getElementById("results").appendChild(createRow(res.data));
			} else {
				document.getElementById("xhr-message").innerHTML = "Salvataggio fallito";
			}
		};
		req.open("POST", "http://localhost:8000/" + "journal");


		req.send(JSON.stringify(journal));

	};

	return journal;
}

/**
* Effettua il submit del form
 */
function submitJournal(event) {
	// Impedisco il submit del form
	event.preventDefault();
	// Richiamo il metodo validate il quale valida i campi
	// (controlla che siano presenti quelli obbligatori e il loro tipo sia quello atteso)
	let journal = createJournal();
	if (!journal.isValid()) {
		alert("Il campo nome deve essere presente")
		return;
	}

	// effettuo save
	journal.save();

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
			document.getElementById("xhr-message").innerHTML = "Errore nel ottenere i Journals";
		}
	};
	req.open("GET", "http://localhost:8000/" + "journal");
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
/*
function createRowListener() {
	document.querySelector('.update-row').addEventListener('click', function(event) {
		let formJournal = document.getElementById("journal-form").elements;
		formJournal["id"].value = this.getAttribute("data-id");
	});
}*/




