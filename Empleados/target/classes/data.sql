DROP table IF EXISTS empleados;

create table departamentos(
    id int auto_increment PRIMARY KEY,
    nombre varchar(100),
    presupuesto int
);

insert into departamentos (nombre, presupuesto) values ('RR.HH', 85000);
insert into departamentos (nombre, presupuesto) values ('Contabilidad', 23000);
insert into departamentos (nombre, presupuesto) values ('Desarrollo', 55000);
insert into departamentos (nombre, presupuesto) values ('Logística', 80000);
insert into departamentos (nombre, presupuesto) values ('Distribución', 12000);

DROP table IF EXISTS empleados;

create table empleados(
    dni char (12) PRIMARY KEY,
    nombre nvarchar(100),
    apellidos nvarchar(100),
    id_departamento int,
    FOREIGN KEY(id_departamento) REFERENCES departamentos(id) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into empleados (dni, nombre, apellidos, id_departamento) values ('123A', 'Arthur', 'Conan Doyle', 1);
insert into empleados (dni, nombre, apellidos, id_departamento) values ('123B', 'Arthur', 'Schopenhauer', 2);
insert into empleados (dni, nombre, apellidos, id_departamento) values ('123C', 'Erwin', 'Schrödinger',3);
insert into empleados (dni, nombre, apellidos, id_departamento) values ('123D', 'Philo', 'Farnsworth', 4);
insert into empleados (dni, nombre, apellidos, id_departamento) values ('123E', 'Steven', 'Fry', 5);