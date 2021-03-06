DROP TABLE IF EXISTS "video";
CREATE TABLE "video" (
	"title"	TEXT NULL,
	"id"	INTEGER NOT NULL UNIQUE,
	"src"	TEXT NOT NULL, 
	"name"	TEXT NULL, 	
	"id_paragraph" INTEGER NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
	FOREIGN KEY("id_paragraph") REFERENCES paragraph("id")
);