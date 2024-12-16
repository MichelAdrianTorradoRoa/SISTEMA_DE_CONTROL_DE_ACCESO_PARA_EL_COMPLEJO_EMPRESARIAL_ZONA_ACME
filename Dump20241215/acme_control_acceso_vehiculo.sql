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
-- Table structure for table `control_acceso_vehiculo`
--

DROP TABLE IF EXISTS `control_acceso_vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `control_acceso_vehiculo` (
  `idControl_Acceso_Vehiculo` int NOT NULL AUTO_INCREMENT,
  `Vehiculo_idVehiculo` int NOT NULL,
  `Control_Acceso_idControl_Acceso` int NOT NULL,
  PRIMARY KEY (`idControl_Acceso_Vehiculo`,`Vehiculo_idVehiculo`,`Control_Acceso_idControl_Acceso`),
  UNIQUE KEY `idControl_Acceso_Vehiculo_UNIQUE` (`idControl_Acceso_Vehiculo`),
  KEY `fk_Control_Acceso_Vehiculo_Vehiculo1_idx` (`Vehiculo_idVehiculo`),
  KEY `fk_Control_Acceso_Vehiculo_Control_Acceso1_idx` (`Control_Acceso_idControl_Acceso`),
  CONSTRAINT `fk_Control_Acceso_Vehiculo_Control_Acceso1` FOREIGN KEY (`Control_Acceso_idControl_Acceso`) REFERENCES `control_acceso` (`idControl_Acceso`),
  CONSTRAINT `fk_Control_Acceso_Vehiculo_Vehiculo1` FOREIGN KEY (`Vehiculo_idVehiculo`) REFERENCES `vehiculo` (`idVehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `control_acceso_vehiculo`
--

LOCK TABLES `control_acceso_vehiculo` WRITE;
/*!40000 ALTER TABLE `control_acceso_vehiculo` DISABLE KEYS */;
INSERT INTO `control_acceso_vehiculo` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,6,6),(7,7,7),(8,8,8),(9,9,9),(10,10,10);
/*!40000 ALTER TABLE `control_acceso_vehiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-15 21:02:43
