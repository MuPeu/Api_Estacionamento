-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 28/08/2025 às 22:03
-- Versão do servidor: 8.4.5
-- Versão do PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `db_estacionamento`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_carros`
--

CREATE TABLE `tb_carros` (
  `id_placa` varchar(255) NOT NULL,
  `marca` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `modelo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ano` int NOT NULL,
  `entrada` datetime DEFAULT NULL,
  `saida` datetime DEFAULT NULL,
  `valor_hora` double DEFAULT NULL,
  `permanencia` int DEFAULT NULL,
  `valor_total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `tb_carros`
--

INSERT INTO `tb_carros` (`id_placa`, `marca`, `modelo`, `cor`, `ano`, `entrada`, `saida`, `valor_hora`, `permanencia`, `valor_total`) VALUES
('ABC1234', 'Volkswagen', 'Gol', 'Prata', 2015, '2025-08-20 08:15:00', '2025-08-20 11:15:00', 5, 3, 15),
('BCD9012', 'Peugeot', '208', 'Amarelo', 2020, '2025-08-25 10:00:00', '2025-08-25 13:00:00', 6.5, 3, 19.5),
('CDE7890', 'Honda', 'Fit', 'Azul', 2017, '2025-08-30 09:00:00', '2025-08-30 13:00:00', 6, 4, 24),
('DEF5678', 'Fiat', 'Uno', 'Branco', 2012, '2025-08-21 09:00:00', '2025-08-21 12:30:00', 4.5, 3, 13.5),
('EFG3456', 'Citroën', 'C3', 'Verde', 2013, '2025-08-26 09:00:00', '2025-08-26 12:00:00', 5.5, 3, 16.5),
('FGH2345', 'Renault', 'Logan', 'Prata', 2016, '2025-08-30 10:30:00', '2025-08-30 13:30:00', 5.5, 3, 16.5),
('GHI9012', 'Chevrolet', 'Onix', 'Preto', 2020, '2025-08-22 07:45:00', '2025-08-22 10:15:00', 6, 2, 12),
('GJR6538', 'Toyota', 'Corolla', 'Prata', 2020, '2025-08-28 16:37:00', '2025-08-28 16:48:30', 25, 1, 25),
('HIJ7890', 'Jeep', 'Renegade', 'Marrom', 2022, '2025-08-26 07:30:00', '2025-08-26 11:30:00', 9, 4, 36),
('IJK6789', 'Nissan', 'Kicks', 'Preto', 2019, '2025-08-31 07:00:00', '2025-08-31 11:00:00', 7.5, 4, 30),
('JKL3456', 'Ford', 'Ka', 'Vermelho', 2018, '2025-08-22 10:30:00', '2025-08-22 15:30:00', 5.5, 5, 27.5),
('KLM2345', 'Volkswagen', 'T-Cross', 'Azul', 2021, '2025-08-27 10:15:00', '2025-08-27 14:15:00', 8, 4, 32),
('LMN1234', 'Jeep', 'Compass', 'Branco', 2020, '2025-08-31 08:30:00', '2025-08-31 12:30:00', 9, 4, 36),
('MNO7890', 'Hyundai', 'HB20', 'Azul', 2019, '2025-08-23 08:00:00', '2025-08-23 11:00:00', 6.5, 3, 19.5),
('NOP6789', 'Chevrolet', 'Spin', 'Prata', 2019, '2025-08-27 08:00:00', '2025-08-27 11:00:00', 6, 3, 18),
('OPQ5678', 'Volkswagen', 'Saveiro', 'Vermelho', 2015, '2025-09-01 09:00:00', '2025-09-01 13:00:00', 6, 4, 24),
('PQR2345', 'Toyota', 'Corolla', 'Cinza', 2021, '2025-08-23 09:30:00', '2025-08-23 14:30:00', 8, 5, 40),
('QRS1234', 'Fiat', 'Argo', 'Vermelho', 2020, '2025-08-28 09:30:00', '2025-08-28 12:00:00', 6.5, 2, 13),
('RST9012', 'Chevrolet', 'Tracker', 'Cinza', 2021, '2025-09-01 10:00:00', '2025-09-01 14:00:00', 8, 4, 32),
('STU6789', 'Honda', 'Civic', 'Preto', 2017, '2025-08-24 07:00:00', '2025-08-24 12:00:00', 7.5, 5, 37.5),
('TUV5678', 'Ford', 'EcoSport', 'Preto', 2018, '2025-08-28 14:00:00', '2025-08-28 18:00:00', 7, 4, 28),
('UVW3456', 'Fiat', 'Toro', 'Marrom', 2022, '2025-09-02 11:00:00', '2025-09-02 15:00:00', 9.5, 4, 38),
('VWX1234', 'Nissan', 'Versa', 'Prata', 2016, '2025-08-24 13:00:00', '2025-08-24 15:00:00', 6, 2, 12),
('WXY9012', 'Hyundai', 'Creta', 'Cinza', 2021, '2025-08-29 07:45:00', '2025-08-29 12:45:00', 8.5, 5, 42.5),
('YUZ6723', 'Fiat', 'Uno', 'Branco', 2020, '2025-08-28 16:19:08', NULL, 25, NULL, NULL),
('YZA5678', 'Renault', 'Sandero', 'Branco', 2014, '2025-08-25 08:30:00', '2025-08-25 12:30:00', 5, 4, 20),
('ZAB3456', 'Toyota', 'Yaris', 'Branco', 2022, '2025-08-29 08:15:00', '2025-08-29 11:15:00', 7.5, 3, 22.5);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `tb_carros`
--
ALTER TABLE `tb_carros`
  ADD PRIMARY KEY (`id_placa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
