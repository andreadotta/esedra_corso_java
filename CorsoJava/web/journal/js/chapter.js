document.addEventListener("DOMContentLoaded", function() {

	document.querySelector('#submit-chapter').addEventListener('click', function(event) {
		submitChapter(event);
	});

});

function createChapter() {
	let formChapter = document.getElementById("chapter-form").elements;
	const chapter = {};
	chapter.id = parseInt(formChapter["id"].value);
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
			res = JSON.parse(this.responseText);
			if (res.status === "ok") {
				document.getElementById("xhr-message").innerHTML = "Salvataggio riuscito";
				formChapter["id"].value = res.data.id;
			} else {
				document.getElementById("xhr-message").innerHTML = "Salvataggio fallito";
			}
		};
		req.open("POST", "http://localhost:8000/" + "chapter");

		req.send(JSON.stringify(chapter));
	};

	return chapter;
}

function submitChapter(event) {
	// Impedisco il submit del form
	event.preventDefault();
	let chapter = createChapter();
	if (!chapter.isValid()) {
		alert("I campi titolo e data devono essere presenti")
		return;
	}

	// Effettuo il save
	chapter.save();

}

var getall = function getAll() {
	var req = new XMLHttpRequest();
	req.onload = function() {
		res = JSON.parse(this.responseText);
		if (res.status === "ok") {
			console.log(res.data);
		} else {
			document.getElementById("xhr-message").innerHTML = "Errore nel ottenere i Chapters";
		}
	};
	req.open("GET", "http://localhost:8000/" + "chapter");
	req.send();
}();

