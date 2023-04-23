-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 23, 2023 at 08:16 PM
-- Server version: 8.0.28
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pou_moche`
--

-- --------------------------------------------------------

--
-- Table structure for table `centre_de_tri`
--

DROP TABLE IF EXISTS `centre_de_tri`;
CREATE TABLE IF NOT EXISTS `centre_de_tri` (
  `name` varchar(100) NOT NULL,
  `adresse` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `centre_de_tri`
--

INSERT INTO `centre_de_tri` (`name`, `adresse`) VALUES
('Corentin', 'paris');

-- --------------------------------------------------------

--
-- Table structure for table `contrat`
--

DROP TABLE IF EXISTS `contrat`;
CREATE TABLE IF NOT EXISTS `contrat` (
  `nom` varchar(50) NOT NULL,
  `adrese` varchar(50) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `contrat`
--

INSERT INTO `contrat` (`nom`, `adrese`, `date_debut`, `date_fin`) VALUES
('Bistro Best', 'Place de la gare', '2023-04-19', '2023-04-28'),
('Thales', 'rue de Cherche un stage', '2023-05-01', '2023-06-05');

-- --------------------------------------------------------

--
-- Table structure for table `historique`
--

DROP TABLE IF EXISTS `historique`;
CREATE TABLE IF NOT EXISTS `historique` (
  `id_poubelle` int DEFAULT NULL,
  `id_client` int DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `n_plastique` int DEFAULT NULL,
  `n_metaux` int DEFAULT NULL,
  `n_verre` int DEFAULT NULL,
  `n_autre` int DEFAULT NULL,
  `n_papier` int DEFAULT NULL,
  `n_carton` int DEFAULT NULL,
  `fidelite` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `historique`
--

INSERT INTO `historique` (`id_poubelle`, `id_client`, `date`, `n_plastique`, `n_metaux`, `n_verre`, `n_autre`, `n_papier`, `n_carton`, `fidelite`) VALUES
(2, 1, '23/04/2023 10:25:51', 0, 0, 0, 3, 0, 0, 30),
(1, 2, '23/04/2023 11:36:47', 1, 1, 1, 1, 1, 1, 10),
(2, 1, '23/04/2023 12:27:38', 1, 1, 1, 1, 0, 1, -30),
(1, 1, '23/04/2023 14:51:15', 1, 4, 0, 0, 3, 1, 30),
(2, 1, '23/04/2023 14:53:08', 1, 1, 0, 1, 1, 1, -30),
(1, 1, '23/04/2023 15:16:46', 0, 0, 0, 0, 0, 0, 0),
(1, 1, '23/04/2023 17:48:33', 1, 1, 2, 0, 1, 0, 10),
(1, 1, '23/04/2023 18:31:25', 0, 0, 0, 0, 0, 0, 0),
(2, 2, '23/04/2023 21:06:10', 0, 0, 0, 6, 0, 0, 60),
(2, 2, '23/04/2023 21:06:20', 0, 0, 0, 8, 0, 0, 80),
(2, 2, '23/04/2023 21:08:17', 0, 0, 0, 5, 0, 0, 50),
(2, 2, '23/04/2023 21:10:21', 0, 0, 0, 10, 0, 0, 100),
(2, 1, '23/04/2023 21:17:47', 0, 0, 0, 10, 0, 0, 100);

-- --------------------------------------------------------

--
-- Table structure for table `poubelle`
--

DROP TABLE IF EXISTS `poubelle`;
CREATE TABLE IF NOT EXISTS `poubelle` (
  `Centre_nom` varchar(100) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `adresse` varchar(100) NOT NULL,
  `capacite` int DEFAULT NULL,
  `quantite_pp` int NOT NULL,
  `quantite_pm` int NOT NULL,
  `quantite_pv` int NOT NULL,
  `quantite_autre` int NOT NULL,
  `quantite_ppp` int NOT NULL,
  `quantite_pc` int NOT NULL,
  `type` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `poubelle`
--

INSERT INTO `poubelle` (`Centre_nom`, `id`, `adresse`, `capacite`, `quantite_pp`, `quantite_pm`, `quantite_pv`, `quantite_autre`, `quantite_ppp`, `quantite_pc`, `type`) VALUES
('Corentin', 1, 'paris', 50, 1, 1, 2, 0, 1, 0, 1),
('Corentin', 2, '18 rue Jean Robert', 200, 0, 0, 0, 39, 0, 0, 0),
('Corentin', 5, '44 rue de cergy', 500, 0, 0, 0, 0, 0, 0, 3),
('cytech', 10, '18 rue de l\'elysee', 49, 0, 0, 0, 0, 0, 0, 2);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `fidelite` int NOT NULL,
  `mdp` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `fidelite`, `mdp`) VALUES
(1, 'hu', 'corentin', 0, '1234'),
(2, 'leo', 'uc', 0, 'oui');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
