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
    `password` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `email` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `dateOfBirth` DATETIME NULL,
    `inscription` DATETIME NULL,
    `type` ENUM('cliente', 'administrador'),
    PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `kart` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `type` BOOL NOT NULL,
    `status` ENUM( 'disponible', 'reservado', 'mantenimiento' ) NOT NULL,
    `pistaId` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`pistaId`) REFERENCES pista
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `pista` (
    `name` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `status` BOOL NOT NULL,
    `difficulty` ENUM( 'infantil', 'familiar', 'adultos' ) NOT NULL,
    `max` INT DEFAULT NULL,
    PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `reserva` (
    `Id` INT NOT NULL AUTO_INCREMENT,
    `userId` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `date` DATETIME NULL,
    `duration` INT DEFAULT NULL,
    `pistaId` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `price` FLOAT DEFAULT NULL,
    `discount` FLOAT DEFAULT NULL,
    `typeRes` ENUM('infantil', 'familiar', 'adultos' ),
    `nAdults` INT DEFAULT NULL,
    `nChilds` INT DEFAULT NULL,
    `bonoId` INT DEFAULT NULL,
    PRIMARY KEY (`Id`),
    FOREIGN KEY (`userId`) REFERENCES usuario(email),
    FOREIGN KEY (`pistaId`) REFERENCES pista(name),
    FOREIGN KEY (`bonoId`) REFERENCES bono(bonoId)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `bono` (
    `bonoId` INT DEFAULT NULL AUTO_INCREMENT,
    `session` INT DEFAULT NULL,
    `caducity` DATETIME NULL,
    PRIMARY KEY (`bonoId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT INTO `usuario` VALUES ('Carlos', 'p02ritac', 'p02ritac@uco.es','2002-08-15', '2022-11-05', 'administrador');
INSERT INTO `usuario` VALUES ('Silvia', 'i02rofls', 'i02rofls@uco.es','2002-09-02', '2022-11-05', 'administrador');
INSERT INTO `usuario` VALUES ('Alba', 'i02pajia', 'i02pajia@uco.es','2002-10-01', '2022-11-05', 'cliente');
INSERT INTO `usuario` VALUES ('Moises', 'i92mocem', 'i92mocem@uco.es','2001-04-05', '2022-11-05', 'cliente');

INSERT INTO `kart` VALUES (NULL,0 ,'disponible', 'cordoba');
INSERT INTO `kart` VALUES (NULL,0 ,'reservado', '');
INSERT INTO `kart` VALUES (NULL,1 ,'disponible', 'sevilla');
INSERT INTO `kart` VALUES (NULL,0 ,'mantenimiento', 'barcelona');

INSERT INTO `pista` VALUES ('cordoba', 0, 'infantil', 3);
INSERT INTO `pista` VALUES ('sevilla', 0, 'familiar', 4);
INSERT INTO `pista` VALUES ('madrid', 1, 'adultos', 2);
INSERT INTO `pista` VALUES ('barcelona', 0, 'adultos', 10);

INSERT INTO `reserva` VALUES (NULL, 'p02ritac@uco.es', '2022-11-04', 120, 'cordoba', 20, 10, 'infantil', 0, 2, 0);
INSERT INTO `reserva` VALUES (NULL, 'i02rofls@uco.es', '2022-08-13', 120, 'sevilla', 20, 5, 'familiar', 2, 3, 1);
INSERT INTO `reserva` VALUES (NULL, 'i02rofls@uco.es', '2022-09-13', 120, 'sevilla', 20, 5, 'familiar', 1, 4, 1);
INSERT INTO `reserva` VALUES (NULL, 'i02rofls@uco.es', '2022-12-13', 120, 'sevilla', 20, 5, 'familiar', 2, 5, 1);
INSERT INTO `reserva` VALUES (NULL, 'i02rofls@uco.es', '2023-04-13', 120, 'sevilla', 20, 5, 'familiar', 2, 1, 1);
INSERT INTO `reserva` VALUES (NULL, 'i02rofls@uco.es', '2023-01-10', 120, 'sevilla', 20, 5, 'familiar', 2, 3, 1);
INSERT INTO `reserva` VALUES (NULL, 'i02pajia@uco.es', '2022-01-01', 120, 'barcelona', 20, 10, 'adultos', 5, 0, 0);
INSERT INTO `reserva` VALUES (NULL, 'i92mocem@uco.es', '2020-12-23', 120, 'madrid', 20, 5, 'adultos', 4, 0, 0);

INSERT INTO `bono` VALUES (1, 0, '2023-08-13');
