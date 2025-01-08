CREATE TABLE `scott`.`goods` (
  `gid` INT NOT NULL AUTO_INCREMENT,
  `gname` VARCHAR(20) NOT NULL,
  `gcontent` VARCHAR(100) NOT NULL,
  `gcnt` INT NOT NULL,
  `getc` VARCHAR(100) NULL,
  PRIMARY KEY (`gid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
