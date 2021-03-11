-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 11 mars 2021 à 19:33
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `location`
--
CREATE DATABASE IF NOT EXISTS `location` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `location`;

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

DROP TABLE IF EXISTS `adresse`;
CREATE TABLE IF NOT EXISTS `adresse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `CODE_POSTAL` int(11) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `LIBELLE_RUE` varchar(255) DEFAULT NULL,
  `NUMERO_RUE` int(11) DEFAULT NULL,
  `NUMERO_TELEPHONE` int(11) DEFAULT NULL,
  `VILLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `adresse`
--

INSERT INTO `adresse` (`id`, `CODE_POSTAL`, `EMAIL`, `LIBELLE_RUE`, `NUMERO_RUE`, `NUMERO_TELEPHONE`, `VILLE`) VALUES
(1, 34000, 'sheldon@live.fr', 'rue du BigBang', 8, 620202020, 'MONTPELLIER'),
(2, 34000, 'sherwood@gmail.fr', 'rue de la flêche', 8, 625242421, 'MONTPELLIER'),
(3, 60100, 'steph@hotmail.fr', 'rue de la question', 10, 625232124, 'CREIL'),
(4, 76000, 'disco@gmail.fr', 'rue disco', 10, 625252525, 'ROUEN');

-- --------------------------------------------------------

--
-- Structure de la table `bilan_comptable`
--

DROP TABLE IF EXISTS `bilan_comptable`;
CREATE TABLE IF NOT EXISTS `bilan_comptable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `SOLDE` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `adresse_id` int(11) DEFAULT NULL,
  `permis_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnfsdnicx0omj8d3gn66edp1n` (`adresse_id`),
  KEY `FKionxhow4w128qellh9cbnqdph` (`permis_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `NOM`, `PRENOM`, `adresse_id`, `permis_id`) VALUES
(1, 'COOPER', 'Sheldon', 1, 1),
(2, 'DESBOIS', 'Robin', 2, 2),
(3, 'DEMONACO', 'Stéphanie', 3, 3),
(4, 'SOIREEDISCO', 'Boris', 4, 4);

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NUMERO_DE_FACTURE` int(11) DEFAULT NULL,
  `TYPE_DE_REGLEMENT` varchar(255) DEFAULT NULL,
  `facture_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6fph0jq7272vx0w63krwbcdyw` (`facture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `maintenance`
--

DROP TABLE IF EXISTS `maintenance`;
CREATE TABLE IF NOT EXISTS `maintenance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `COUT_MAINTENANCE` int(11) DEFAULT NULL,
  `DEBUT_MAINTENANCE` datetime(6) DEFAULT NULL,
  `FIN_MAINTENANCE` datetime(6) DEFAULT NULL,
  `maintenance_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhpuyjmb7simm0oybde9mp14g0` (`maintenance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `permis`
--

DROP TABLE IF EXISTS `permis`;
CREATE TABLE IF NOT EXISTS `permis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DATE_OBTENTION` datetime(6) DEFAULT NULL,
  `NUMERO` int(11) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `permis`
--

INSERT INTO `permis` (`id`, `DATE_OBTENTION`, `NUMERO`, `TYPE`) VALUES
(1, '2020-05-06 00:00:00.000000', 78885, 'B'),
(2, '2008-03-10 00:00:00.000000', 123456, 'C'),
(3, '2002-03-17 00:00:00.000000', 789456, 'B'),
(4, '1990-07-01 00:00:00.000000', 789, 'C');

-- --------------------------------------------------------

--
-- Structure de la table `personnes`
--

DROP TABLE IF EXISTS `personnes`;
CREATE TABLE IF NOT EXISTS `personnes` (
  `id` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DATE_DE_DEBUT` datetime(6) DEFAULT NULL,
  `DATE_DE_FIN` datetime(6) DEFAULT NULL,
  `KILOMETRAGE_DEBUT` int(11) DEFAULT NULL,
  `KILOMETRAGE_FIN` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `facture_id` int(11) DEFAULT NULL,
  `vehicule_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9fe9ikuq3uj2ivu2kj46k0pia` (`client_id`),
  KEY `FKk8ux6sixb0b6pwr1lvb75ir9u` (`facture_id`),
  KEY `FKc54j4gjeerlpmifvdymtmru7` (`vehicule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

DROP TABLE IF EXISTS `type`;
CREATE TABLE IF NOT EXISTS `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

DROP TABLE IF EXISTS `vehicule`;
CREATE TABLE IF NOT EXISTS `vehicule` (
  `DTYPE` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `COMMENTAIRE` varchar(255) DEFAULT NULL,
  `IMMATRICULATION` varchar(255) DEFAULT NULL,
  `KILOMETRAGE` int(11) DEFAULT NULL,
  `MARQUE` varchar(255) DEFAULT NULL,
  `MODELE` varchar(255) DEFAULT NULL,
  `STATUT` varchar(255) DEFAULT NULL,
  `VOLUME` double DEFAULT NULL,
  `NOMBRE_PLACES` int(11) DEFAULT NULL,
  `voiture_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj3fi0017daogeljmiorglainv` (`voiture_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`DTYPE`, `id`, `COMMENTAIRE`, `IMMATRICULATION`, `KILOMETRAGE`, `MARQUE`, `MODELE`, `STATUT`, `VOLUME`, `NOMBRE_PLACES`, `voiture_id`) VALUES
('Vehicule', 2, NULL, 'R2-888-D2', 12000, 'OPEL', 'CORSA', 'disponible', NULL, NULL, NULL),
('Vehicule', 3, NULL, '7B-852-X7', 9000, 'FORD', 'FIESTA', 'disponible', NULL, NULL, NULL),
('Vehicule', 4, NULL, 'F8-805-M9', 1800, 'CITROEN', 'BX', 'disponible', NULL, NULL, NULL),
('Vehicule', 5, NULL, 'G1-880-Z6', 11000, 'RENAULT', 'MEGANE', 'disponible', NULL, NULL, NULL),
('Vehicule', 6, NULL, '8A-202-X3', 1800, 'MINI', 'MINI 4 3P', 'disponible', NULL, NULL, NULL),
('Vehicule', 7, NULL, '8L-874-D1', 15000, 'VOLVO ', 'VOLVO FL', 'disponible', NULL, NULL, NULL);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FKionxhow4w128qellh9cbnqdph` FOREIGN KEY (`permis_id`) REFERENCES `permis` (`id`),
  ADD CONSTRAINT `FKnfsdnicx0omj8d3gn66edp1n` FOREIGN KEY (`adresse_id`) REFERENCES `adresse` (`id`);

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `FK6fph0jq7272vx0w63krwbcdyw` FOREIGN KEY (`facture_id`) REFERENCES `reservation` (`id`);

--
-- Contraintes pour la table `maintenance`
--
ALTER TABLE `maintenance`
  ADD CONSTRAINT `FKhpuyjmb7simm0oybde9mp14g0` FOREIGN KEY (`maintenance_id`) REFERENCES `vehicule` (`id`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FK9fe9ikuq3uj2ivu2kj46k0pia` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `FKc54j4gjeerlpmifvdymtmru7` FOREIGN KEY (`vehicule_id`) REFERENCES `vehicule` (`id`),
  ADD CONSTRAINT `FKk8ux6sixb0b6pwr1lvb75ir9u` FOREIGN KEY (`facture_id`) REFERENCES `facture` (`id`);

--
-- Contraintes pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD CONSTRAINT `FKj3fi0017daogeljmiorglainv` FOREIGN KEY (`voiture_id`) REFERENCES `type` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
