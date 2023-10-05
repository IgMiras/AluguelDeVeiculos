CREATE DATABASE  IF NOT EXISTS `alugueldeveiculos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `alugueldeveiculos`;
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

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `idfuncionario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `dataNascimento` date NOT NULL,
  `endereco` varchar(80) NOT NULL,
  `cep` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `salario` float NOT NULL,
  `pis` varchar(15) NOT NULL,
  `dataAdmissao` date NOT NULL,
  PRIMARY KEY (`idfuncionario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Vinicius Castillo','123.456.665-22','23.543.234-87','2004-02-29','Rua da Pesca, 37','888872-23','vini.cast@unesp.br',10000,'99988877766','2000-02-10'),(2,'Matheus Nazaro','333.888.567-12','12.988.233-87','2001-02-23','Rua ela mesmo, Vila Iti','1987634-09','nazaro.maozinha@unesp.br',1500,'23456788876','2022-05-17'),(3,'Gabriel Menezes','444.123.456-99','12.333.451-23','2003-08-10','Rua Osvaldo Peretti, 98','199893-09','g.menezes@unesp.br',2000,'99999999','2022-02-20');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locacao`
--

DROP TABLE IF EXISTS `locacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locacao` (
  `idlocacao` int NOT NULL AUTO_INCREMENT,
  `idcliente` int NOT NULL,
  `idfuncionario` int NOT NULL,
  `idveiculo` int NOT NULL,
  `data_locacao` date NOT NULL,
  `data_devolucao` date NOT NULL,
  `valor_total` float NOT NULL,
  `tipo_pagamento` varchar(45) NOT NULL,
  `finalizada` tinyint NOT NULL,
  PRIMARY KEY (`idlocacao`),
  KEY `idcliente` (`idcliente`),
  KEY `idfuncionario` (`idfuncionario`),
  KEY `idveiculo` (`idveiculo`),
  CONSTRAINT `locacao_ibfk_1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `locacao_ibfk_2` FOREIGN KEY (`idfuncionario`) REFERENCES `funcionario` (`idfuncionario`),
  CONSTRAINT `locacao_ibfk_3` FOREIGN KEY (`idveiculo`) REFERENCES `veiculo` (`idveiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locacao`
--

LOCK TABLES `locacao` WRITE;
/*!40000 ALTER TABLE `locacao` DISABLE KEYS */;
INSERT INTO `locacao` VALUES (10,1,1,1,'2023-10-03','2023-10-04',134,'dinheiro',0),(11,2,2,2,'2022-02-10','2023-10-05',60245,'dinheiro',0),(12,3,3,5,'2022-02-10','2023-03-11',78845,'dinheiro',0);
/*!40000 ALTER TABLE `locacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locacao_seguro`
--

DROP TABLE IF EXISTS `locacao_seguro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locacao_seguro` (
  `idlocacao` int NOT NULL,
  `idseguro` int NOT NULL,
  PRIMARY KEY (`idlocacao`,`idseguro`),
  KEY `idseguro` (`idseguro`),
  CONSTRAINT `locacao_seguro_ibfk_1` FOREIGN KEY (`idlocacao`) REFERENCES `locacao` (`idlocacao`),
  CONSTRAINT `locacao_seguro_ibfk_2` FOREIGN KEY (`idseguro`) REFERENCES `seguro` (`idseguro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locacao_seguro`
--

LOCK TABLES `locacao_seguro` WRITE;
/*!40000 ALTER TABLE `locacao_seguro` DISABLE KEYS */;
INSERT INTO `locacao_seguro` VALUES (10,1),(11,1),(12,1),(10,2),(11,2),(12,2);
/*!40000 ALTER TABLE `locacao_seguro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguro`
--

DROP TABLE IF EXISTS `seguro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguro` (
  `idseguro` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `valor` float NOT NULL,
  PRIMARY KEY (`idseguro`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguro`
--

LOCK TABLES `seguro` WRITE;
/*!40000 ALTER TABLE `seguro` DISABLE KEYS */;
INSERT INTO `seguro` VALUES (1,'Seguro anti-furto','Seguro Automovel','O seguro cobre integralmente o valor do veiculo em caso de furto',20),(2,'Seguro acidente','Seguro Automovel','O seguro cobre integralmente o valor do veiculo em caso de acidente',25);
/*!40000 ALTER TABLE `seguro` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2023-10-04 22:18:32
