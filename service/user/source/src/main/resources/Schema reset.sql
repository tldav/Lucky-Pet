DROP TABLE if exists _cart;

CREATE TABLE _cart (
	id INT,
	username VARCHAR(255)
);

INSERT INTO _cart (id,username)
VALUES(1, "jon"), (10,"fin");

SELECT * FROM _cart;
