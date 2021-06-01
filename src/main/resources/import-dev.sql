DROP TABLE IF EXISTS Fruit;

CREATE TABLE Fruit
(
    id SERIAL NOT NULL UNIQUE,
    name VARCHAR (255) NOT NULL,
    description VARCHAR(255),
    PRIMARY KEY (id)
);
INSERT INTO Fruit (id, name, description)
VALUES (DEFAULT, 'Apple', 'Winter fruit');
INSERT INTO Fruit (id, name, description)
VALUES (DEFAULT, 'Pineapple', 'Tropical fruit');