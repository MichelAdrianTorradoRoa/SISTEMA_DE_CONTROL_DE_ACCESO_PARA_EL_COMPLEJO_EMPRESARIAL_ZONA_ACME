-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: acme
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `logestado`
--

DROP TABLE IF EXISTS `logestado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logestado` (
  `idLogEstado` int NOT NULL AUTO_INCREMENT,
  `Asunto` text NOT NULL,
  `Fecha` date NOT NULL,
  `Descripcion` text NOT NULL,
  `Persona_idPersona` int NOT NULL,
  PRIMARY KEY (`idLogEstado`,`Persona_idPersona`),
  UNIQUE KEY `idLogEstado_UNIQUE` (`idLogEstado`),
  KEY `fk_LogEstado_Persona1_idx` (`Persona_idPersona`),
  CONSTRAINT `fk_LogEstado_Persona1` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logestado`
--

LOCK TABLES `logestado` WRITE;
/*!40000 ALTER TABLE `logestado` DISABLE KEYS */;
INSERT INTO `logestado` VALUES (1,'Cambio a estado inactivo','2024-12-01','El estado de la persona ha cambiado a inactivo después de una revisión de los vehículos en el parqueadero.',1),(2,'Cambio a estado activo','2024-12-02','La persona ha sido activada nuevamente tras la revisión de los incidentes.',2),(3,'Cambio a estado activo','2024-12-03','La persona ha sido activada después de la revisión de maquinaria y vehículos.',3),(4,'Cambio a estado inactivo','2024-12-04','Persona ha sido inactivada luego del informe de seguridad de las instalaciones.',4),(5,'Cambio a estado inactivo','2024-12-05','Auditoría de seguridad, persona pasa a estado inactivo temporalmente.',5),(6,'Cambio a estado activo','2024-12-06','La persona ha sido activada después de la inspección de daños en vehículos accidentados.',6),(7,'Cambio a estado activo','2024-12-07','La persona ha sido activada después del reporte de materiales robados.',7),(8,'Cambio a estado inactivo','2024-12-08','Persona ha pasado a inactivo tras la revisión de cámaras de seguridad.',8),(9,'Cambio a estado activo','2024-12-09','Persona reactivada después de la evaluación del área de trabajo.',9),(10,'Cambio a estado inactivo','2024-12-10','Persona ha sido inactivada después del seguimiento de los incidentes reportados.',10);
/*!40000 ALTER TABLE `logestado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-15 21:02:44
