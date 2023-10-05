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
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `veiculo` (
  `idveiculo` int NOT NULL AUTO_INCREMENT,
  `tipoVeiculo` varchar(30) DEFAULT NULL,
  `nomeModelo` varchar(45) NOT NULL,
  `montadora` varchar(45) NOT NULL,
  `anoFabricacao` int NOT NULL,
  `anoModelo` int NOT NULL,
  `placa` varchar(45) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  `valorFipe` float NOT NULL,
  `valorDiaria` float NOT NULL,
  `categoriaCNHNecessaria` varchar(45) NOT NULL,
  `alugado` tinyint NOT NULL,
  `taxaImpostoEstadual` float NOT NULL,
  `taxaImpostoFederal` float DEFAULT NULL,
  PRIMARY KEY (`idveiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
INSERT INTO `veiculo` VALUES (1,'nacional','Focus','Ford',2008,2009,'EAA-3464','sedan',18000,89,'B',0,10,0),(2,'nacional','Up','Volkswagen',2010,2011,'EAA-3422','hatch',20000,100,'B',0,15,0),(3,'nacional','Astra','Chevrolet',2012,2013,'ABC-1234','sedan',25000,120,'B',0,20,0),(4,'nacional','Camaro','Chevrolet',2020,2021,'EEE-2233','sedan',100000,500,'B',0,50,0),(5,'importado','GTR','Nissan',2022,2023,'KJH-9988','sedan',120000,200,'B',0,10,10),(6,'importado','350z','Nissan',2021,2022,'MMN-2235','sedan',150000,220,'B',0,12,12),(7,'importado','370z','Nissan',2021,2022,'CCC-2235','sedan',170000,225,'B',0,15,15);
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
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
