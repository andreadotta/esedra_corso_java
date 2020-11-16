document.addEventListener("DOMContentLoaded", function() {

	document.querySelector('#submit-video').addEventListener('click', function(event) {
		submitVideo(event);
	});

});

function createVideo() {
	let formVideo = document.getElementById("video-form").elements;
	const video = {};
	video.id = parseInt(formVideo["id"].value);
	video.src = formVideo["src"].value;
	video.name = formVideo["name"].value;
	video.title = formVideo["title"].value;
	video.isValid = function() {
		if (video.src == '' || video.name == '' || video.title == '') {
			return false;
		}
		return true;
	};
	video.save = function() {

		var req = new XMLHttpRequest();
		req.onload = function() {
			res = JSON.parse(this.responseText);
			if (res.status === "ok") {
				document.getElementById("xhr-message").innerHTML = "Salvataggio riuscito";
				formVideo["id"].value = res.data.id;
			} else {
				document.getElementById("xhr-message").innerHTML = "Salvataggio fallito";				
			}
		};
		req.open("POST", "http://localhost:8000/" + "video");
		req.send(JSON.stringify(video));

	};
	return video;
}

function submitVideo(event) {
	event.preventDefault();
	let video = createVideo();
	if (!video.isValid()) {
		alert("I campi src, nome e titolo devono essere presenti")
		return;
	}

	console.log(video.src);
	console.log(video.name);
	console.log(video.title);
	video.save();

}

var getall = function getAll() {
	var req = new XMLHttpRequest();
	req.onload = function() {
		res = JSON.parse(this.responseText);
		if (res.status === "ok") {
			console.log(res.data);
		} else {
			document.getElementById("xhr-message").innerHTML = "Errore nel ottenere i Journals";
		}
	};
	req.open("GET", "http://localhost:8000/" + "video");
	req.send();
}();