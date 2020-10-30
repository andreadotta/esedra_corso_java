document.addEventListener("DOMContentLoaded", function() {

	document.querySelector('#submit-video').addEventListener('click', function(event) {
		submitVideo(event);
	});

});

function createVideo() {
	let formVideo = document.getElementById("video-form").elements;
	const video = {};
	video.src = formVideo["src"].value;
	video.name = formVideo["name"].value;
	video.title = formVideo["title"].value;
	video.isValid = function() {
		if (video.src == '' || video.name == '' || video.title == '') {
			return false;
		}
		return true;
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

}


function validate(formVideo) {
	let src = formVideo["src"];
	let name = formVideo["name"];
	let title = formVideo["title"];
	if (src.value == '' || name.value == '' || title.value == '') {
		alert("I campi src, nome e titolo devono essere presenti");
		return false;
	}
	return true;

}