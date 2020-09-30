document.addEventListener("DOMContentLoaded", function() {
	
	document.querySelector('#submit-author').addEventListener('click', function(event) {
		submitAuthor(event);	
	});
	
});
function submitAuthor(event) {
	//impdisco il submit del form
	event.preventDefault();
	
	let formAuthor = document.getElementById("author-form").elements;
	let name = formAuthor["name"];
	let email = formAuthor["email"];
	if (!validate(formAuthor)) {
		return;
	}
	//proseguo
    console.log(name.value);
    console.log(email.value);

}
function validate(formAuthor) {
	let name = formAuthor["name"];
	let email = formAuthor["email"];
	
	if (name.value == '' || email.value == '') {
		alert("I campi nome e email devono essere presenti");
		return false;		
	}
	return true;
		
}