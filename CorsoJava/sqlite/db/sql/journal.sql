DROP TABLE IF EXISTS "journal";
CREATE TABLE "journal" (
	"id"	INTEGER NOT NULL UNIQUE,
	"name"	TEXT NOT NULL,
	"id_author" INTEGER NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
	FOREIGN KEY("id_author") REFERENCES author("id")
);
