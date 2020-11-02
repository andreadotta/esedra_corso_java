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
	video.save = function() {
		
		let formData = new FormData();
		
		formData.append("src", video.src);
		formData.append("name", video.name);
		formData.append("title", video.title);

		var req = new XMLHttpRequest();
		req.onload = function() {
			console.log(this.responseText);
		};
		req.open("POST", "http://localhost:8000/" + "video");
		/*req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
		req.setRequestHeader('Access-Control-Allow-Headers', '*');
		req.setRequestHeader('Access-Control-Allow-Origin', '*');*/
		//req.withCredentials = true;

		req.send(formData);

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