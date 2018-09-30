CREATE SCHEMA `caminhosuave` ;

CREATE TABLE `caminhosuave`.`ALUNO` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `matricula` VARCHAR(45) NOT NULL,
  `nota_P1` DOUBLE NULL,
  `nota_P2` DOUBLE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `matricula_UNIQUE` (`matricula` ASC));
