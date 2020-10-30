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
	image.save = function() {
		formImage["name"].value = "ciao ciao";
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
