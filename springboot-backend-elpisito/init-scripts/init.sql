-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: elpisito2024
-- ------------------------------------------------------
-- Server version	8.0.36-0ubuntu0.20.04.1

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
-- Table structure for table `imagenes`
--

DROP TABLE IF EXISTS `imagenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagenes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `activo` int DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `inmueble` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnd92et7oxqhcsxq2hw1kkxia0` (`inmueble`),
  CONSTRAINT `FKnd92et7oxqhcsxq2hw1kkxia0` FOREIGN KEY (`inmueble`) REFERENCES `inmuebles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagenes`
--

LOCK TABLES `imagenes` WRITE;
/*!40000 ALTER TABLE `imagenes` DISABLE KEYS */;
INSERT INTO `imagenes` VALUES (1,1,'1714434633261.jpg',4),(2,1,'1714440555761.jpg',1),(3,1,'1714440638471.jpg',2),(4,1,'1714440663755.jpg',3),(5,1,'1714613603833.jpg',4),(6,1,'1714613642795.jpg',2),(7,1,'1714774490662.jpg',1),(8,1,'1714774495451.jpg',1),(9,1,'1714774500595.jpg',1),(10,1,'1714775741187.jpg',1),(11,1,'1714776053740.jpg',1),(12,1,'1714787847753.jpg',2),(13,1,'1714788194449.jpg',3),(14,1,'1714788345720.jpg',3),(15,1,'1714788833298.jpg',4),(16,1,'1714790162757.jpg',3),(17,1,'1714790437426.jpg',3),(18,1,'1714790437429.jpg',3);
/*!40000 ALTER TABLE `imagenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inmuebles`
--

DROP TABLE IF EXISTS `inmuebles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inmuebles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `activo` int DEFAULT NULL,
  `amueblado` int DEFAULT NULL,
  `apertura` varchar(255) DEFAULT NULL,
  `ascensor` int DEFAULT NULL,
  `cp` varchar(255) DEFAULT NULL,
  `descripcion` varchar(3500) DEFAULT NULL,
  `jardin` int DEFAULT NULL,
  `nombre_via` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `numero_balcones` varchar(255) DEFAULT NULL,
  `numero_banhos` varchar(255) DEFAULT NULL,
  `numero_habitaciones` varchar(255) DEFAULT NULL,
  `operacion` varchar(255) DEFAULT NULL,
  `orientacion` varchar(255) DEFAULT NULL,
  `piscina` int DEFAULT NULL,
  `planta` varchar(255) DEFAULT NULL,
  `plazas_garaje` varchar(255) DEFAULT NULL,
  `portada` int DEFAULT NULL,
  `precio` varchar(255) DEFAULT NULL,
  `puerta` varchar(255) DEFAULT NULL,
  `superficie_construida` varchar(255) DEFAULT NULL,
  `superficie_util` varchar(255) DEFAULT NULL,
  `tendedero` int DEFAULT NULL,
  `tipo_calefaccion` varchar(255) DEFAULT NULL,
  `titular` varchar(255) DEFAULT NULL,
  `trastero` int DEFAULT NULL,
  `via` varchar(255) DEFAULT NULL,
  `poblacion` bigint DEFAULT NULL,
  `tipo` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbsltt65sdkybknkr8nb7qn43s` (`poblacion`),
  KEY `FKcs1i8omrwkr2pq3155pxn6qdp` (`tipo`),
  CONSTRAINT `FKbsltt65sdkybknkr8nb7qn43s` FOREIGN KEY (`poblacion`) REFERENCES `poblaciones` (`id`),
  CONSTRAINT `FKcs1i8omrwkr2pq3155pxn6qdp` FOREIGN KEY (`tipo`) REFERENCES `tipos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inmuebles`
--

LOCK TABLES `inmuebles` WRITE;
/*!40000 ALTER TABLE `inmuebles` DISABLE KEYS */;
INSERT INTO `inmuebles` VALUES (1,1,0,'INTERIOR',1,'2132','Lo mejor del valle',1,'Alameda','21','1','2','4','VENTA','SUR',0,'3','0',1,'230000','C','120','110',1,'ELECTRICA','La vista te dejara atonito',1,'CALLE',4,3),(2,1,1,'INTERIOR',1,'23123','Este inmueble nos otorga grandes dimensiones para la familia',1,'Alcala','12','2','3','5','VENTA','NORTE',1,'0','2',1,'350000','B','140','134',1,'GAS','Espacio sin igual',1,'CALLE',4,1),(3,1,1,'INTERIOR',1,'123123','Estudio increible',0,'Bolivar','2','0','1','1','VENTA','OESTE',0,'1','0',1,'200000','B','90','87',1,'ELECTRICA','La gran oportunidad para el soltero',1,'CALLE',4,2),(4,1,1,'EXTERIOR',1,'28013','Este inmueble situado en el corazón de Madrid ofrece vistas panorámicas de la ciudad, acabados de lujo y todas las comodidades modernas.',1,'Gran Vía','27','2','2','3','VENTA','SUR',1,'3','0',1,'350000','A','100 ','85 ',0,'ELECTRICA','Maravilloso piso en Coruña',1,'CALLE',4,2),(5,1,0,'EXTERIOR',0,'23234','Increible inmueble situado en calle mayor',0,'Mayor','23','1','2','2','VENTA','NORTE',0,'2','1',1,'250000','B','100','90',1,'GAS','Increible piso en calle Mayor',1,'CALLE',4,2),(6,1,1,'EXTERIOR',1,'12444','Lo mejor que hay en la zona',0,'madrid','12','2','2','2','ALQUILER','SUR',0,'1','2',1,'230000','2','150','120',0,'CENTRAL GAS','gran piso en miraflores',0,'CALLE',4,2),(7,1,0,'INTERIOR',1,'123333','olaalal',1,'padro','12','4','3','2','ALQUILER','ESTE',1,'1','2',1,'220000','2','12222','2222',0,'SIN CALEFACCIÓN','la mejor cas',0,'PLAZA',4,2),(8,0,0,'SEMI EXTERIOR',1,'11222','laallal',0,'asdwasd','1','1','2','1','ALQUILER','SUR',0,'1','2',0,'112332','2','122','1222',0,'CENTRAL GAS','dawdad',1,'PLAZA',4,1),(9,0,0,'EXTERIOR',1,'12222','el mejormpiso',0,'calee','12','2','1','3','VENTA','SUR',0,'2','2',1,'12222','2','1222','122',0,'CENTRAL GAS','ajaja',0,'AVENIDA',4,2);
/*!40000 ALTER TABLE `inmuebles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poblaciones`
--

DROP TABLE IF EXISTS `poblaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poblaciones` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `activo` int DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `provincia` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKed2mfrtnivr1wcnmq335c4ldf` (`provincia`),
  CONSTRAINT `FKed2mfrtnivr1wcnmq335c4ldf` FOREIGN KEY (`provincia`) REFERENCES `provincias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poblaciones`
--

LOCK TABLES `poblaciones` WRITE;
/*!40000 ALTER TABLE `poblaciones` DISABLE KEYS */;
INSERT INTO `poblaciones` VALUES (4,1,'A Coruña',1);
/*!40000 ALTER TABLE `poblaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincias`
--

DROP TABLE IF EXISTS `provincias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provincias` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `activo` int DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
INSERT INTO `provincias` VALUES (1,1,'A CORUÑA'),(2,1,'LUGO');
/*!40000 ALTER TABLE `provincias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos`
--

DROP TABLE IF EXISTS `tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `activo` int DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos`
--

LOCK TABLES `tipos` WRITE;
/*!40000 ALTER TABLE `tipos` DISABLE KEYS */;
INSERT INTO `tipos` VALUES (1,1,'CHALET ADOSADO'),(2,1,'PISO'),(3,1,'CHALET INDIVIDUAL');
/*!40000 ALTER TABLE `tipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `activo` int DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `passopen` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,1,'juanito@gmail.com','passopen','juanito','ROLE_USER','Juanito');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-28 15:51:55
