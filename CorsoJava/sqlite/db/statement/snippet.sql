CREATE TABLE 'user' (
  'userId' integer PRIMARY KEY,
  'userEmail' TEXT NOT NULL UNIQUE,
  'userName' TEXT NOT NULL
)

INSERT INTO user (userId, useremail, username) 
	VALUES (1, 'roberto@xkoll.com', 'Roberto Baldi')

INSERT INTO user (userId, useremail, username) 
	VALUES (2, 'andrea@xkoll.com', 'Andrea Dotta')
	
SELECT * FROM user;