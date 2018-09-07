/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 10.1.34-MariaDB : Database - gfg
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gfg` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;

USE `gfg`;

/*Table structure for table `avales` */

DROP TABLE IF EXISTS `avales`;

CREATE TABLE `avales` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_Solicitud` int(10) unsigned NOT NULL,
  `Nombre` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `Apellido_Paterno` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `Apellido_Materno` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Direccion` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `Num_Exterior` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `Num_Interior` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Colonia` varchar(70) COLLATE utf8_spanish_ci NOT NULL,
  `Telefono` varchar(12) COLLATE utf8_spanish_ci NOT NULL,
  `Ocupacion` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `id_Cliente` (`id_Solicitud`),
  KEY `status` (`status`),
  CONSTRAINT `avales_ibfk_2` FOREIGN KEY (`status`) REFERENCES `status_personas` (`id`) ON DELETE CASCADE,
  CONSTRAINT `avales_ibfk_4` FOREIGN KEY (`id_Solicitud`) REFERENCES `solicitudes_personales` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `avales` */

insert  into `avales`(`id`,`id_Solicitud`,`Nombre`,`Apellido_Paterno`,`Apellido_Materno`,`Direccion`,`Num_Exterior`,`Num_Interior`,`Colonia`,`Telefono`,`Ocupacion`,`status`) values 
(4,10,'654','654','654','654','654','646','54','654','654',1),
(5,11,'fred','pruebas','987','987','987','98','79','87','987',1);

/*Table structure for table `clientes_empleo` */

DROP TABLE IF EXISTS `clientes_empleo`;

CREATE TABLE `clientes_empleo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_Cliente` int(10) unsigned NOT NULL,
  `Domicilio` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `Num_Exterior` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `Num_Interior` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Telefono` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tiempo` int(10) unsigned DEFAULT NULL,
  `Descripcion` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Cliente` (`id_Cliente`),
  CONSTRAINT `clientes_empleo_ibfk_1` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes_personal` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `clientes_empleo` */

insert  into `clientes_empleo`(`id`,`id_Cliente`,`Domicilio`,`Num_Exterior`,`Num_Interior`,`Telefono`,`tiempo`,`Descripcion`) values 
(6,47,'3','2132','1','321',32132,'321');

/*Table structure for table `clientes_grupo` */

DROP TABLE IF EXISTS `clientes_grupo`;

CREATE TABLE `clientes_grupo` (
  `id_Grupo` int(10) unsigned DEFAULT NULL,
  `id_Cliente` int(10) unsigned DEFAULT NULL,
  KEY `fk_clientesgrupo_clientes` (`id_Cliente`),
  KEY `fk_clientesgrupo_grupo` (`id_Grupo`),
  CONSTRAINT `fk_clientesgrupo_clientes` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes_personal` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_clientesgrupo_grupo` FOREIGN KEY (`id_Grupo`) REFERENCES `grupos` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `clientes_grupo` */

insert  into `clientes_grupo`(`id_Grupo`,`id_Cliente`) values 
(25,47);

/*Table structure for table `clientes_personal` */

DROP TABLE IF EXISTS `clientes_personal`;

CREATE TABLE `clientes_personal` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `Paterno` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `Materno` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `Telefono_Cel` varchar(12) COLLATE utf8_spanish_ci NOT NULL,
  `Telefono_Fijo` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Direccion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `Num_Exterior` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `Num_Interior` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ciudad` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Colonia` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `Fecha_Nacimiento` date NOT NULL,
  `Tiempo_Residencia` varchar(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Tipo_Casa` tinyint(1) unsigned NOT NULL,
  `Estado_Civil` tinyint(1) unsigned NOT NULL,
  `Ocupacion` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `Sueldo_Mensual` int(11) NOT NULL,
  `status` tinyint(3) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_Tipo_Casa` (`Tipo_Casa`),
  KEY `fk_estado_civil` (`Estado_Civil`),
  KEY `status` (`status`),
  CONSTRAINT `clientes_personal_ibfk_1` FOREIGN KEY (`status`) REFERENCES `status_personas` (`id`),
  CONSTRAINT `fk_Tipo_Casa` FOREIGN KEY (`Tipo_Casa`) REFERENCES `tipo_domicilio` (`id`),
  CONSTRAINT `fk_estado_civil` FOREIGN KEY (`Estado_Civil`) REFERENCES `estado_civil` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `clientes_personal` */

insert  into `clientes_personal`(`id`,`Nombre`,`Paterno`,`Materno`,`Telefono_Cel`,`Telefono_Fijo`,`Direccion`,`Num_Exterior`,`Num_Interior`,`ciudad`,`Colonia`,`Fecha_Nacimiento`,`Tiempo_Residencia`,`Tipo_Casa`,`Estado_Civil`,`Ocupacion`,`Sueldo_Mensual`,`status`) values 
(47,'asd','321','321','21','321','321','321','321','ask','132','2018-05-05','21',1,1,'321',3,1);

/*Table structure for table `credito_grupal` */

DROP TABLE IF EXISTS `credito_grupal`;

CREATE TABLE `credito_grupal` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Folio` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_Grupo` int(10) unsigned NOT NULL,
  `cantidad_Inicial` int(10) unsigned NOT NULL,
  `tipo_Credito` tinyint(3) unsigned NOT NULL,
  `capital` int(11) DEFAULT NULL,
  `intereses` float DEFAULT NULL,
  `Total` int(11) DEFAULT NULL,
  `fecha_Inicio` date NOT NULL,
  `tipo_interes` tinyint(3) unsigned DEFAULT NULL,
  `status` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Grupo` (`id_Grupo`),
  KEY `tipo_Credito` (`tipo_Credito`),
  KEY `status` (`status`),
  KEY `interes` (`tipo_interes`),
  CONSTRAINT `credito_grupal_ibfk_1` FOREIGN KEY (`id_Grupo`) REFERENCES `grupos` (`id`),
  CONSTRAINT `credito_grupal_ibfk_2` FOREIGN KEY (`tipo_Credito`) REFERENCES `tipos_credito` (`id`),
  CONSTRAINT `credito_grupal_ibfk_3` FOREIGN KEY (`status`) REFERENCES `status_credito` (`id`),
  CONSTRAINT `credito_grupal_ibfk_4` FOREIGN KEY (`tipo_interes`) REFERENCES `tipos_interes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `credito_grupal` */

insert  into `credito_grupal`(`id`,`Folio`,`id_Grupo`,`cantidad_Inicial`,`tipo_Credito`,`capital`,`intereses`,`Total`,`fecha_Inicio`,`tipo_interes`,`status`) values 
(9,'g9',23,50000,2,50000,0,0,'2018-07-23',5,6),
(10,'g10',18,8000,3,8000,800,8800,'2018-07-25',4,1),
(11,'g11',23,8000,2,8000,0,0,'2018-05-05',5,1),
(12,NULL,21,80000,2,80000,0,0,'2018-08-08',5,1);

/*Table structure for table `credito_personal` */

DROP TABLE IF EXISTS `credito_personal`;

CREATE TABLE `credito_personal` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_Cliente` int(10) unsigned NOT NULL,
  `Folio` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Cantidad_Inicial` int(10) unsigned NOT NULL,
  `Tipo_Credito` tinyint(1) unsigned NOT NULL,
  `Fecha_inicio` date NOT NULL,
  `Capital` int(11) NOT NULL,
  `intereses` float DEFAULT NULL,
  `Total` int(11) DEFAULT NULL,
  `tipo_interes` tinyint(3) unsigned DEFAULT NULL,
  `Status` tinyint(1) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Cliente` (`id_Cliente`),
  KEY `Tipo_Credito` (`Tipo_Credito`),
  KEY `Status` (`Status`),
  KEY `credito_personal_ibfk_4` (`tipo_interes`),
  CONSTRAINT `credito_personal_ibfk_1` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes_personal` (`id`) ON DELETE CASCADE,
  CONSTRAINT `credito_personal_ibfk_2` FOREIGN KEY (`Tipo_Credito`) REFERENCES `tipos_credito` (`id`) ON DELETE CASCADE,
  CONSTRAINT `credito_personal_ibfk_3` FOREIGN KEY (`Status`) REFERENCES `status_credito` (`id`) ON DELETE CASCADE,
  CONSTRAINT `credito_personal_ibfk_4` FOREIGN KEY (`tipo_interes`) REFERENCES `tipos_interes` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `credito_personal` */

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

/*Table structure for table `grupos` */

DROP TABLE IF EXISTS `grupos`;

CREATE TABLE `grupos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_Creacion` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `grupos` */

insert  into `grupos`(`id`,`nombre`,`fecha_Creacion`) values 
(18,'alfred','2018-07-11'),
(21,'vanguardia','2018-07-11'),
(22,'fredo','2018-07-11'),
(23,'grupo1','2018-07-18'),
(24,'codemasters','2018-07-23'),
(25,'asd','2018-08-09');

/*Table structure for table `intereses_mensuales_grupal` */

DROP TABLE IF EXISTS `intereses_mensuales_grupal`;

CREATE TABLE `intereses_mensuales_grupal` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_credito` int(10) unsigned NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `intereses_mensuales_grupal_ibfk_1` (`id_credito`),
  CONSTRAINT `intereses_mensuales_grupal_ibfk_1` FOREIGN KEY (`id_credito`) REFERENCES `credito_grupal` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `intereses_mensuales_grupal` */

insert  into `intereses_mensuales_grupal`(`id`,`id_credito`,`cantidad`,`fecha`) values 
(9,9,0,'2018-07-23'),
(10,10,800,'2018-07-25'),
(11,11,0,'2018-05-05'),
(12,12,0,'2018-08-08');

/*Table structure for table `intereses_mensuales_personal` */

DROP TABLE IF EXISTS `intereses_mensuales_personal`;

CREATE TABLE `intereses_mensuales_personal` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_credito` int(10) unsigned NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `intereses_mensuales_personal_ibfk_1` (`id_credito`),
  CONSTRAINT `intereses_mensuales_personal_ibfk_1` FOREIGN KEY (`id_credito`) REFERENCES `credito_personal` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `intereses_mensuales_personal` */

/*Table structure for table `pagos_grupal` */

DROP TABLE IF EXISTS `pagos_grupal`;

CREATE TABLE `pagos_grupal` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_credito_grupal` int(10) unsigned NOT NULL,
  `cantidad` int(11) NOT NULL,
  `intereses` int(11) NOT NULL,
  `capital` int(11) NOT NULL,
  `fecha_pago` date NOT NULL,
  `observaciones` text COLLATE utf8_spanish_ci,
  PRIMARY KEY (`id`),
  KEY `pagos_grupal_ibfk_1` (`id_credito_grupal`),
  CONSTRAINT `pagos_grupal_ibfk_1` FOREIGN KEY (`id_credito_grupal`) REFERENCES `credito_grupal` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `pagos_grupal` */

/*Table structure for table `pagos_personal` */

DROP TABLE IF EXISTS `pagos_personal`;

CREATE TABLE `pagos_personal` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_credito_personal` int(10) unsigned NOT NULL,
  `cantidad` int(11) NOT NULL,
  `intereses` int(11) NOT NULL,
  `capital` int(11) NOT NULL,
  `fecha_Pago` date DEFAULT NULL,
  `observaciones` text COLLATE utf8_spanish_ci,
  PRIMARY KEY (`id`),
  KEY `pagos_personal_ibfk_1` (`id_credito_personal`),
  CONSTRAINT `pagos_personal_ibfk_1` FOREIGN KEY (`id_credito_personal`) REFERENCES `credito_personal` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `pagos_personal` */

/*Table structure for table `referencias` */

DROP TABLE IF EXISTS `referencias`;

CREATE TABLE `referencias` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_Solicitud` int(10) unsigned DEFAULT NULL,
  `id_Cliente` int(10) unsigned DEFAULT NULL,
  `Nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Paterno` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Materno` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Domicilio` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Exterior` varchar(6) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Interior` varchar(6) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Telefono` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Solicitud` (`id_Solicitud`),
  KEY `id_Cliente` (`id_Cliente`),
  CONSTRAINT `referencias_ibfk_1` FOREIGN KEY (`id_Solicitud`) REFERENCES `solicitudes_personales` (`id`) ON DELETE CASCADE,
  CONSTRAINT `referencias_ibfk_2` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes_personal` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `referencias` */

insert  into `referencias`(`id`,`id_Solicitud`,`id_Cliente`,`Nombre`,`Paterno`,`Materno`,`Domicilio`,`Exterior`,`Interior`,`Telefono`) values 
(19,10,47,'1','312312','321','312','321','32','1'),
(20,10,47,'32132','1','321','321','321','321','32'),
(35,11,47,'654','65','4654','646','54','654','654'),
(36,11,47,'654','654','64','654','6546','54','654');

/*Table structure for table `solicitudes_personales` */

DROP TABLE IF EXISTS `solicitudes_personales`;

CREATE TABLE `solicitudes_personales` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_Cliente` int(10) unsigned DEFAULT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  `tipo_credito` tinyint(3) unsigned DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `status` tinyint(1) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Cliente` (`id_Cliente`),
  CONSTRAINT `solicitudes_personales_ibfk_1` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes_personal` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `solicitudes_personales` */

insert  into `solicitudes_personales`(`id`,`id_Cliente`,`Cantidad`,`tipo_credito`,`fecha`,`status`) values 
(10,47,321,1,NULL,0),
(11,47,9000,1,'2018-08-09',0);

/*Table structure for table `status_credito` */

DROP TABLE IF EXISTS `status_credito`;

CREATE TABLE `status_credito` (
  `id` tinyint(1) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `status_credito` */

insert  into `status_credito`(`id`,`Descripcion`) values 
(1,'Activo'),
(2,'Atrasado'),
(3,'Terminado'),
(4,'Por Cobrar'),
(5,'Cancelado'),
(6,'Renovado');

/*Table structure for table `status_pagos` */

DROP TABLE IF EXISTS `status_pagos`;

CREATE TABLE `status_pagos` (
  `id` tinyint(1) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `status_pagos` */

insert  into `status_pagos`(`id`,`Descripcion`) values 
(1,'Pagado'),
(2,'Por Pagar'),
(3,'renovado');

/*Table structure for table `status_personas` */

DROP TABLE IF EXISTS `status_personas`;

CREATE TABLE `status_personas` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `status_personas` */

insert  into `status_personas`(`id`,`Descripcion`) values 
(1,'Activo'),
(2,'No Activo');

/*Table structure for table `status_solicitudes` */

DROP TABLE IF EXISTS `status_solicitudes`;

CREATE TABLE `status_solicitudes` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `status_solicitudes` */

insert  into `status_solicitudes`(`id`,`descripcion`) values 
(1,'Pendiente'),
(2,'Aprobada'),
(3,'Cancelada');

/*Table structure for table `tarjeton_grupal` */

DROP TABLE IF EXISTS `tarjeton_grupal`;

CREATE TABLE `tarjeton_grupal` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_Grupo` int(10) unsigned NOT NULL,
  `id_Credito` int(10) unsigned NOT NULL,
  `fecha_Asignada` date DEFAULT NULL,
  `cantidad` int(11) NOT NULL,
  `numero_Pago` tinyint(4) NOT NULL,
  `fecha_Pago` date DEFAULT NULL,
  `status` tinyint(3) unsigned NOT NULL,
  `Observaciones` text COLLATE utf8_spanish_ci,
  PRIMARY KEY (`id`),
  KEY `status` (`status`),
  KEY `tarjeton_grupal_ibfk_1` (`id_Grupo`),
  KEY `tarjeton_grupal_ibfk_2` (`id_Credito`),
  CONSTRAINT `tarjeton_grupal_ibfk_1` FOREIGN KEY (`id_Grupo`) REFERENCES `grupos` (`id`),
  CONSTRAINT `tarjeton_grupal_ibfk_2` FOREIGN KEY (`id_Credito`) REFERENCES `credito_grupal` (`id`) ON DELETE CASCADE,
  CONSTRAINT `tarjeton_grupal_ibfk_3` FOREIGN KEY (`status`) REFERENCES `status_pagos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `tarjeton_grupal` */

insert  into `tarjeton_grupal`(`id`,`id_Grupo`,`id_Credito`,`fecha_Asignada`,`cantidad`,`numero_Pago`,`fecha_Pago`,`status`,`Observaciones`) values 
(16,23,9,'2018-07-30',5000,1,NULL,3,NULL),
(17,23,9,'2018-08-06',5000,2,NULL,3,NULL),
(18,23,9,'2018-08-13',5000,3,NULL,3,NULL),
(19,23,9,'2018-08-20',5000,4,NULL,3,NULL),
(20,23,9,'2018-08-27',5000,5,NULL,3,NULL),
(21,23,9,'2018-09-03',5000,6,NULL,3,NULL),
(22,23,9,'2018-09-10',5000,7,NULL,3,NULL),
(23,23,9,'2018-09-17',5000,8,NULL,3,NULL),
(24,23,9,'2018-09-24',5000,9,NULL,3,NULL),
(25,23,9,'2018-10-01',5000,10,NULL,3,NULL),
(26,23,9,'2018-10-08',5000,11,NULL,3,NULL),
(27,23,9,'2018-10-15',5000,12,NULL,3,NULL),
(28,23,9,'2018-10-22',5000,13,NULL,3,NULL),
(29,23,9,'2018-10-29',5000,14,NULL,3,NULL),
(30,23,11,'2018-05-12',800,1,NULL,2,NULL),
(31,23,11,'2018-05-19',800,2,NULL,2,NULL),
(32,23,11,'2018-05-26',800,3,NULL,2,NULL),
(33,23,11,'2018-06-02',800,4,NULL,2,NULL),
(34,23,11,'2018-06-09',800,5,NULL,2,NULL),
(35,23,11,'2018-06-16',800,6,NULL,2,NULL),
(36,23,11,'2018-06-23',800,7,NULL,2,NULL),
(37,23,11,'2018-06-30',800,8,NULL,2,NULL),
(38,23,11,'2018-07-07',800,9,NULL,2,NULL),
(39,23,11,'2018-07-14',800,10,NULL,2,NULL),
(40,23,11,'2018-07-21',800,11,NULL,2,NULL),
(41,23,11,'2018-07-28',800,12,NULL,2,NULL),
(42,23,11,'2018-08-04',800,13,NULL,2,NULL),
(43,23,11,'2018-08-11',800,14,NULL,2,NULL),
(44,21,12,'2018-08-15',8000,1,NULL,2,NULL),
(45,21,12,'2018-08-22',8000,2,NULL,2,NULL),
(46,21,12,'2018-08-29',8000,3,NULL,2,NULL),
(47,21,12,'2018-09-05',8000,4,NULL,2,NULL),
(48,21,12,'2018-09-12',8000,5,NULL,2,NULL),
(49,21,12,'2018-09-19',8000,6,NULL,2,NULL),
(50,21,12,'2018-09-26',8000,7,NULL,2,NULL),
(51,21,12,'2018-10-03',8000,8,NULL,2,NULL),
(52,21,12,'2018-10-10',8000,9,NULL,2,NULL),
(53,21,12,'2018-10-17',8000,10,NULL,2,NULL),
(54,21,12,'2018-10-24',8000,11,NULL,2,NULL),
(55,21,12,'2018-10-31',8000,12,NULL,2,NULL),
(56,21,12,'2018-11-07',8000,13,NULL,2,NULL),
(57,21,12,'2018-11-14',8000,14,NULL,2,NULL),
(58,23,9,'2018-11-05',5000,15,NULL,2,'qwe'),
(59,21,12,'2018-11-21',8000,15,NULL,2,'este ');

/*Table structure for table `tarjeton_personal` */

DROP TABLE IF EXISTS `tarjeton_personal`;

CREATE TABLE `tarjeton_personal` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_Cliente` int(10) unsigned NOT NULL,
  `id_Credito` int(10) unsigned NOT NULL,
  `numero_Pago` tinyint(4) NOT NULL,
  `fecha_Asignada` date NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha_Pago` date DEFAULT NULL,
  `status` tinyint(3) unsigned NOT NULL,
  `observaciones` text COLLATE utf8_spanish2_ci,
  PRIMARY KEY (`id`),
  KEY `fk_tarjetones_credito` (`id_Credito`),
  KEY `fk_tarjetones_cliente` (`id_Cliente`),
  KEY `status` (`status`),
  CONSTRAINT `fk_tarjetones_cliente` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes_personal` (`id`),
  CONSTRAINT `fk_tarjetones_credito` FOREIGN KEY (`id_Credito`) REFERENCES `credito_personal` (`id`) ON DELETE CASCADE,
  CONSTRAINT `tarjeton_personal_ibfk_1` FOREIGN KEY (`status`) REFERENCES `status_pagos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

/*Data for the table `tarjeton_personal` */

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

/*Table structure for table `tipos_interes` */

DROP TABLE IF EXISTS `tipos_interes`;

CREATE TABLE `tipos_interes` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `tipos_interes` */

insert  into `tipos_interes`(`id`,`descripcion`) values 
(1,7),
(2,8),
(3,9),
(4,10),
(5,0);

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `usuarios` */

insert  into `usuarios`(`id`,`Nombre`,`Apellido_Paterno`,`Apellido_Materno`,`usuario`,`contraseña`,`tipo_usuario`) values 
(1,'Alfredo','Lara','Meza','fred','123',1),
(2,'Alfredo','Lara','Meza','fred','321',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
