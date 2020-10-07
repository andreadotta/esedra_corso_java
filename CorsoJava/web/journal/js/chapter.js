document.addEventListener("DOMContentLoaded", function() {

	document.querySelector('#submit-chapter').addEventListener('click', function(event) {
		submitChapter(event);
	});

});

function createChapter() {
	let formChapter = document.getElementById("chapter-form").elements;
	const chapter = {};
	chapter.name = formChapter["name"].value;
	chapter.title = formChapter["title"].value;
	chapter.isValid = function() {
		if (chapter.name == '' || chapter.title == '') {
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
		alert("I campi nome e titolo devono essere presenti")
		return;
	}

	console.log(chapter.name);
	console.log(chapter.title);

}


function validate(formChapter) {
	let name = formChapter["name"];
	let title = formChapter["title"];
	if (name.value == '' || title.value == '') {
		alert("I campi nome e titolo devono essere presenti");
		return false;
	}
	return true;

}

