CREATE DATABASE apirestdb;

USE apirestdb;

CREATE TABLE pqrs (
    id INT NOT NULL AUTO_INCREMENT,
    fecha DATE,
    asunto VARCHAR(50) NOT NULL,
    descripcion VARCHAR(200),
    estado VARCHAR(20) NOT NULL,
    tipo VARCHAR(1) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO pqrs VALUES (1,'2023-03-01',
'Peticion de datos de materias',
'Requiero obtener las notas de las materias cursadas',
'Activo',
'P'
);