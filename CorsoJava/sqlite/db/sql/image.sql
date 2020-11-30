DROP TABLE IF EXISTS "image";
CREATE TABLE "image" (
	"name"	TEXT NULL,
	"id"	INTEGER NOT NULL UNIQUE,
	"src"	TEXT NOT NULL, 
	"id_paragraph" INTEGER NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
	FOREIGN KEY("id_paragraph") REFERENCES paragraph("id")
);