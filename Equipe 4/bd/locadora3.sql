-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: locadora
-- ------------------------------------------------------
-- Server version	5.6.27-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bug`
--

DROP TABLE IF EXISTS `bug`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bug` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `criadoEm` datetime DEFAULT NULL,
  `descricao` varchar(1000) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `sumario` varchar(255) DEFAULT NULL,
  `responsavel_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_18q4gc96bp5nghsqnqdtsalvb` (`responsavel_id`),
  CONSTRAINT `FK_18q4gc96bp5nghsqnqdtsalvb` FOREIGN KEY (`responsavel_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bug`
--

LOCK TABLES `bug` WRITE;
/*!40000 ALTER TABLE `bug` DISABLE KEYS */;
/*!40000 ALTER TABLE `bug` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carro`
--

DROP TABLE IF EXISTS `carro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `arCondicionado` tinyint(1) NOT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `placa` varchar(255) DEFAULT NULL,
  `statusCarro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carro`
--

LOCK TABLES `carro` WRITE;
/*!40000 ALTER TABLE `carro` DISABLE KEYS */;
INSERT INTO `carro` VALUES (1,0,'Gol','HGM1020','GARAGEM'),(2,0,'Corsa','HJK5023','GARAGEM'),(3,1,'Uno','HYB7460','GARAGEM'),(4,1,'Uno','HCB3456','GARAGEM'),(5,1,'Uno','HQS2300','GARAGEM'),(6,1,'Ferrari','HSS6969','GARAGEM'),(7,0,'Fusca','HOO0000','GARAGEM');
/*!40000 ALTER TABLE `carro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `criadoEm` datetime DEFAULT NULL,
  `descricao` varchar(2000) DEFAULT NULL,
  `autor_id` int(11) DEFAULT NULL,
  `os_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_p6xd7rh248gxfpvdobwsrk9rb` (`autor_id`),
  KEY `FK_o9qym4b3k3cbheo5qcu8j4dd7` (`os_id`),
  CONSTRAINT `FK_o9qym4b3k3cbheo5qcu8j4dd7` FOREIGN KEY (`os_id`) REFERENCES `os` (`id`),
  CONSTRAINT `FK_p6xd7rh248gxfpvdobwsrk9rb` FOREIGN KEY (`autor_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `os`
--

DROP TABLE IF EXISTS `os`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `os` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comentario` varchar(1000) DEFAULT NULL,
  `criadoEm` datetime DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `sumario` varchar(255) DEFAULT NULL,
  `carro_id` int(11) DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `responsavel_id` int(11) DEFAULT NULL,
  `finalizadoEm` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hl374txyqranwkm213i0j2rwj` (`carro_id`),
  KEY `FK_i7owtu60qn1djk4qxubk5j68p` (`cliente_id`),
  KEY `FK_1bhooir3w4ni9mlju5iclooiw` (`responsavel_id`),
  CONSTRAINT `FK_1bhooir3w4ni9mlju5iclooiw` FOREIGN KEY (`responsavel_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK_hl374txyqranwkm213i0j2rwj` FOREIGN KEY (`carro_id`) REFERENCES `carro` (`id`),
  CONSTRAINT `FK_i7owtu60qn1djk4qxubk5j68p` FOREIGN KEY (`cliente_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os`
--

LOCK TABLES `os` WRITE;
/*!40000 ALTER TABLE `os` DISABLE KEYS */;
INSERT INTO `os` VALUES (3,NULL,'2016-05-24 06:00:01','dlrç','ABERTO','Teste',2,8,3,NULL),(4,NULL,'2016-05-24 06:00:15','efçl,çle,w','ABERTO','sdçlfkçl',1,9,6,NULL);
/*!40000 ALTER TABLE `os` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `funcionario` tinyint(1) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (3,1,'dads','asf','Lsdfik#$34','dsa','dasddf','asf@c.br','asd','42537','GO'),(5,0,'dsfsdfS','dosij','SDdds@#@#3232','','Sobral','sodij','asf','03216','CE'),(6,1,'Kasoijas','AEokpae','asoijM123#$','','São Paulo','asp@fa.com','Rua aposkfpoa','52520','SP'),(7,1,'Zezin','Ze','QWerty12345@','','Rio de Janeiro','ze@z.br','Rua Z','25522145','RJ'),(8,0,'Carlos','Carlos','AS1234!s',NULL,'Porto Alegre','c@c.br','Rua C','6542145','RS'),(9,0,'Maria','Maria','M@ria2',NULL,'Fortaleza','m@m.br','Rua M','54245','CE');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-24  7:21:34
