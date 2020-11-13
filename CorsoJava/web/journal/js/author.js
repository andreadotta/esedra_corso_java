document.addEventListener("DOMContentLoaded", function() {
	document.querySelector('#submit-author').addEventListener('click', function(event) {
		submitAuthor(event);
	});

});

function createAuthor() {
	let formAuthor = document.getElementById("author-form").elements;
	const author = {};
	author.id = parseInt(formAuthor["id"].value);
	author.name = formAuthor["name"].value;
	author.email = formAuthor["email"].value;
	/*Valida il form
	* Controlla che siano presenti quelli obbligatori e il loro tipo sia quello atteso */
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
	//impedisco il submit del form
	event.preventDefault();
	//richiamo il metodo validate il quale valida i campi (controlla che siano presenti quelli obbligatori e il loro tipo sia quello atteso)
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
			console.log(res.data);
		} else {
			document.getElementById("xhr-message").innerHTML = "Errore nel ottenere i Authors";
		}
	};
	req.open("GET", "http://localhost:8000/" + "author");
	req.send();
}();
