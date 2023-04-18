-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 17 mars 2023 à 17:06
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_bancaire`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `num_admin` int(11) NOT NULL,
  `nom_admin` varchar(255) NOT NULL,
  `pseudo_admin` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `mail_admin` varchar(100) NOT NULL,
  `cin_admin` varchar(12) NOT NULL,
  `num_phone_admin` varchar(10) NOT NULL,
  `sexe_admin` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`num_admin`, `nom_admin`, `pseudo_admin`, `password`, `mail_admin`, `cin_admin`, `num_phone_admin`, `sexe_admin`) VALUES
(1, 'MAMINIRINA Honoré Philibert', 'Mamy Hp', 'saitama', 'maminirinahonorephilibert@gmail.com', '201051018415', '0346997404', 'homme');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `num_compte` varchar(8) NOT NULL,
  `password` varchar(20) NOT NULL,
  `solde` float NOT NULL DEFAULT 0,
  `nom_et_prenoms` varchar(255) NOT NULL,
  `num_cin` varchar(12) NOT NULL,
  `num_phone` varchar(10) NOT NULL,
  `sexe` varchar(10) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `date_creation` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`num_compte`, `password`, `solde`, `nom_et_prenoms`, `num_cin`, `num_phone`, `sexe`, `adresse`, `email`, `date_creation`) VALUES
('CO-10055', 'tsyazoko', 40000, 'RASOLONANTENAINA Mahamby Auréole', '', '385641234', '', 'Andrainjato II', 'aureolerm@gmail.com', '2023-03-10 15:35:39'),
('CO-10080', 'saitama', 158397, 'MAMINIRINA Honoré Philibert', '', '346997404', '', 'Ambatotokana Fianarantsoa', 'maminirinahonorephilibert@gmail.com', '2023-03-10 15:49:20'),
('CO-10081', '2', 0, 'TALETSY Ghislain Judicael', '', '345212364', '', 'Ambodirano ', 'taletsy@gmail.com', '2023-03-12 16:09:50'),
('CO-10084', '2', 0, 'RAMANANTENANTSOA Flavien Enicot', '', '343141252', '', 'Ambodirano ', 'tocineflam@jah.net', '2023-03-12 16:15:33'),
('CO-10086', '2', -13000, 'FANOMEZANJANAHARY Albertine', '', '345841265', '', 'Tanambao', 'harybertine@gmail.com', '2023-03-12 16:56:53'),
('CO-10092', 'WILLY', 20000, 'RANDIANTSILEO Nomenjanahary Willy', '203512145845', '0346952123', 'homme', 'Isaha', 'willy@noob.net', '2023-03-14 14:39:33');

-- --------------------------------------------------------

--
-- Structure de la table `retrait`
--

CREATE TABLE `retrait` (
  `num_retrait` int(11) NOT NULL,
  `num_compte` varchar(8) NOT NULL,
  `num_cheque` int(6) NOT NULL,
  `montant_retrait` float NOT NULL,
  `date_retrait` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `retrait`
--

INSERT INTO `retrait` (`num_retrait`, `num_compte`, `num_cheque`, `montant_retrait`, `date_retrait`) VALUES
(1, 'CO-10055', 53435, 12000, '2023-03-10 15:47:15'),
(2, 'CO-10080', 534563, 89000, '2023-03-10 15:49:41'),
(6, 'CO-10090', 210321, 15000, '2023-03-13 15:37:28'),
(9, 'CO-10092', 254669, 5000, '2023-03-14 14:41:37');

-- --------------------------------------------------------

--
-- Structure de la table `transfert`
--

CREATE TABLE `transfert` (
  `num_transfert` int(11) NOT NULL,
  `num_compte_env` varchar(8) NOT NULL,
  `num_compte_rec` varchar(8) NOT NULL,
  `montant_transfert` float NOT NULL,
  `motif` varchar(100) DEFAULT NULL,
  `date_transfert` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `transfert`
--

INSERT INTO `transfert` (`num_transfert`, `num_compte_env`, `num_compte_rec`, `montant_transfert`, `motif`, `date_transfert`) VALUES
(1, 'CO-10055', 'CO-10080', 20000, 'Gouter', '2023-03-10 15:52:16'),
(2, 'CO-10055', 'CO-10080', 25000, 'Gouter', '2023-03-11 16:42:21'),
(3, 'CO-10080', 'CO-10055', 39700, 'Gouter', '2023-03-11 16:46:03'),
(5, 'CO-10080', 'CO-10090', 45000, 'Gouter', '2023-03-13 14:20:15'),
(7, 'CO-10055', 'CO-10080', 4697, '21', '2023-03-13 16:31:59');

-- --------------------------------------------------------

--
-- Structure de la table `versement`
--

CREATE TABLE `versement` (
  `num_versement` int(11) NOT NULL,
  `num_compte` varchar(8) NOT NULL,
  `montant_versement` float NOT NULL,
  `date_versement` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `versement`
--

INSERT INTO `versement` (`num_versement`, `num_compte`, `montant_versement`, `date_versement`) VALUES
(2, 'CO-10080', 150000, '2023-03-10 15:49:57'),
(5, 'CO-10080', 22000, '2023-03-11 14:26:51'),
(8, 'CO-10080', 26900, '2023-03-11 14:42:40'),
(13, 'CO-10088', 12000, '2023-03-13 14:48:27'),
(17, 'CO-10055', 6000, '2023-03-13 15:02:46'),
(19, 'CO-10090', 23000, '2023-03-14 13:53:12'),
(21, 'CO-10087', 25000, '2023-03-15 09:19:08');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`num_admin`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`num_compte`);

--
-- Index pour la table `retrait`
--
ALTER TABLE `retrait`
  ADD PRIMARY KEY (`num_retrait`);

--
-- Index pour la table `transfert`
--
ALTER TABLE `transfert`
  ADD PRIMARY KEY (`num_transfert`);

--
-- Index pour la table `versement`
--
ALTER TABLE `versement`
  ADD PRIMARY KEY (`num_versement`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `num_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `retrait`
--
ALTER TABLE `retrait`
  MODIFY `num_retrait` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `transfert`
--
ALTER TABLE `transfert`
  MODIFY `num_transfert` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `versement`
--
ALTER TABLE `versement`
  MODIFY `num_versement` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
