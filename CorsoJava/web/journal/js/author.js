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
		formAuthor["name"].value = "ciao ciao";
	};
	
	return author;
}
/**
 * Effettua il submit del form
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
