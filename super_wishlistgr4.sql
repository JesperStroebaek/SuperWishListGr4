-- create database --
CREATE DATABASE super_wishlistgr4;
USE super_wishlistgr4;

CREATE TABLE users( 
id INT NOT NULL AUTO_INCREMENT,
username VARCHAR(50) NOT NULL,
passwordwish VARCHAR(50),
PRIMARY KEY(id)
);

CREATE TABLE wishlist(
wishlist_id INT NOT NULL AUTO_INCREMENT,
wishlist_name VARCHAR(50) NOT NULL,
enddate DATE default null,
user_id INT NOT NULL,
PRIMARY KEY (wishlist_id),
FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE wish(
wish_id INT NOT NULL AUTO_INCREMENT,
title VARCHAR(50) NOT NULL,
link VARCHAR(2083) NOT NULL,
fulfillwish VARCHAR(255),
user_id INT NOT NULL,
wishlist_id INT NOT NULL,
PRIMARY KEY (wish_id),
FOREIGN KEY (user_id) REFERENCES users(id),
FOREIGN KEY (wishlist_id) REFERENCES wishlist(wishlist_id)
);

INSERT INTO users (username, passwordwish, id)
VALUES ('robert', 'satan', 123);

SELECT * FROM users;

INSERT INTO wishlist (wishlist_id, wishlist_name, enddate, user_id)
VALUES (1234,
"fødselsdag",
'2007-03-23',
(SELECT id FROM users WHERE username='robert')
);


INSERT INTO wish (wish_id, title, link, fulfillwish, user_id, wishlist_id)
VALUES (
656 ,
'Bil',
'her kan købe en bil til mig',
'Marianne vil gerne købe en bil til robert',
(SELECT id FROM users WHERE username='robert'),
(SELECT wishlist_id FROM wishlist WHERE wishlist_id='1234')
);

SELECT * FROM wish;