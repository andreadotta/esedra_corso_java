document.addEventListener("DOMContentLoaded", function() {

	document.querySelector('#submit-journal').addEventListener('click', function(event) {
		submitJournal(event);
	});

});

function createJournal() {
	let formJournal = document.getElementById("journal-form").elements;
	const journal = {};
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
			console.log(this.responseText);
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




