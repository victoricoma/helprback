-- MySQL Script generated by MySQL Workbench
-- Mon Jul 25 11:00:32 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema empregados_db
-- -----------------------------------------------------
-- Modelo relacional de banco de dados para BCW22 em estrrutura de MySQL

-- -----------------------------------------------------
-- Schema empregados_db
--
-- Modelo relacional de banco de dados para BCW22 em estrrutura de MySQL
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empregados_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `empregados_db` ;

-- -----------------------------------------------------
-- Table `empregados_db`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empregados_db`.`departamento` (
  `cod_depto` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`cod_depto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empregados_db`.`empregado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empregados_db`.`empregado` (
  `cod_empregado` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `dt_nascimento` DATE NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `dt_admissao` DATE NOT NULL,
  `civil` CHAR(1) NOT NULL,
  `salario` DECIMAL(10,2) NOT NULL,
  `cod_depto` INT NOT NULL,
  PRIMARY KEY (`cod_empregado`),
  INDEX `fk_empregado_departamento_idx` (`cod_depto` ASC) VISIBLE,
  CONSTRAINT `fk_empregado_departamento`
    FOREIGN KEY (`cod_depto`)
    REFERENCES `empregados_db`.`departamento` (`cod_depto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empregados_db`.`dependente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empregados_db`.`dependente` (
  `cod_dep` INT NOT NULL AUTO_INCREMENT,
  `cod_empregado` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `dt_nascimento` DATE NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  PRIMARY KEY (`cod_dep`, `cod_empregado`),
  INDEX `fk_dependente_empregado1_idx` (`cod_empregado` ASC) VISIBLE,
  CONSTRAINT `fk_dependente_empregado1`
    FOREIGN KEY (`cod_empregado`)
    REFERENCES `empregados_db`.`empregado` (`cod_empregado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
