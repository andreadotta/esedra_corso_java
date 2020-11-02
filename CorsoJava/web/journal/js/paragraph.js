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
		if (paragraph.text == '') {
			return false;
		}
		return true;
	}
	paragraph.save = function() {
		
		let paragraphData = new FormData();
		
		paragraphData.append("text", paragraph.text);
		
		var req = new XMLHttpRequest();
		req.onload = function() {
			console.log(this.responseText);

	};
	req.open("POST", "http://localhost:8000/" + "paragraph");
	req.send(paragraphData);
	}
	
	return paragraph;
};

function submitParagraph(event) {
	event.preventDefault();

	let paragraph = createParagraph();

	if (!paragraph.isValid()) {
		alert("il campo text deve essere present");
		return;
	}

	
	//proseguo
    paragraph.save;



}