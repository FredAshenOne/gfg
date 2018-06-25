/*
SQLyog Community v13.0.0 (64 bit)
MySQL - 10.1.30-MariaDB : Database - gfg
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gfg` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `gfg`;

/*Table structure for table `abonos` */

DROP TABLE IF EXISTS `abonos`;

CREATE TABLE `abonos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_Credito` int(10) unsigned NOT NULL,
  `id_Cliente` int(10) unsigned NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `id_Cargo` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Credito` (`id_Credito`),
  KEY `id_Cliente` (`id_Cliente`),
  KEY `id_Cargo` (`id_Cargo`),
  CONSTRAINT `abonos_ibfk_1` FOREIGN KEY (`id_Credito`) REFERENCES `credito` (`id`),
  CONSTRAINT `abonos_ibfk_2` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes_personal` (`id`),
  CONSTRAINT `abonos_ibfk_3` FOREIGN KEY (`id_Cargo`) REFERENCES `cargos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `abonos` */

/*Table structure for table `avales` */

DROP TABLE IF EXISTS `avales`;

CREATE TABLE `avales` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_Cliente` int(10) unsigned NOT NULL,
  `Nombre` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `Apellido_Paterno` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `Apellido_Materno` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Direccion` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `Num_Exterior` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `Num_Interior` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Colonia` varchar(70) COLLATE utf8_spanish_ci NOT NULL,
  `Telefono` varchar(12) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Cliente` (`id_Cliente`),
  CONSTRAINT `avales_ibfk_1` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes_personal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `avales` */

/*Table structure for table `cargos` */

DROP TABLE IF EXISTS `cargos`;

CREATE TABLE `cargos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_Credito` int(10) unsigned NOT NULL,
  `id_Cliente` int(10) unsigned NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Credito` (`id_Credito`),
  KEY `id_Cliente` (`id_Cliente`),
  CONSTRAINT `cargos_ibfk_1` FOREIGN KEY (`id_Credito`) REFERENCES `credito` (`id`),
  CONSTRAINT `cargos_ibfk_2` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes_personal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `cargos` */

/*Table structure for table `clientes_empleo` */

DROP TABLE IF EXISTS `clientes_empleo`;

CREATE TABLE `clientes_empleo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_Cliente` int(10) unsigned NOT NULL,
  `Num_Exterior` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `Domicilio` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `Num_Interior` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Telefono` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Cliente` (`id_Cliente`),
  CONSTRAINT `clientes_empleo_ibfk_1` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes_personal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `clientes_empleo` */

/*Table structure for table `clientes_personal` */

DROP TABLE IF EXISTS `clientes_personal`;

CREATE TABLE `clientes_personal` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `Apellido_Paterno` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `Apellido_Materno` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `Telefono_Cel` varchar(12) COLLATE utf8_spanish_ci NOT NULL,
  `Telefono_Fijo` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Direccion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `Num_Exterior` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `Num_Interior` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Colonia` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `Fecha_Nacimiento` date NOT NULL,
  `Tiempo_Residencia` varchar(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Tipo_Casa` tinyint(1) unsigned NOT NULL,
  `Estado_Civil` tinyint(1) unsigned NOT NULL,
  `Ocupacion` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `Sueldo_Mensual` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Tipo_Casa` (`Tipo_Casa`),
  KEY `fk_estado_civil` (`Estado_Civil`),
  CONSTRAINT `fk_Tipo_Casa` FOREIGN KEY (`Tipo_Casa`) REFERENCES `tipo_domicilio` (`id`),
  CONSTRAINT `fk_estado_civil` FOREIGN KEY (`Estado_Civil`) REFERENCES `estado_civil` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `clientes_personal` */

insert  into `clientes_personal`(`id`,`Nombre`,`Apellido_Paterno`,`Apellido_Materno`,`Telefono_Cel`,`Telefono_Fijo`,`Direccion`,`Num_Exterior`,`Num_Interior`,`Colonia`,`Fecha_Nacimiento`,`Tiempo_Residencia`,`Tipo_Casa`,`Estado_Civil`,`Ocupacion`,`Sueldo_Mensual`) values 
(1,'Alfredo','Lara','Meza','3315176137','3123123','Puerto Melaque','1523','','el mirador','1994-05-12','24',1,1,' ingeniero',5000),
(2,'Alfredo','Lara','Meza','123','123','1123','123','123','123','1994-05-12','24',1,1,'123',123),
(3,'Fred','Lara','Meza','123','123','Puerto Melaque','1523','12','asdas','1994-05-12','as',1,1,'123',123);

/*Table structure for table `credito` */

DROP TABLE IF EXISTS `credito`;

CREATE TABLE `credito` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_Cliente` int(10) unsigned NOT NULL,
  `Cantidad_Inicial` int(10) unsigned NOT NULL,
  `Cantidad_Actual` int(11) NOT NULL,
  `Tipo_Credito` tinyint(1) unsigned NOT NULL,
  `Fecha_inicio` date NOT NULL,
  `Status` tinyint(1) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Cliente` (`id_Cliente`),
  CONSTRAINT `credito_ibfk_1` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes_personal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `credito` */

/*Table structure for table `estado_civil` */

DROP TABLE IF EXISTS `estado_civil`;

CREATE TABLE `estado_civil` (
  `id` tinyint(1) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `estado_civil` */

insert  into `estado_civil`(`id`,`Descripcion`) values 
(1,'Soltero'),
(2,'Casado'),
(3,'Viudo'),
(4,'Divorciado'),
(5,'Union Libre'),
(6,'Otro');

/*Table structure for table `status_credito` */

DROP TABLE IF EXISTS `status_credito`;

CREATE TABLE `status_credito` (
  `id` tinyint(1) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `status_credito` */

insert  into `status_credito`(`id`,`Descripcion`) values 
(1,'Activo'),
(2,'Atrasado'),
(3,'Terminado'),
(4,'Por Cobrar'),
(5,'Cancelado');

/*Table structure for table `status_pagos` */

DROP TABLE IF EXISTS `status_pagos`;

CREATE TABLE `status_pagos` (
  `id` tinyint(1) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `status_pagos` */

insert  into `status_pagos`(`id`,`Descripcion`) values 
(1,'Pagado'),
(2,'Por Pagar');

/*Table structure for table `tipo_domicilio` */

DROP TABLE IF EXISTS `tipo_domicilio`;

CREATE TABLE `tipo_domicilio` (
  `id` tinyint(1) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `tipo_domicilio` */

insert  into `tipo_domicilio`(`id`,`Descripcion`) values 
(1,'Propia'),
(2,'Familiar'),
(3,'Rentada'),
(4,'Hipotecada'),
(5,'Otra');

/*Table structure for table `tipos_credito` */

DROP TABLE IF EXISTS `tipos_credito`;

CREATE TABLE `tipos_credito` (
  `id` tinyint(1) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `tipos_credito` */

insert  into `tipos_credito`(`id`,`Descripcion`) values 
(1,'13 Semanas'),
(2,'14 Semanas'),
(3,'Interes Mensual');

/*Table structure for table `tipos_usuarios` */

DROP TABLE IF EXISTS `tipos_usuarios`;

CREATE TABLE `tipos_usuarios` (
  `id` tinyint(1) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `tipos_usuarios` */

insert  into `tipos_usuarios`(`id`,`descripcion`) values 
(1,'Administrador'),
(2,'cliente');

/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `Apellido_Paterno` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `Apellido_Materno` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `usuario` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `contraseña` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `tipo_usuario` tinyint(1) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tipo_usuario` (`tipo_usuario`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`tipo_usuario`) REFERENCES `tipos_usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `usuarios` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
