document.addEventListener("DOMContentLoaded", function() {

	document.querySelector('#submit-image').addEventListener('click', function(event) {
		submitImage(event);
	});

});
 
function createImage() {
	let formImage = document.getElementById("image-form").elements;
	const image = {};
	image.id = parseInt(formImage["id"].value);
	image.src = formImage["src"].value;
	image.name = formImage["name"].value;
	
	image.isValid = function() {
		if (image.src == '' || image.name == '') {
			return false;
		}
		return true;
	};
	image.save = function() {
		
		var req = new XMLHttpRequest();
		req.onload = function() {
			res = JSON.parse(this.responseText);
			if (res.status === "ok") {
				document.getElementById("xhr-message").innerHTML = "Salvataggio riuscito";
				formImage["id"].value = res.data.id;
			} else {
				document.getElementById("xhr-message").innerHTML = "Salvataggio fallito";				
			}
		};
		req.open("POST", "http://localhost:8000/" + "image");


		req.send(JSON.stringify(image));
		
    };

	return image;
}

function submitImage(event) {
	event.preventDefault();
	let image = createImage();
	if (!image.isValid()) {
		alert("I campi src e nome devono essere presenti")
		return;
	}

	image.save();
	
}
