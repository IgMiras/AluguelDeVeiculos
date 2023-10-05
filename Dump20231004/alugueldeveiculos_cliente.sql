-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: alugueldeveiculos
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idcliente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `dataNascimento` date NOT NULL,
  `endereco` varchar(80) NOT NULL,
  `cep` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `categoriaCNH` varchar(10) NOT NULL,
  `numeroCNH` varchar(11) NOT NULL,
  `validadeCNH` date NOT NULL,
  `clienteOuro` tinyint NOT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Igor','454.474.348-22','52.047.755-2','2004-07-20','R. Osvaldo Peretti, 98 - Jardim das Rosas, Presidente Prudente','19060-160','im.miras@unesp.br','B','22222222222','2024-01-01',1),(2,'Lais','123.374.348-22','12.057.725-2','2004-05-10','R. Tchurusbengo Tchurusbangos, 12 - Jardim das Rosas, Presidente Prudente','19260-161','lais.isabella@unesp.br','B','99999999999','2025-01-01',1),(3,'Sabrina','444.555.111-77','34.067.125-3','2004-04-13','R. Aquela Mesmo, 33 - Jardim das Rosas, Presidente Prudente','19331-162','sah.oliver@unesp.br','B','77777777777','2025-05-11',1),(4,'Pedro','333.374.348-22','12.052.725-2','2004-05-10','R. Tchurusbengo Tchurusbangos, 12 - Jardim das Rosas, Presidente Prudente','19260-161','lais.isabella@unesp.br','B','91299999999','2025-01-01',1),(5,'Joao','333.374.348-22','12.052.725-2','2004-05-10','R. Tchurusbengo Tchurusbangos, 12 - Jardim das Rosas, Presidente Prudente','19260-161','lais.isabella@unesp.br','B','91299999999','2025-01-01',1),(6,'Sergio','442.178.111-77','34.067.134-3','2004-04-13','R. Aquela Mesmo, 33 - Jardim das Rosas, Presidente Prudente','19331-156','sah.oliver@unesp.br','B','227777777','2025-05-11',1),(7,'Alexandre Teves','454.474.348-12','52.039.255-8','2003-01-31','Rua aquela mesmo, 123','123459-09','alex.teves@unesp.br','B','12345678999','2026-06-20',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-04 21:55:57
