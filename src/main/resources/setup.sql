create database if not exists cine_db;
use cine_db;

-- crear de la tabla usuarios
create table usuarios(
    id int auto_increment primary key,
    nombre varchar(100) not null,
    correo varchar(100) unique not null,
    fecha_registro timestamp default current_timestamp
);

-- crear la tabla funciones
create table peliculas(
    id int auto_increment primary key,
    nombre varchar(100) not null,
    idioma varchar(100) not null,
    duracion int not null
);

-- crear tabla funciones
create table funciones(
    id int auto_increment primary key,
    pelicula_id int not null,
    sala int not null,
    horario datetime not null,
    constraint fk_pelicula_funcion foreign key (pelicula_id) references peliculas(id)
                      on delete cascade
);

-- crear tabla boletos
create table boletos(
    id int auto_increment primary key,
    funcion_id int not null,
    asiento varchar(10) not null,
    reservado boolean default false,
    constraint fk_funcion_boleto foreign key (funcion_id) references funciones(id)
                    on delete cascade
);

-- Agregar un usuario
INSERT INTO usuarios (nombre, correo)
VALUES ('Juan Pérez', 'juan.perez@example.com');

-- Agregar una película
INSERT INTO peliculas (nombre, idioma, duracion)
VALUES ('Interstellar', 'Español', 169);

-- Agregar una función
INSERT INTO funciones (pelicula_id, sala, horario)
VALUES (1, 1, '2024-12-01 18:00:00');

-- Agregar boletos
INSERT INTO boletos (funcion_id, asiento)
VALUES (1, 'A1'), (1, 'A2'), (1, 'A3');
