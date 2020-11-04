document.addEventListener("DOMContentLoaded", function() {

	document.querySelector('#submit-chapter').addEventListener('click', function(event) {
		submitChapter(event);
	});

});

function createChapter() {
	let formChapter = document.getElementById("chapter-form").elements;
	const chapter = {};
	chapter.title = formChapter["title"].value;
	chapter.date = formChapter["date"].value;
	chapter.isValid = function() {
		if (chapter.title == '' || chapter.date == '') {
			return false;
		}
		return true;
	};
	chapter.save = function() {


		var req = new XMLHttpRequest();
		req.onload = function() {
			console.log(this.responseText);
		};
		req.open("POST", "http://localhost:8000/" + "chapter");
		/*req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
		req.setRequestHeader('Access-Control-Allow-Headers', '*');
		req.setRequestHeader('Access-Control-Allow-Origin', '*');*/
		//req.withCredentials = true;

		req.send(JSON.stringify(chapter));

	};

	return chapter;
}

function submitChapter(event) {
	event.preventDefault();
	let chapter = createChapter();
	if (!chapter.isValid()) {
		alert("I campi titolo e data devono essere presenti")
		return;
	}
	chapter.save();


}

