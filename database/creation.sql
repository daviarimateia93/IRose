DROP DATABASE IF EXISTS `IROSE`;
CREATE DATABASE `IROSE` CHARACTER SET utf8 COLLATE utf8_bin;

USE `IROSE`;

CREATE TABLE `ACCOUNT` (
	`ID` BIGINT NOT NULL AUTO_INCREMENT,
	`NICKNAME` VARCHAR(45) NOT NULL,
	`PASSWORD` VARCHAR(128) NOT NULL,
	`EMAIL` VARCHAR(320) NOT NULL,
	`LOGGED` BOOLEAN NOT NULL,
	PRIMARY KEY (`ID`),
	UNIQUE KEY (`NICKNAME`)
);

CREATE TABLE `MAP` (
	`ID` BIGINT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `LOCATION` (
	`ID` BIGINT NOT NULL AUTO_INCREMENT,
	`ID_MAP` BIGINT NOT NULL,
	`POINT_X` DOUBLE NOT NULL,
	`POINT_Y` DOUBLE NOT NULL,
	`POINT_Z` DOUBLE NOT NULL,
	PRIMARY KEY (`ID`),
	FOREIGN KEY (`ID_MAP`) REFERENCES `MAP`(`ID`)
);

CREATE TABLE `CHARACTER_SKILL` (
	`ID` BIGINT NOT NULL AUTO_INCREMENT,
	`RANGE` VARCHAR(45) NOT NULL,
	`CATEGORY` VARCHAR(45) NOT NULL,
	`TYPE` VARCHAR(45) NOT NULL,
	`DURATION` INT NOT NULL,
	`COUNT_DOWN` INT NOT NULL,
	`VALUE` INT NOT NULL,
	`VALUE_PERCENT` FLOAT NOT NULL,
	`MP` INT NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `CHARACTER_AREA` (
	`ID` BIGINT NOT NULL AUTO_INCREMENT,
	`ID_LOCATION` BIGINT NOT NULL,
	`RADIUS` DOUBLE NOT NULL,
	PRIMARY KEY (`ID`),
	FOREIGN KEY (`ID_LOCATION`) REFERENCES `LOCATION`(`ID`)
);

CREATE TABLE `CHARACTER` (
	`ID` BIGINT NOT NULL AUTO_INCREMENT,
	`ID_CHARACTER_AREA` BIGINT NOT NULL,
	`NAME` VARCHAR(120) NOT NULL,
	`HP` INT NOT NULL,
	`MP` INT NOT NULL,
	`WEIGHT` INT NOT NULL,
	`SP` INT NOT NULL,
	`HP_RECOVERY` FLOAT NOT NULL,
	`MP_RECOVERY` FLOAT NOT NULL,
	PRIMARY KEY (`ID`),
	FOREIGN KEY (`ID_CHARACTER_AREA`) REFERENCES `CHARACTER_AREA`(`ID`)
);

CREATE TABLE `CHARACTER_CHARACTER_SKILL` (
	`ID_CHARACTER` BIGINT NOT NULL,
	`ID_CHARACTER_SKILL` BIGINT NOT NULL,
	FOREIGN KEY (`ID_CHARACTER`) REFERENCES `CHARACTER`(`ID`),
	FOREIGN KEY (`ID_CHARACTER_SKILL`) REFERENCES `CHARACTER_SKILL`(`ID`)
);

CREATE TABLE `PLAYER_ATTRIBUTES` (
	`ID` BIGINT NOT NULL AUTO_INCREMENT,
	`STRENGTH` INT NOT NULL,
	`DEXTERITY` INT NOT NULL,
	`INTELLIGENCE` INT NOT NULL,
	`CONCENTRATION` INT NOT NULL,
	`CHARM` INT NOT NULL,
	`SENSE` INT NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `PLAYER_SKILL` (
	`ID` BIGINT NOT NULL AUTO_INCREMENT,
	`LEVEL` INT NOT NULL,
	`MAX_LEVEL` INT NOT NULL,
	`SKILL_POINTS` INT NOT NULL,
	PRIMARY KEY (`ID`),
	FOREIGN KEY (`ID`) REFERENCES `CHARACTER`(`ID`)
);

CREATE TABLE `PLAYER_SKILL_REQUERIMENT` (
	`ID` BIGINT NOT NULL AUTO_INCREMENT,
	`MIN_LEVEL` INT NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `PLAYER_SKILL_PLAYER_SKILL_REQUERIMENT` (
	`ID_PLAYER_SKILL` BIGINT NOT NULL,
	`ID_PLAYER_SKILL_REQUERIMENT` BIGINT NOT NULL,
	FOREIGN KEY (`ID_PLAYER_SKILL`) REFERENCES `PLAYER_SKILL`(`ID`),
	FOREIGN KEY (`ID_PLAYER_SKILL_REQUERIMENT`) REFERENCES `PLAYER_SKILL_REQUERIMENT`(`ID`)
);

CREATE TABLE `PLAYER` (
	`ID` BIGINT NOT NULL AUTO_INCREMENT,
	`ID_ACCOUNT` BIGINT NOT NULL,
	`ID_PLAYER_ATTRIBUTES` BIGINT NOT NULL,
	`ATTRIBUTES_POINTS` INT NOT NULL,
	`SKILL_POINTS` INT NOT NULL,
	`EXTRA_XP_RATE` FLOAT NOT NULL,
	`EXTRA_DROP_RATE` FLOAT NOT NULL,
	PRIMARY KEY (`ID`),
	FOREIGN KEY (`ID_ACCOUNT`) REFERENCES `ACCOUNT`(`ID`),
	FOREIGN KEY (`ID_PLAYER_ATTRIBUTES`) REFERENCES `PLAYER_ATTRIBUTES`(`ID`)
);
