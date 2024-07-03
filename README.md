# DDL

```sql
CREATE DATABASE cinecampus;
USE cinecampus;

CREATE TABLE pais (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(50),
  PRIMARY KEY (id)
);
    
CREATE TABLE genero (
    id INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE formato (
    id INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(50),
	PRIMARY KEY (id)
);

CREATE TABLE tipoactor (
	id INT NOT NULL AUTO_INCREMENT,
	descripcion VARCHAR(50),
	PRIMARY KEY (id)
);

CREATE TABLE actor(
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    idnacionalidad INT NOT NULL,
    idgenero INT NOT NULL,
    PRIMARY KEY (id),
    
    CONSTRAINT fk_actor_pais
    FOREIGN KEY (idnacionalidad)
    REFERENCES pais(id),
    
    CONSTRAINT fk_actor_genero
    FOREIGN KEY (idgenero)
    REFERENCES genero(id)
);


CREATE TABLE pelicula (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	codinterno VARCHAR(5) NOT NULL UNIQUE,
	nombre VARCHAR(50) NOT NULL,
	duracion VARCHAR(20),
	sinopsis TEXT
);


CREATE TABLE peliculaprotagonista(
    id INT NOT NULL AUTO_INCREMENT,
    idpelicula INT NOT NULL,
    idprotagonista INT NOT NULL,
    idtipoactor INT NOT NULL,
    PRIMARY KEY (id),
    
    CONSTRAINT fk_protagonista_pelicula
    FOREIGN KEY (idpelicula)
    REFERENCES pelicula(id),
    
    CONSTRAINT fk_protagonista_actor
    FOREIGN KEY (idprotagonista)
    REFERENCES actor(id),
    
    CONSTRAINT fk_protagonista_tipoactor
    FOREIGN KEY (idtipoactor)
    REFERENCES tipoactor(id)
);


CREATE TABLE peliculaformato(
    id INT NOT NULL AUTO_INCREMENT,
    idpelicula INT NOT NULL,
    idformato INT NOT NULL,
    cantidad INT,
    PRIMARY KEY (id),
    
    CONSTRAINT fk_pformato_pelicula
    FOREIGN KEY (idpelicula)
    REFERENCES pelicula(id),
    
    CONSTRAINT fk_pformato_formato
    FOREIGN KEY (idformato)
    REFERENCES formato(id)
);
```







# DML

```sql
INSERT INTO pais (descripcion) VALUES
('Colombia'),
('Estados Unidos'),
('Canada'),
('Mexico'),
('Inglaterra'),
('España');

INSERT INTO genero (descripcion) VALUES
('Drama'),
('Comedia'),
('Terror'),
('Thriller'),
('Gore'),
('Acción');
('Ciencia ficción')

INSERT INTO formato (descripcion) VALUES
('DVD'),
('BLUE RAY'),
('PLATAFORMA'),
('VHS');

INSERT INTO tipoactor (descripcion)  VALUES
('Reparto'),
('Protagonista'),
('Antagonista'),
('Doble de acción');

INSERT INTO actor (nombre, idnacionalidad, edad, idgenero) VALUES
('Brad Pitt', 2, 40, 1),
('Angelina Jolie', 2, 38, 6),
('Leonardo Dicaprio', 2, 43, 1),
('Robert De Niro', 5, 54, 1),
('Nicolas Cage', 3, 44, 6),
('Jim Carrey', 2, 50, 2);

INSERT INTO pelicula (codinterno, nombre, duracion, sinopsis) VALUES
('001', 'Matrix', '2h', 'La matrix'),
('002', 'Titanic', '3h', "Un barco se hunde"),
('003', 'TaxiDriver', '1.5h','Exmilitar loco'),
('004', 'Mentiroso mentiroso', '1.5h','Comedia pura');
```

