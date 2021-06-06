DROP TABLE IF EXISTS Student;

CREATE TABLE Student
(
    id SERIAL NOT NULL,
    name VARCHAR (255) NOT NULL,
    surname VARCHAR(255),
    date_birth DATE,
    phone VARCHAR(100),
    PRIMARY KEY (id)
);
INSERT INTO Student (id, name, surname, date_birth, phone)
VALUES (1050, 'Mateo', 'Alvarez', '2005-06-05', '+34 666666666');
INSERT INTO Student (id, name, surname, date_birth, phone)
VALUES (2050, 'Will', 'Smith', '1999-06-17', '+34 677878997');