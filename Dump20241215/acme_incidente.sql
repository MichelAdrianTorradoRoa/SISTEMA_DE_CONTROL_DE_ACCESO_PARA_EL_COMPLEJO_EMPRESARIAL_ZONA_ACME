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
-- Table structure for table `incidente`
--

DROP TABLE IF EXISTS `incidente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incidente` (
  `idIncidente` int NOT NULL AUTO_INCREMENT,
  `Asunto` text NOT NULL,
  `Descripcion` text NOT NULL,
  `Fechal` date NOT NULL,
  `Usuario_idUsuario` int NOT NULL,
  `Persona_idPersona` int NOT NULL,
  `Categoria_Incidente_idCategoria_Incidente` int NOT NULL,
  PRIMARY KEY (`idIncidente`,`Persona_idPersona`,`Categoria_Incidente_idCategoria_Incidente`,`Usuario_idUsuario`),
  UNIQUE KEY `idIncidente_UNIQUE` (`idIncidente`),
  KEY `fk_Incidente_Persona1_idx` (`Persona_idPersona`),
  KEY `fk_Incidente_Categoria_Incidente1_idx` (`Categoria_Incidente_idCategoria_Incidente`),
  KEY `fk_Incidente_Usuario1_idx` (`Usuario_idUsuario`),
  CONSTRAINT `fk_Incidente_Categoria_Incidente1` FOREIGN KEY (`Categoria_Incidente_idCategoria_Incidente`) REFERENCES `categoria_incidente` (`idCategoria_Incidente`) ON DELETE CASCADE,
  CONSTRAINT `fk_Incidente_Persona1` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE CASCADE,
  CONSTRAINT `fk_Incidente_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidente`
--

LOCK TABLES `incidente` WRITE;
/*!40000 ALTER TABLE `incidente` DISABLE KEYS */;
INSERT INTO `incidente` VALUES (1,'Incumplimiento de horarios','Empleado que no cumplió con el horario laboral establecido.','2024-12-01',1,1,1),(2,'Acoso hacia compañeros','Empleado que ha realizado comentarios inapropiados a otros compañeros de trabajo.','2024-12-02',2,2,2),(3,'Robo de equipos electrónicos','Robo de varios equipos electrónicos en el área administrativa.','2024-12-03',3,3,3),(4,'Desorden en el área de trabajo','Área de trabajo desorganizada y con materiales fuera de lugar.','2024-12-04',4,4,4),(5,'Agresión física entre empleados','Conflicto entre empleados que resultó en agresión física.','2024-12-05',5,5,5),(6,'Falsificación de documentos financieros','Empleados que alteraron documentos financieros para beneficios personales.','2024-12-06',1,6,6),(7,'Consumo de sustancias prohibidas en el trabajo','Empleado detectado consumiendo sustancias ilícitas dentro de la empresa.','2024-12-07',2,7,7),(8,'Insubordinación hacia superiores','Empleado desobedeció una orden directa de su superior jerárquico.','2024-12-08',3,8,8),(9,'Manipulación de resultados financieros','Empleados manipulando datos financieros para obtener ganancias ilegales.','2024-12-09',4,9,9),(10,'Sabotaje de equipos de producción','Destrucción deliberada de maquinaria en el área de producción.','2024-12-10',5,10,10);
/*!40000 ALTER TABLE `incidente` ENABLE KEYS */;
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
