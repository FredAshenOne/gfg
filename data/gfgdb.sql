/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 10.1.33-MariaDB : Database - gfg
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
  CONSTRAINT `avales_ibfk_1` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes_personal` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `avales` */

insert  into `avales`(`id`,`id_Cliente`,`Nombre`,`Apellido_Paterno`,`Apellido_Materno`,`Direccion`,`Num_Exterior`,`Num_Interior`,`Colonia`,`Telefono`) values 
(7,33,'asd','asd','asd','asd','123','123','asd','123'),
(8,33,'123','123','123','123','123','123','123','123'),
(9,32,'zxc','asd','asd','qwe','qwe','qwe','qwe','qwe'),
(10,32,'qweqw','465','654','654','654','654','654654','654'),
(11,32,'qweqwe','498','49846','6548','84','984','684','847'),
(12,32,'asd','asdasdas','ads','asd','654','654','465','654'),
(13,32,'8708','9847','987','987','98','79','987','87'),
(14,32,'1271zxczxc','984849','849','849','984','984','84','984'),
(15,32,'gus','98409','8409','840','984','9840','9840','984'),
(16,32,'gustav','8490','9840','9840','9840','9840','9804','8740'),
(17,32,'chris','88409','098','098','090','980','098','980'),
(18,32,'qwewe','987','987','987','79','87','98','987');

/*Table structure for table `clientes_empleo` */

DROP TABLE IF EXISTS `clientes_empleo`;

CREATE TABLE `clientes_empleo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_Cliente` int(10) unsigned NOT NULL,
  `Descripcion` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Domicilio` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `Num_Exterior` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `Num_Interior` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Telefono` varchar(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Cliente` (`id_Cliente`),
  CONSTRAINT `clientes_empleo_ibfk_1` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes_personal` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `clientes_empleo` */

insert  into `clientes_empleo`(`id`,`id_Cliente`,`Descripcion`,`Domicilio`,`Num_Exterior`,`Num_Interior`,`Telefono`) values 
(1,33,'123','asd','123','123','123'),
(2,32,'123','qweqwe','132','123','123');

/*Table structure for table `clientes_grupo` */

DROP TABLE IF EXISTS `clientes_grupo`;

CREATE TABLE `clientes_grupo` (
  `id_Grupo` int(10) unsigned DEFAULT NULL,
  `id_Cliente` int(10) unsigned DEFAULT NULL,
  KEY `fk_clientesgrupo_grupo` (`id_Grupo`),
  KEY `fk_clientesgrupo_clientes` (`id_Cliente`),
  CONSTRAINT `fk_clientesgrupo_clientes` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes_personal` (`id`),
  CONSTRAINT `fk_clientesgrupo_grupo` FOREIGN KEY (`id_Grupo`) REFERENCES `grupos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `clientes_grupo` */

insert  into `clientes_grupo`(`id_Grupo`,`id_Cliente`) values 
(1,33);

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
  `Editado` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Tipo_Casa` (`Tipo_Casa`),
  KEY `fk_estado_civil` (`Estado_Civil`),
  KEY `fk_Editado_usuario` (`Editado`),
  CONSTRAINT `fk_Editado_usuario` FOREIGN KEY (`Editado`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `fk_Tipo_Casa` FOREIGN KEY (`Tipo_Casa`) REFERENCES `tipo_domicilio` (`id`),
  CONSTRAINT `fk_estado_civil` FOREIGN KEY (`Estado_Civil`) REFERENCES `estado_civil` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `clientes_personal` */

insert  into `clientes_personal`(`id`,`Nombre`,`Apellido_Paterno`,`Apellido_Materno`,`Telefono_Cel`,`Telefono_Fijo`,`Direccion`,`Num_Exterior`,`Num_Interior`,`Colonia`,`Fecha_Nacimiento`,`Tiempo_Residencia`,`Tipo_Casa`,`Estado_Civil`,`Ocupacion`,`Sueldo_Mensual`,`Editado`) values 
(32,'Alfredo','Lara','Meza','123','123','123','123','123','123','1194-05-12','12',1,1,'123',123,1),
(33,'fred','123','123','123','123123','123','123','123','123','1234-04-04','12',1,1,'123',123,1);

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
  KEY `Tipo_Credito` (`Tipo_Credito`),
  KEY `Status` (`Status`),
  CONSTRAINT `credito_ibfk_1` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes_personal` (`id`),
  CONSTRAINT `credito_ibfk_2` FOREIGN KEY (`Tipo_Credito`) REFERENCES `tipos_credito` (`id`),
  CONSTRAINT `credito_ibfk_3` FOREIGN KEY (`Status`) REFERENCES `status_pagos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `credito` */

insert  into `credito`(`id`,`id_Cliente`,`Cantidad_Inicial`,`Cantidad_Actual`,`Tipo_Credito`,`Fecha_inicio`,`Status`) values 
(20,33,7000,7000,1,'2018-07-10',1),
(21,33,8000,8000,1,'2018-07-09',1);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `grupos` */

insert  into `grupos`(`id`,`nombre`,`fecha_Creacion`) values 
(1,'PRUEBA','2018-07-09');

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

/*Table structure for table `tarjetones` */

DROP TABLE IF EXISTS `tarjetones`;

CREATE TABLE `tarjetones` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_Cliente` int(10) unsigned NOT NULL,
  `id_Credito` int(10) unsigned NOT NULL,
  `numero_Pago` tinyint(4) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha_Asignada` date NOT NULL,
  `status` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `fecha_Pago` date DEFAULT NULL,
  `observaciones` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tarjetones_credito` (`id_Credito`),
  KEY `fk_tarjetones_cliente` (`id_Cliente`),
  CONSTRAINT `fk_tarjetones_cliente` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes_personal` (`id`),
  CONSTRAINT `fk_tarjetones_credito` FOREIGN KEY (`id_Credito`) REFERENCES `credito` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

/*Data for the table `tarjetones` */

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `usuarios` */

insert  into `usuarios`(`id`,`Nombre`,`Apellido_Paterno`,`Apellido_Materno`,`usuario`,`contraseña`,`tipo_usuario`) values 
(1,'Alfredo','Lara','Meza','fred','123',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
