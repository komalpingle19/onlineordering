DROP TABLE IF EXISTS billionaires;
DROP TABLE IF EXISTS ORDER_ITEM;
DROP TABLE IF EXISTS ORDER_TABLE;

CREATE TABLE billionaires (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);

INSERT INTO billionaires (first_name, last_name, career) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');


--CREATE TABLE ORDER_ITEM(
--item_name VARCHAR(250) NOT NULL,
--quantity INT(250) NOT NULL,
--size CHAR(1),
--is_prepared CHAR(1),
--order_number INT FOREIGN KEY REFERENCES ORDER(order_id)
--);

CREATE TABLE ORDER_ITEM(
item_name VARCHAR(250) NOT NULL,
quantity INT(250) NOT NULL,
size CHAR(1),
is_prepared CHAR(1)
);

CREATE TABLE ORDER_TABLE(
  order_time TIMESTAMP(3),
  order_id INTEGER  PRIMARY KEY AUTO_INCREMENT
  );

Insert INTO ORDER(ORDER_TIME) VALUES(SYSTIMESTAMP);

--Insert INTO ORDER
