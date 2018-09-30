ALTER TABLE `caminhosuave`.`ALUNO` 
ADD COLUMN `nota_T1` DOUBLE NOT NULL AFTER `nota_P2`,
ADD COLUMN `nota_T2` DOUBLE NOT NULL AFTER `nota_T1`,
ADD COLUMN `sobrenome` VARCHAR(255) NOT NULL AFTER `nota_T2`,
ADD COLUMN `peso_provas` DOUBLE NOT NULL AFTER `sobrenome`,
ADD COLUMN `peso_trabalhos` DOUBLE NOT NULL AFTER `peso_provas`,
ADD COLUMN `nivel` VARCHAR(255) NOT NULL AFTER `peso_trabalhos`,
ADD COLUMN `situacao` VARCHAR(255) NULL AFTER `nivel`,
ADD COLUMN `nota_final` DOUBLE NULL AFTER `situacao`;
