CREATE SCHEMA `db_dev_desktop_20182` ;

CREATE TABLE `db_dev_desktop_20182`.`PRODUTO` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `fabricante` VARCHAR(255) NOT NULL,
  `valor` DOUBLE NULL,
  `peso` DOUBLE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
  
  CREATE TABLE `db_dev_desktop_20182`.`FUNCIONARIO` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(255) NOT NULL,
  `MATRICULA` VARCHAR(255) NOT NULL,
  `CPF` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ID`));

  
-- INSERTS
INSERT INTO `db_dev_desktop_20182`.`PRODUTO` (`id`, `nome`, `fabricante`, `valor`, `peso`) VALUES ('1', 'Caneta', 'Bic', '1.5', '0.2');
INSERT INTO `db_dev_desktop_20182`.`PRODUTO` (`id`, `nome`, `fabricante`, `valor`, `peso`) VALUES ('2', 'Lápis', 'Faber-Castell', '0.75', '0.22');
INSERT INTO `db_dev_desktop_20182`.`PRODUTO` (`id`, `nome`, `fabricante`, `valor`, `peso`) VALUES ('3', 'Mouse', 'HP', '120', '0.35');


  