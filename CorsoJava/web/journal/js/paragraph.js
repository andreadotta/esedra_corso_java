document.addEventListener("DOMContentLoaded", function() {
	
	document.querySelector('#submit-paragraph').addEventListener('click', function(event) {
		submitParagraph(event);	
	});
	
});
function createParagraph() {
	let formParagraph = document.getElementById("paragraph-form").elements;
	const paragraph = {};
	paragraph.text = formParagraph["text"].value;
	
	paragraph.isValid = function() {
		if (paragraph.text == '' ) {
			return false;		
		}
		return true;
		}
		return paragraph;
		};

function submitParagraph(event) {
	event.preventDefault();
	
	let formParagraph = createParagraph();
	
	if(!paragraph.isValid()){
	alert("il campo text deve essere present");
	return;
	}
	
	
	
}