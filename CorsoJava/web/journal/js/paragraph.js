document.addEventListener("DOMContentLoaded", function() {
	
	document.querySelector('#submit-paragraph').addEventListener('click', function(event) {
		submitParagraph(event);	
	});
	
});

function submitAuthor(event) {
	
	event.preventDefault();
	
	
	let formParagraph = document.getElementById("paragraph-form").elements;
	
	let text = formParagraph["text"];
	
	
	if (!validate(formParagraph)) {
		return;
	}
	
    console.log(text.value);
    


function validate(formParagraph) {
	let text = formParagraph["paragraph"];
	

	if (text.value == '' ) {
		alert("il campo nome deva essere presente");
		return false;		
	}
	return true;
		
}