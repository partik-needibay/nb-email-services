SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `thire`
--

-- --------------------------------------------------------

--
-- Table structure for table `th_system_configuration`
--

CREATE TABLE `th_system_configuration` (
  `id` int(11) NOT NULL COMMENT 'Primary Key',
  `microservice` varchar(255) NOT NULL COMMENT 'Microservice Name',
  `config_key` varchar(255) NOT NULL COMMENT 'Configuration Name',
  `config_value` varchar(255) NOT NULL COMMENT 'Configuration Value',
  `created_at` datetime  NOT NULL COMMENT 'Created At',
  `updated_at` datetime  NOT NULL COMMENT 'Updated At'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `th_system_configuration`
--
ALTER TABLE `th_system_configuration`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `th_system_configuration`
--
ALTER TABLE `th_system_configuration`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;
COMMIT;
