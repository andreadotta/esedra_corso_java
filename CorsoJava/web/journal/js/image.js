document.addEventListener("DOMContentLoaded", function() {

	document.querySelector('#submit-image').addEventListener('click', function(event) {
		submitImage(event);
	});

});
 
function createImage() {
	let formImage = document.getElementById("image-form").elements;
	const image = {};
	image.src = formImage["src"].value;
	image.name = formImage["name"].value;
	
	image.isValid = function() {
		if (image.src == '' || image.name == '') {
			return false;
		}
		return true;
	};

	return image;
}

function submitImage(event) {
	event.preventDefault();
	let image = createImage();
	if (!image.isValid()) {
		alert("I campi src, nome e devono essere presenti")
		return;
	}

	console.log(image.src);
	console.log(image.name);
}


function validate(formImage) {
	let src = formImage["src"];
	let name = formImage["name"];
	
	if (src.value == ' ' || name.value == ' ') {
		alert("I campi src, nome e devono essere presenti");
		return false;
	}
	return true;

}
