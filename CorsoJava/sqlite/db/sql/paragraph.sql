DROP TABLE IF EXISTS "paragraph";
CREATE TABLE "paragraph" (
	"id"	INTEGER NOT NULL,
	"text"	TEXT NOT NULL,
	"id_chapter" INTEGER NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT),
	FOREIGN KEY("id_chapter") REFERENCES chapter("id")
	
);