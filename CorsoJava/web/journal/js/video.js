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
			if (res.status === "ok") { //il backend ha risposto positivamente; quindi procedo ad aggiornare la pagina (DOM)
				document.getElementById("xhr-message").innerHTML = "Salvataggio riuscito"; //imposto un messaggio di successo
				//vado a cercare una riga che abbia data-id con valore uguale al valore del campo "id" dell'oggetto 
				//restituito dal backend
				let foundRow = document.querySelector("[data-id='" + res.data.id + "']"); //utilizzo query selector: mi rende il primo elemento trovato
				if (foundRow) { //se trovo un elemento con data-id
					foundRow.innerHTML = ""; //pulisco la riga che ho trovato...
					createRowElements(res.data, foundRow); //...e poi vado a inserire il contenuto
				} else { //non ho trovato nessun data-id corrispondente; quindi si tratta di un nuvo record
					document.getElementById("results").appendChild(createRow(res.data)); //creo una nuova riga e la appendo al result set
				}
			} else {
				document.getElementById("xhr-message").innerHTML = "Salvataggio fallito";
			}
		};
		req.open("POST", "http://localhost:8080/" + "videos");

		req.send(JSON.stringify(video));

	}

	return video;
};

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
			JSON.parse(res.data).forEach(function(item) {
				document.getElementById("results").appendChild(createRow(item));
		    });
		} else {
			document.getElementById("xhr-message").innerHTML = "Errore nel ottenere i Journals";
		}
	};
	req.open("GET", "http://localhost:8080/" + "videos");
	req.send();
}();

function createRow(item) {
	//creo una riga
	let row = document.createElement("div");
	row.className = "row"; //setto la classe
	row.setAttribute("data-id", item.id); //setto l'attributo "data-id"
	return createRowElements(item, row);
}

function createRowElements(item, row) {
	row.appendChild(createRowDataCell("id", item.id)); //aggiungo la colonna alla riga
	row.appendChild(createRowDataCell("src", item.src)); //aggiungo la colonna alla riga
	row.appendChild(createRowDataCell("name", item.name)); //aggiungo la colonna alla riga
	row.appendChild(createRowDataCell("title", item.title)); //aggiungo la colonna alla riga
	//creo una colonna BOTTONI
	col = document.createElement("div");
	col.className = "col-btn";
	//creo un tag A Modifica	
	let updBtn = document.createElement("a");
	updBtn.className = "update-row";
	updBtn.setAttribute("data-id", item.id);
	updBtn.innerHTML="Seleziona";
	updBtn.setAttribute('href', "#");
	updBtn.addEventListener("click", function () {
		let targetRow = document.querySelector("[data-id='" + this.getAttribute("data-id") + "']");
		let src = targetRow.querySelector("[data-src]");
		let name = targetRow.querySelector("[data-name]");
		let title = targetRow.querySelector("[data-title]");
		formVideo = document.getElementById("video-form").elements;
		formVideo["id"].value = this.getAttribute("data-id");
		formVideo["src"].value = src.innerHTML;
		formVideo["name"].value = name.innerHTML;
		formVideo["title"].value = title.innerHTML;
	});
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

function createRowDataCell(name, value) {
	col = document.createElement("div");
	col.className = "col";
	col.setAttribute("data-" + name, value); //setto l'attributo data-name
	col.innerHTML = value; //setto il contenuto visibile della cella
	return col;
}