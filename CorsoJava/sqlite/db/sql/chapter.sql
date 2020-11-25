PRAGMA foreign_keys=ON;
DROP TABLE IF EXISTS "chapter";
CREATE TABLE "chapter" (
	"id"	INTEGER NOT NULL UNIQUE,
	"title"	TEXT NOT NULL UNIQUE,
	"date"	TEXT NOT NULL,
	"id_journal" INTEGER NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT),
	FOREIGN KEY("id_journal") REFERENCES journal("id")
);