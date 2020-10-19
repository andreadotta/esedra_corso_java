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

	return chapter;
}

function submitChapter(event) {
	event.preventDefault();
	let chapter = createChapter();
	if (!chapter.isValid()) {
		alert("I campi titolo e data devono essere presenti")
		return;
	}

	console.log(chapter.title);
	console.log(chapter.date);

}


function validate(formChapter) {
	let title = formChapter["title"];
	let date = formChapter["date"];
	if (title.value == '' || date.value == '') {
		alert("I campi titolo e data devono essere presenti");
		return false;
	}
	return true;

}

