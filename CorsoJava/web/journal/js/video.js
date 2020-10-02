document.addEventListener("DOMContentLoaded", function() {

	document.querySelector('#submit-video').addEventListener('click', function(event) {
		submitVideo(event);
	});

});

function submitVideo(event) {
	event.preventDefault();
	let formVideo = document.getElementById("video-form").elements;
	let src = formVideo["src"];
	let name = formVideo["name"];
	let title = formUser["title"];
	if (!validate(formVideo)) {
		return;
	}

	console.log(src.value);
	console.log(name.value);
	console.log(title.value);

}


function validate(formVideo) {
	let src = formVideo["src"];
	let name = formVideo["name"];
	let title = formVideo["title"];
	if (src.value == ' ' || name.value == ' ' || title.value == ' ') {
		alert("I campi src, name e title devono essere presenti");
		return false;
	}
	return true;

}

