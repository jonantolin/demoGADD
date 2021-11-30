CREATE DATABASE  IF NOT EXISTS `tus_eventos` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tus_eventos`;

--

DROP TABLE IF EXISTS `eventos`;
CREATE TABLE `eventos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(125) NOT NULL,
  `lugar` varchar(125) NOT NULL,
  `fecha` datetime NOT NULL,
  `precio` decimal(6,2) NOT NULL,
  `disponibles` int NOT NULL,
  `vendidas` int NOT NULL,
  `aforo` int NOT NULL,
  `img_portada` varchar(125) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

LOCK TABLES `eventos` WRITE;
INSERT INTO `eventos` VALUES (1,'Concierto Joaquin Sabina','Estadio Carlos Tartiere (Oviedo)','2021-12-01 22:00:00',60.00,8000,2000,10000,'sabina.jpg'),(2,'Teatro: Los que hablan','Teatro Palacio Valdés (Avilés)','2021-12-04 19:00:00',85.00,100,300,400,'loshablan.jpg'),(3,'Final Roland Garros','Estadio París (París)','2022-03-24 16:00:00',120.00,198,1602,1800,'tenis.jpg');

UNLOCK TABLES;



DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;


LOCK TABLES `usuarios` WRITE;

INSERT INTO `usuarios` VALUES (1,'admin','admin');

UNLOCK TABLES;