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
-- Table structure for table `control_acceso`
--

DROP TABLE IF EXISTS `control_acceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `control_acceso` (
  `idControl_Acceso` int NOT NULL AUTO_INCREMENT,
  `Fecha_Ingreso` datetime NOT NULL,
  `Fecha_Salida` datetime NOT NULL,
  `Usuario_idUsuario` int NOT NULL,
  PRIMARY KEY (`idControl_Acceso`,`Usuario_idUsuario`),
  UNIQUE KEY `idControl_Acceso_UNIQUE` (`idControl_Acceso`),
  KEY `fk_ControlAcceso_Usuario1_idx` (`Usuario_idUsuario`),
  CONSTRAINT `fk_ControlAcceso_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `control_acceso`
--

LOCK TABLES `control_acceso` WRITE;
/*!40000 ALTER TABLE `control_acceso` DISABLE KEYS */;
INSERT INTO `control_acceso` VALUES (1,'2024-12-10 08:00:00','2024-12-10 17:00:00',1),(2,'2024-12-10 08:15:00','2024-12-10 17:15:00',2),(3,'2024-12-10 08:30:00','2024-12-10 17:30:00',3),(4,'2024-12-10 08:45:00','2024-12-10 17:45:00',4),(5,'2024-12-10 09:00:00','2024-12-10 18:00:00',5),(6,'2024-12-11 09:15:00','2024-12-11 18:15:00',1),(7,'2024-12-11 09:30:00','2024-12-11 18:30:00',2),(8,'2024-12-11 09:45:00','2024-12-11 18:45:00',3),(9,'2024-12-11 10:00:00','2024-12-11 19:00:00',4),(10,'2024-12-11 10:15:00','2024-12-11 19:15:00',5);
/*!40000 ALTER TABLE `control_acceso` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-15 21:02:42
