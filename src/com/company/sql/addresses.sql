CREATE DATABASE addresses;
SELECT * FROM addresses.addresses;
CREATE TABLE addresses(
id INT NOT NULL,
city VARCHAR (255) NOT NULL,
street VARCHAR (255) NOT NULL,
numHome VARCHAR (255) NOT NULL,
building INT,
numApart INT,
PRIMARY KEY (id)
);