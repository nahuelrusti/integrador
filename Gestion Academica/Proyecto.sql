-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_academia
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `calificaciones`
--

DROP TABLE IF EXISTS `calificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calificaciones` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nota` int(11) NOT NULL,
  `id_estudiante` bigint(20) NOT NULL,
  `id_instructor` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9qhkbatbb5o5sfseo8egpx6tf` (`id_estudiante`),
  KEY `FKp1p0ilx5m5ir6bb39cwxv59yc` (`id_instructor`),
  CONSTRAINT `FK9qhkbatbb5o5sfseo8egpx6tf` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiantes` (`id`),
  CONSTRAINT `FKp1p0ilx5m5ir6bb39cwxv59yc` FOREIGN KEY (`id_instructor`) REFERENCES `instructores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificaciones`
--

LOCK TABLES `calificaciones` WRITE;
/*!40000 ALTER TABLE `calificaciones` DISABLE KEYS */;
INSERT INTO `calificaciones` VALUES (1,1,1,5),(2,10,3,6),(3,9,4,7),(4,7,5,8),(5,4,6,9),(6,5,7,10);
/*!40000 ALTER TABLE `calificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contactos`
--

DROP TABLE IF EXISTS `contactos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contactos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(255) NOT NULL,
  `codigo_postal` varchar(255) NOT NULL,
  `creacion` datetime(6) DEFAULT NULL,
  `direccion` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `modificacion` datetime(6) DEFAULT NULL,
  `provincia` varchar(255) NOT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `id_estudiante` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7op0rverl8y1jxb5yih81qcs0` (`id_estudiante`),
  CONSTRAINT `FKfv2jso2ct15nnr3d9jldh9bc8` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiantes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactos`
--

LOCK TABLES `contactos` WRITE;
/*!40000 ALTER TABLE `contactos` DISABLE KEYS */;
INSERT INTO `contactos` VALUES (1,'Quilmes','B1834','2023-10-27 13:54:08.000000','Valle Expél','email@gmail.com','2023-10-27 13:54:08.000000','Buenos Aires','1133344412',1),(2,'Almirante Brown','B8181','2023-10-27 13:59:08.000000','Tierra Quemada','vallemontero@gmail.com','2023-10-27 13:59:08.000000','Buenos Aires','113876212',3),(3,'Florencio Varela','B2014','2023-10-27 20:43:14.000000','Peninsula','pomelomayo@gmail.com','2023-10-27 20:43:14.000000','Buenos Aires','115488423',6),(8,'Ciudadela','C6532','2023-10-27 21:00:59.000000','Olivaro','catapultatirada@gmail.com','2023-10-27 21:00:59.000000','San Luis','1154879512',4),(11,'Clinton','R1562','2023-10-27 21:03:09.000000','Springfield','hernánpordi213@gmail.com','2023-10-27 21:03:09.000000','Tierra del Fuego','1133444401',7);
/*!40000 ALTER TABLE `contactos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creacion` datetime(6) DEFAULT NULL,
  `modificacion` datetime(6) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `id_instructor` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr0wij49ylgqr8nhbmyopm8kvk` (`id_instructor`),
  CONSTRAINT `FKr0wij49ylgqr8nhbmyopm8kvk` FOREIGN KEY (`id_instructor`) REFERENCES `instructores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'2023-10-27 13:37:25.000000','2023-10-27 13:37:25.000000','Java Programmer',NULL),(2,'2023-10-27 13:41:19.000000','2023-10-27 13:41:19.000000','Java Programmer',5),(3,'2023-10-27 13:50:03.000000','2023-10-27 13:50:03.000000','Cocina y Reposteria',5),(4,'2023-10-27 13:50:14.000000','2023-10-27 13:50:14.000000','Futbol',6),(5,'2023-10-27 13:50:35.000000','2023-10-27 13:50:35.000000','Python for VideoGames',7),(6,'2023-10-27 13:50:51.000000','2023-10-27 13:50:51.000000','Taller de Lectura y Escritura',8),(7,'2023-10-27 13:51:25.000000','2023-10-27 13:51:25.000000','Desarrollo de Spring',9),(8,'2023-10-27 13:51:43.000000','2023-10-27 13:51:43.000000','GitHub development',10);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiantes`
--

DROP TABLE IF EXISTS `estudiantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiantes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) NOT NULL,
  `creacion` datetime(6) DEFAULT NULL,
  `curso` varchar(255) NOT NULL,
  `dni` varchar(255) NOT NULL,
  `nacimiento` date NOT NULL,
  `modificacion` datetime(6) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiantes`
--

LOCK TABLES `estudiantes` WRITE;
/*!40000 ALTER TABLE `estudiantes` DISABLE KEYS */;
INSERT INTO `estudiantes` VALUES (1,'Dominguez','2023-10-27 13:19:07.000000','4c','48795421','2002-12-01','2023-10-27 13:19:07.000000','Penelope'),(3,'Felipez','2023-10-27 13:21:55.000000','5d','47503210','2004-10-15','2023-10-27 13:26:09.000000','Canciller'),(4,'Emiliano','2023-10-27 13:22:58.000000','6a','49502148','2002-11-22','2023-10-27 13:22:58.000000','Juan'),(5,'Raspón','2023-10-27 13:23:53.000000','6b','47810145','1999-11-22','2023-10-27 13:23:53.000000','Ciro'),(6,'Dalinguer','2023-10-27 13:24:35.000000','5d','48510235','1999-01-02','2023-10-27 13:24:35.000000','Owen'),(7,'Sanchez','2023-10-27 21:03:01.000000','9a','48510222','1998-10-22','2023-10-27 21:03:01.000000','David');
/*!40000 ALTER TABLE `estudiantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructores`
--

DROP TABLE IF EXISTS `instructores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructores` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) NOT NULL,
  `creacion` datetime(6) DEFAULT NULL,
  `modificacion` datetime(6) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructores`
--

LOCK TABLES `instructores` WRITE;
/*!40000 ALTER TABLE `instructores` DISABLE KEYS */;
INSERT INTO `instructores` VALUES (5,'Sosa','2023-10-27 13:37:57.000000','2023-10-27 13:37:57.000000','Martinez'),(6,'Cesar','2023-10-27 13:47:05.000000','2023-10-27 13:47:05.000000','Julio'),(7,'Roca','2023-10-27 13:47:15.000000','2023-10-27 13:47:15.000000','Martiniano'),(8,'Cerati','2023-10-27 13:47:25.000000','2023-10-27 13:47:25.000000','Gustavo'),(9,'Limón','2023-10-27 13:47:39.000000','2023-10-27 13:48:35.000000','Pomelo'),(10,'Tennyson','2023-10-27 13:47:53.000000','2023-10-27 13:47:53.000000','Ben');
/*!40000 ALTER TABLE `instructores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-27 21:29:37
