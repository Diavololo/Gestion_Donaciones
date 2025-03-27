-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.24-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para gestion_donaciones_bd
CREATE DATABASE IF NOT EXISTS `gestion_donaciones_bd` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `gestion_donaciones_bd`;

-- Volcando estructura para tabla gestion_donaciones_bd.campaña
CREATE TABLE IF NOT EXISTS `campaña` (
  `ID_Campaña` bigint(20) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Fecha_Inicio` date NOT NULL,
  `Fecha_Fin` date NOT NULL,
  `ID_Organizacion` bigint(20) NOT NULL,
  PRIMARY KEY (`ID_Campaña`),
  KEY `FK__Org_Camp` (`ID_Organizacion`),
  CONSTRAINT `FK__Org_Camp` FOREIGN KEY (`ID_Organizacion`) REFERENCES `organizacion` (`ID_Organizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla gestion_donaciones_bd.donacion
CREATE TABLE IF NOT EXISTS `donacion` (
  `ID_Donacion` bigint(20) NOT NULL,
  `Monto` bigint(20) NOT NULL,
  `Fecha` date NOT NULL,
  `Metodo_Pago` varchar(50) NOT NULL,
  `ID_Usuario` bigint(20) NOT NULL,
  `ID_Organizacion` bigint(20) NOT NULL,
  PRIMARY KEY (`ID_Donacion`),
  KEY `FK__Org_Don` (`ID_Organizacion`),
  KEY `FK__Us_Don` (`ID_Usuario`),
  CONSTRAINT `FK__Org_Don` FOREIGN KEY (`ID_Organizacion`) REFERENCES `organizacion` (`ID_Organizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK__Us_Don` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuario` (`ID_Usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla gestion_donaciones_bd.meta
CREATE TABLE IF NOT EXISTS `meta` (
  `ID_Meta` bigint(20) NOT NULL AUTO_INCREMENT,
  `Meta_Propuesta` bigint(20) NOT NULL DEFAULT 0,
  `Monto_Acomulado` bigint(20) NOT NULL DEFAULT 0,
  `ID_Campaña` bigint(20) NOT NULL,
  PRIMARY KEY (`ID_Meta`),
  KEY `FK__campaña` (`ID_Campaña`),
  CONSTRAINT `FK__campaña` FOREIGN KEY (`ID_Campaña`) REFERENCES `campaña` (`ID_Campaña`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla gestion_donaciones_bd.organizacion
CREATE TABLE IF NOT EXISTS `organizacion` (
  `ID_Organizacion` bigint(20) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Contacto` varchar(150) NOT NULL,
  PRIMARY KEY (`ID_Organizacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla gestion_donaciones_bd.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `ID_Usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `Correo` varchar(50) NOT NULL,
  `Contraseña` varchar(50) NOT NULL,
  `Tipo de Usuario` varchar(50) NOT NULL DEFAULT 'donante',
  PRIMARY KEY (`ID_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- La exportación de datos fue deseleccionada.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
