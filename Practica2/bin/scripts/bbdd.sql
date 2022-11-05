-- phpMyAdmin SQL Dump
-- version 2.7.0-pl2
-- http://www.phpmyadmin.net
--
-- Servidor: oraclepr.uco.es
-- Version del servidor: 5.1.73
-- Version de PHP: 5.3.3
--
-- Base de datos: `p02ritac`
--

-- --------------------------------------------------------

DROP TABLE IF EXISTS `usuario` ;
DROP TABLE IF EXISTS `kart` ;
DROP TABLE IF EXISTS `pista` ;
DROP TABLE IF EXISTS `reserva` ;
DROP TABLE IF EXISTS `bono` ;

CREATE TABLE IF NOT EXISTS `usuario` (
    `name` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `email` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `birthday` DATETIME NULL,
    `reserve` DATETIME NULL,
    PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `kart` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `type` BOOL NOT NULL,
    `status` ENUM( 'disponible', 'reservado', 'mantenimiento' ) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `pista` (
    `name` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `status` BOOL NOT NULL,
    `difficulty` ENUM( 'infantil', 'familiar', 'adultos' ) NOT NULL,
    `max` INT DEFAULT NULL,
    `karts` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`name`),
    FOREIGN KEY (`karts`) REFERENCES kart
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `reserva` (
    `userId` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `date` DATETIME NULL,
    `duration` INT DEFAULT NULL,
    `pistaId` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `price` FLOAT DEFAULT NULL,
    `discount` FLOAT DEFAULT NULL,
    `typeRes` ENUM(' infantil', 'familiar', 'adultos' ),
    PRIMARY KEY (`userId`),
    FOREIGN KEY (`userId`) REFERENCES usuario(email),
    FOREIGN KEY (`pistaId`) REFERENCES pista(name),
    FOREIGN KEY (`typeRes`) REFERENCES pista(difficulty)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `bono` (
    `bonoId` INT DEFAULT NULL,
    `session` INT DEFAULT NULL,
    PRIMARY KEY (`bonoId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT INTO `usuario` VALUES ('Carlos', 'p02ritac@uco.es','15/08/2002', '05/11/2022');
INSERT INTO `usuario` VALUES ('Silvia', 'i02rofls@uco.es','02/09/2002', '05/11/2022');
INSERT INTO `usuario` VALUES ('Alba', 'i02pajia@uco.es','23/12/2002', '05/11/2022');
INSERT INTO `usuario` VALUES ('Moises', 'i92mocem@uco.es','05/04/2001', '05/11/2022');

INSERT INTO `kart` VALUES (NULL,0 ,'disponible');
INSERT INTO `kart` VALUES (NULL,0 ,'reservado');
INSERT INTO `kart` VALUES (NULL,1 ,'disponible');
INSERT INTO `kart` VALUES (NULL,0 ,'mantenimiento');

INSERT INTO `pista` VALUES ('cordoba', 0, 'infantil', 3, NULL);
INSERT INTO `pista` VALUES ('sevilla', 0, 'familiar', 4, NULL);
INSERT INTO `pista` VALUES ('madrid', 1, 'adultos', 2, NULL);
INSERT INTO `pista` VALUES ('barcelona', 0, 'adultos', 10, NULL);

INSERT INTO `reserva` VALUES ('p02ritac@uco.es', '04/11/2022', 120, 'cordoba', 20, 10, 'infantil');
INSERT INTO `reserva` VALUES ('i02rofls@uco.es', '13/08/2022', 120, 'sevilla', 20, 5, 'familiar');
INSERT INTO `reserva` VALUES ('i02pajia@uco.es', '01/01/2022', 120, 'barcelona', 20, 10, 'adultos');
INSERT INTO `reserva` VALUES ('i92mocem@uco.es', '23/12/2020', 120, 'madrid', 20, 5, 'adultos');

INSERT INTO `bono` VALUES (1, 4);
INSERT INTO `bono` VALUES (2, 2);
INSERT INTO `bono` VALUES (3, 3);
INSERT INTO `bono` VALUES (4, 5);
