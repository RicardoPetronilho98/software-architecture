SET SQL_SAFE_UPDATES = 0; -- permission to remove data from tables

CREATE SCHEMA IF NOT EXISTS `University` DEFAULT CHARACTER SET utf8;
USE `University` ;

DROP TABLE IF EXISTS `University`.`Student`;

CREATE TABLE IF NOT EXISTS `University`.`Student` (
  `id`  VARCHAR(16) NOT NULL,
  `name` VARCHAR(128) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`));


INSERT INTO STUDENT (id, name, age) VALUES
	('0', 'Ricardo', 21),
    ('1', 'Mariana', 20),
    ('2', 'Jose', 22);

-- SELECT * FROM STUDENT;