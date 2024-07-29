-- id & email & password
CREATE TABLE tbl_user (
	id SERIAL PRIMARY KEY NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL
);

CREATE TABLE tbl_product (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(50) NOT NULL,
	qty INT NOT NULL,
	price DOUBLE PRECISION NOT NULL,
	discount INT NOT NULL,
	total DOUBLE PRECISION NOT NULL,
	image TEXT NOT NULL,
	owner INT NOT NULL,
	CONSTRAINT fk_owner FOREIGN KEY (owner) REFERENCES tbl_user(id)
);

-- add user
INSERT INTO tbl_user (email,password) VALUES ('admin@123.pk',MD5('admin123'));
-- add product
INSERT INTO tbl_product (name,qty,price,discount,total,image,owner) VALUES
('Product A', 1, 39.99, 10, 34.99, 'image_url_1', 1),
('Product B', 2, 49.99, 10, 44.99, 'image_url_2', 1);

-- select user
SELECT * FROM tbl_user;
-- select product
SELECT * FROM tbl_product;
SELECT 
	p.id ,
	p.name,
	p.qty,
	p.price,
	p.discount,
	p.total,
	p.image,
	u.email AS owner
	FROM tbl_product p JOIN tbl_user u ON p.owner = u.id;

-- Drop table
DROP TABLE tbl_product;

