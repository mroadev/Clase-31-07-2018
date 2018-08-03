-- ***********************************************************************************
-- Ejemplo Mysql con Java
-- ***********************************************************************************

-- Crear la base de datos
DROP DATABASE `ventas`;
CREATE SCHEMA `ventas` DEFAULT CHARACTER SET utf8 ;
USE ventas;

-- Crear usuario base de datos
DROP USER 'usuventas'@'localhost';
CREATE USER 'usuventas'@'localhost' IDENTIFIED BY 'passventas';

-- Dar privilegios
grant usage on *.* to usuventas@localhost identified by 'passventas';
grant all privileges on ventas.* to usuventas@localhost;

-- Crear tabla usuario
DROP TABLE usuario;
CREATE TABLE usuario(
	idusuario INT NOT NULL AUTO_INCREMENT,
    usuario VARCHAR(50),
    clave VARCHAR(50),
    nombre VARCHAR(100),
    tipousuario VARCHAR(50),
    estado VARCHAR(1),
    PRIMARY KEY (idusuario)
);

-- insertar datos
INSERT INTO usuario (usuario, clave, nombre, tipousuario, estado) values
('admin','1234','Administrador','Alvaro Fuentes','V');

-- Permitir mysql operaciones update
SET SQL_SAFE_UPDATES = 0;
-- ***********************************************************************************


