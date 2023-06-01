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

USE DATABASE lucky_pet_db;

INSERT INTO _cart (cart_id)
VALUES(1), (10);

INSERT INTO _product (product_id)
VALUES(2), (11);

INSERT INTO _item (item_id,quantity,cart_id,product_id)
VALUES (1,10,1,2), (2,20,10,11);
