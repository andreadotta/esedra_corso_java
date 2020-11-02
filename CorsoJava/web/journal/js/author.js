document.addEventListener("DOMContentLoaded", function() {
	document.querySelector('#submit-author').addEventListener('click', function(event) {
		submitAuthor(event);
	});

});

function createAuthor() {
	let formAuthor = document.getElementById("author-form").elements;
	const author = {};
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
		let formData = new FormData();
		
		formData.append("name", author.name);
        formData.append("email", author.email);

		var req = new XMLHttpRequest();
		req.onload = function() {
			console.log(this.responseText);
		};
		req.open("POST", "http://localhost:8000/" + "author");
		/*req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
		req.setRequestHeader('Access-Control-Allow-Headers', '*');
		req.setRequestHeader('Access-Control-Allow-Origin', '*');*/
		//req.withCredentials = true;

		req.send(formData);
		
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

	//proseguo
	console.log(author.name);
	console.log(author.email);

}
