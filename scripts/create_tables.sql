CREATE TABLE `db_dev_desktop_20181`.`PRODUTO` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `fabricante` VARCHAR(255) NOT NULL,
  `valor` DOUBLE NULL,
  `peso` DOUBLE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

  