DROP table IF EXISTS fabricantes;
DROP table IF EXISTS articulos;

create table fabricantes(
    codigo int auto_increment,
    nombre varchar(100),
    primary key (codigo)
);

create table articulos(
    codigo int auto_increment,
    nombre varchar(100),
    precio int,
    fabricante int,
    primary key (codigo),
    constraint articulos_fk foreign key (fabricante) references fabricantes(codigo)
    on update cascade on delete set null
);

insert into fabricantes (nombre)values('Jose');
insert into fabricantes (nombre)values('Paco');
insert into fabricantes (nombre)values('Pepe');
insert into fabricantes (nombre)values('Joel');
insert into fabricantes (nombre)values('Izan');

insert into articulos (nombre, precio, fabricante)values('Patatas', 3, 1);
insert into articulos (nombre, precio, fabricante)values('Manzanas', 4, 1);
insert into articulos (nombre, precio, fabricante)values('Helados', 5, 2);
insert into articulos (nombre, precio, fabricante)values('Platanos', 3, 3);
insert into articulos (nombre, precio, fabricante)values('Peras', 2, 4);