CREATE SCHEMA bd_hibernate2 ;
use bd_hibernate2;

CREATE TABLE persona(
id_persona int(11) NOT NULL,
nombre_persona varchar(45) DEFAULT NULL,
profesion_persona varchar(45) DEFAULT NULL,
telefono_persona varchar(45) DEFAULT NULL,
tipo_persona int(2) NOT NULL,
nacimiento_id int(11) NOT NULL,
PRIMARY KEY (id_persona)
);

CREATE TABLE nacimiento(
id_nacimiento int(11) NOT NULL AUTO_INCREMENT ,
ciudad_nacimiento varchar(45) DEFAULT NULL,
departamento_nacimiento varchar(45) DEFAULT NULL,
fecha_nacimiento date DEFAULT NULL,
pais_nacimiento varchar(45) DEFAULT NULL,
PRIMARY KEY (id_nacimiento)
);

create table productos(
id_producto int(11) not null auto_increment,
nombre_producto VARCHAR (45) not null,
precio_producto DOUBLE default null,
primary key(id_producto)
)engine=InnoDB default charset=utf8mb4;

create table personas_productos(
persona_id int(11) not null,
producto_id int(11) not null,
key FK_producto(producto_id),
key  FK_persona(persona_id),
constraint FK_producto foreign key (producto_id) references productos (id_producto),
constraint FK_persona foreign key (persona_id) references persona (id_persona)
)engine=InnoDB default charset=utf8mb4;

ALTER TABLE persona ADD INDEX fk_persona_nacimiento (nacimiento_id ASC);
;
ALTER TABLE persona
ADD CONSTRAINT fk_persona_nacimiento
FOREIGN KEY (nacimiento_id)
REFERENCES nacimiento (id_nacimiento)
ON DELETE NO ACTION
ON UPDATE NO ACTION;