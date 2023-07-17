BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE reps (
	id SERIAL NOT NULL PRIMARY KEY,
	name varchar NOT NULL,
	phone varchar (20) NOT NULL,
	party varchar (50),
	email varchar (50)
);

COMMIT TRANSACTION;