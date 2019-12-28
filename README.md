# SpringBoot API REST JPA CRUD

## Proyecto SpringBoot que realiza las operaciones CRUD sobre un Catálogo de Tipos


script SQL sobre la base de datos/catalogo tipo

create database test;
use test;

create table tipo(
	clave char(2) not null primary key,
	descripcion char(50) not null default ''	
);

-- datos iniciales opcionales
insert into tipo (clave, descripcion) values('CA', 'Camisa');
insert into tipo (clave, descripcion) values('PA', 'Pantalon');
insert into tipo (clave, descripcion) values('FA', 'Falda');
insert into tipo (clave, descripcion) values('VE', 'Vestido');

select * from tipo
