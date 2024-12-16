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
-- Table structure for table `logincidente`
--

DROP TABLE IF EXISTS `logincidente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logincidente` (
  `idLogIncidente` int NOT NULL AUTO_INCREMENT,
  `Asunto` text NOT NULL,
  `Fecha` date NOT NULL,
  `Descripcion` text NOT NULL,
  `Incidente_idIncidente` int NOT NULL,
  PRIMARY KEY (`idLogIncidente`,`Incidente_idIncidente`),
  UNIQUE KEY `idLogIncidente_UNIQUE` (`idLogIncidente`),
  KEY `fk_LogIncidente_Incidente1_idx` (`Incidente_idIncidente`),
  CONSTRAINT `fk_LogIncidente_Incidente1` FOREIGN KEY (`Incidente_idIncidente`) REFERENCES `incidente` (`idIncidente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logincidente`
--

LOCK TABLES `logincidente` WRITE;
/*!40000 ALTER TABLE `logincidente` DISABLE KEYS */;
INSERT INTO `logincidente` VALUES (1,'Revisión de cumplimiento de horarios','2024-12-01','Se revisó el informe sobre el incumplimiento de horarios laborales, con medida disciplinaria aplicada.',1),(2,'Investigación de acoso laboral','2024-12-02','Se realizó una investigación sobre las denuncias de acoso hacia compañeros, con entrevistas y acciones correctivas.',2),(3,'Informe sobre robo de equipos','2024-12-03','Se reportó el robo de equipos electrónicos, con apertura de una investigación interna y aviso a las autoridades.',3),(4,'Evaluación del desorden en el área de trabajo','2024-12-04','Se realizó una inspección del área de trabajo desordenada, con acciones para reorganizar y evitar accidentes.',4),(5,'Informe de agresión física entre empleados','2024-12-05','Se realizó un informe sobre la agresión física entre empleados, con sanciones disciplinarias según el reglamento interno.',5),(6,'Reporte sobre falsificación de documentos','2024-12-06','Se generó un reporte sobre la falsificación de documentos financieros, con acciones legales en proceso.',6),(7,'Detección de consumo de sustancias prohibidas','2024-12-07','Se realizó una revisión en el área de trabajo, detectando consumo de sustancias prohibidas y medidas disciplinarias aplicadas.',7),(8,'Acción sobre insubordinación','2024-12-08','Se tomó acción disciplinaria tras un incidente de insubordinación hacia superiores, con llamado de atención formal al empleado.',8),(9,'Investigación sobre manipulación financiera','2024-12-09','Se abrió una investigación interna sobre manipulación de resultados financieros, con medidas preventivas adoptadas.',9),(10,'Informe sobre sabotaje de equipos','2024-12-10','Se reportó el sabotaje de equipos de producción, con intervención de seguridad y procedimiento judicial iniciado.',10);
/*!40000 ALTER TABLE `logincidente` ENABLE KEYS */;
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
