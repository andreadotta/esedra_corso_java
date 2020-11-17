document.addEventListener("DOMContentLoaded", function() {

	document.querySelector('#submit-paragraph').addEventListener('click',
			function(event) {
				submitParagraph(event);
			});

});
function createParagraph() {
	let formParagraph = document.getElementById("paragraph-form").elements;
	const paragraph = {};
	paragraph.id = parseInt( formParagraph["id"].value);
	paragraph.text = formParagraph["text"].value;

	paragraph.isValid = function() {
		if (paragraph.text == '') {
			return false;
		}
		return true;
	}
	paragraph.save = function() {
		

		var req = new XMLHttpRequest();
		req.onload = function() {
			res = JSON.parse(this.responseText);
			if (res.status === "ok") {
				document.getElementById("xhr-message").innerHTML = "Salvataggio riuscito";
				formParagraph["id"].value = res.data.id;
				document.getElementById("results").appendChild(createRow(res.data));
			} else {
				document.getElementById("xhr-message").innerHTML = "Salvataggio fallito";				
			}

		};
		req.open("POST", "http://localhost:8000/" + "paragraph");
		req.send(JSON.stringify(paragraph));
	};

	return paragraph;
};

function submitParagraph(event) {
	event.preventDefault();

	let paragraph = createParagraph();

	if (!paragraph.isValid()) {
		alert("il campo text deve essere present");
		return;
	}

	// proseguo
	paragraph.save();

}

var getall = function getAll() {
	var req = new XMLHttpRequest();
	req.onload = function() {
		res = JSON.parse(this.responseText);
		if (res.status === "ok") {
			JSON.parse(res.data).forEach(function(item){
				document.getElementById("results").appendChild(createRow(item));
				createRowListener();	
			});
		} else {
			document.getElementById("xhr-message").innerHTML = "Errore nel ottenere i Paragraphs";
		}
	};
	req.open("GET", "http://localhost:8000/" + "paragraph");
	req.send();
}();

function createRow(item) {
	//creo una riga
	let row = document.createElement("div");
	row.className = "row";
	//creo una colonna
	let col = document.createElement("div");
	col.className = "col-label";
	col.innerHTML = item.id;
	//aggiungo la colonna alla riga
	row.appendChild(col);
	//creo una colonna	
	col = document.createElement("div");
	col.className = "col";
	col.innerHTML = item.text;
	//aggiungo la colonna alla riga	
	row.appendChild(col);
	//creo una colonna		
	col = document.createElement("div");
	col.className = "col-btn";
	//creo un tag A	Modifica	
	let updBtn = document.createElement("a");
	updBtn.setAttribute("data-id", item.id);
	updBtn.className = "update-row";
	updBtn.innerHTML="Modifica";
	updBtn.setAttribute('href', "#");
	//aggiungo il pulsante alla colonna	
	col.appendChild(updBtn);	
	//creo un tag A	Cancella	
	let delBtn = document.createElement("a");
	delBtn.setAttribute("data-id", item.id);
	delBtn.className = "delete-row";
	delBtn.innerHTML="Cancella";
	delBtn.setAttribute('href', "#");
	//aggiungo il pulsante alla colonna	
	col.appendChild(delBtn);
	//aggiungo la colonna alla riga	
	row.appendChild(col);
	return row;
}
/*
function createRowListener() {
	document.querySelector('.update-row').addEventListener('click', function(event) {
		let formJournal = document.getElementById("journal-form").elements;
		formJournal["id"].value = this.getAttribute("data-id");
	});
}*/


