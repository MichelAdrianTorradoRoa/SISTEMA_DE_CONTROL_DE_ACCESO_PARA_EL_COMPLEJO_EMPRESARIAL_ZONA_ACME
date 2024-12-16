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
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculo` (
  `idVehiculo` int NOT NULL AUTO_INCREMENT,
  `Matricula` varchar(255) NOT NULL,
  `Modelo` text NOT NULL,
  `CategoriaVehiculo_idCategoriaVehiculo` int NOT NULL,
  `Persona_idPersona` int NOT NULL,
  PRIMARY KEY (`idVehiculo`,`CategoriaVehiculo_idCategoriaVehiculo`,`Persona_idPersona`),
  UNIQUE KEY `idVehiculo_UNIQUE` (`idVehiculo`),
  UNIQUE KEY `Matricula_UNIQUE` (`Matricula`),
  KEY `fk_Vehiculo_CategoriaVehiculo1_idx` (`CategoriaVehiculo_idCategoriaVehiculo`),
  KEY `fk_Vehiculo_Persona1_idx` (`Persona_idPersona`),
  CONSTRAINT `fk_Vehiculo_CategoriaVehiculo1` FOREIGN KEY (`CategoriaVehiculo_idCategoriaVehiculo`) REFERENCES `categoriavehiculo` (`idCategoriaVehiculo`) ON DELETE CASCADE,
  CONSTRAINT `fk_Vehiculo_Persona1` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES (1,'ABC123','Toyota Corolla',1,1),(2,'DEF456','Ford F-150',2,2),(3,'GHI789','Yamaha YZF',3,3),(4,'JKL012','Honda Civic',1,4),(5,'MNO345','Ducati Panigale',4,5),(6,'PQR678','Chevrolet Spark',1,6),(7,'STU901','Mercedes-Benz Sprinter',6,7),(8,'VWX234','Kawasaki Ninja',3,8),(9,'YZA567','Nissan Frontier',2,9),(10,'BCD890','Tesla Model 3',1,10);
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
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
