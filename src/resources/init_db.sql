CREATE DATABASE readlist_db;
USE readlist_db;

CREATE TABLE `book` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(128) NOT NULL,
  `AUTOR` varchar(45) NOT NULL,
  `GENRE` varchar(45) NOT NULL,
  `MARK` int NOT NULL,
  `COMMENT` varchar(128) NOT NULL,
  PRIMARY KEY (`ID`)
);