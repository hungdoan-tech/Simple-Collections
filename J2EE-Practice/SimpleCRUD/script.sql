CREATE DATABASE `ShoesStore`;
USE ShoesStore;
 
CREATE TABLE `Shoes` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(128) NOT NULL,
  `Brand` varchar(45) NOT NULL,
  `Price` float NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `shoes_id_UNIQUE` (`Id`),
  UNIQUE KEY `name_UNIQUE` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1