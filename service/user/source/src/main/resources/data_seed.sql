-- DROP TABLE if exists _cart;
-- DROP TABLE IF EXISTS _item;
-- DROP TABLE IF EXISTS _product;

-- CREATE TABLE _cart (
-- 	cart_id INT NOT NULL auto_increment,
--     PRIMARY KEY (cart_id)
-- );

-- CREATE TABLE _product (
-- 	product_id INT NOT NULL AUTO_INCREMENT,
--     PRIMARY KEY (product_id)
-- );

-- create table _item(
-- 	item_id INT NOT NULL auto_increment,
--     quantity INT NOT NULL,
--     cart_id INT,
--     product_id INT,
--     PRIMARY KEY (item_id),
--     foreign key (cart_id) references _cart(cart_id),
--     foreign key (product_id) references _product(product_id)
-- );

USE lucky_pet_db;

INSERT INTO _cart ()
VALUES(), (), (), (), (), (), (), (), (), (), ();

INSERT INTO _product (description, price, stock)
VALUES("Sample text", 500, 230), 
("", 60, 17),
("Item w/ price negative one dollar", -100, 40),
("<script>", 100000000, 17),
("SELECT * FROM CartItem", 50, 5),
("Sample description", 49, 6),
("Sample description", 99999999, 0),
("Sample description", 50, -1),
(NULL, 500, 30),
("Sample description", 0, 50),
("Sample description", 49, 50);

INSERT INTO _item (quantity, cart_id, product_id)
VALUES (5,1,1), (5,2,2), (5,3,3), (5,4,4), (5,5,5), (5,6,6), (5,7,7), (5,8,11), (5,8,8), (5,9,10), (5,10,9);
