-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Jan 15, 2024 at 02:33 AM
-- Server version: 8.0.31
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `trainOrm`
--
CREATE DATABASE IF NOT EXISTS `trainOrm` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `trainOrm`;

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `pet_allowed` bit(1) DEFAULT NULL,
  `id` bigint NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `organizer` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`pet_allowed`, `id`, `category`, `date`, `description`, `location`, `organizer`, `time`, `title`) VALUES
(b'0', 1, 'Academic', '3rd Sept', 'A time for taking the exam', 'CAMT Building', 'CAMT', '3.00-4.00 pm.', 'Midterm Exam'),
(b'0', 2, 'Academic', '21th Jan', 'A time for celebration', 'CMU Convention hall', 'CMU', '8.00am-4.00 pm.', 'Commencement Day'),
(b'0', 3, 'Cultural', '21th Nov', 'A time for Krathong', 'Ping River', 'Chiang Mai', '8.00-10.00 pm.', 'Loy Krathong'),
(b'1', 4, 'Cultural', '13th April', 'Let\'s Play Water', 'Chiang Mai Moat', 'Chiang Mai Municipality', '10.00am - 6.00 pm.', 'Songkran');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
