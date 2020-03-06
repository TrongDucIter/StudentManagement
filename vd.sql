-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema studentmanagement
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `studentmanagement` ;

-- -----------------------------------------------------
-- Schema studentmanagement
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `studentmanagement` DEFAULT CHARACTER SET utf8 ;
USE `studentmanagement` ;

-- -----------------------------------------------------
-- Table `studentmanagement`.`cost`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`cost` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`cost` (
  `Id` VARCHAR(20) NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Price` DOUBLE NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`course` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`course` (
  `Id` VARCHAR(20) NOT NULL,
  `Name` TEXT NOT NULL,
  `ClassQuantity` INT(11) NOT NULL,
  `StartDay` DATE NOT NULL,
  `EndDay` DATE NOT NULL,
  `IdCost` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_course_cost1_idx` (`IdCost` ASC) VISIBLE,
  CONSTRAINT `fk_course_cost1`
    FOREIGN KEY (`IdCost`)
    REFERENCES `studentmanagement`.`cost` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`schedule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`schedule` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`schedule` (
  `Id` VARCHAR(20) NOT NULL,
  `DaysOfWeek` INT(11) NOT NULL,
  `StartTime` TIME NOT NULL,
  `EndTime` TIME NOT NULL,
  PRIMARY KEY (`Id`, `DaysOfWeek`, `StartTime`, `EndTime`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`profile` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`profile` (
  `Name` VARCHAR(50) NOT NULL,
  `Gender` TINYINT(1) NOT NULL,
  `DayOfBirth` DATE NOT NULL,
  `PhoneNumber` VARCHAR(20) NOT NULL,
  `Hometown` TEXT NOT NULL,
  `CurrentAddress` TEXT NOT NULL,
  `IdNumber` VARCHAR(20) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `Id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`teacher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`teacher` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`teacher` (
  `Id` VARCHAR(20) NOT NULL,
  `Workplace` TEXT NOT NULL,
  `Salary` DOUBLE NOT NULL,
  `IdProfile` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_teacher_profile1_idx` (`IdProfile` ASC) VISIBLE,
  CONSTRAINT `fk_teacher_profile1`
    FOREIGN KEY (`IdProfile`)
    REFERENCES `studentmanagement`.`profile` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`class`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`class` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`class` (
  `Id` VARCHAR(20) NOT NULL,
  `Name` VARCHAR(50) NOT NULL,
  `StudentQuantity` INT(11) NOT NULL,
  `IdTeacher` VARCHAR(20) NOT NULL,
  `IdSchedule` VARCHAR(20) NOT NULL,
  `IdCourse` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_class_teacher_idx` (`IdTeacher` ASC) VISIBLE,
  INDEX `fk_class_schedule1_idx` (`IdSchedule` ASC) VISIBLE,
  INDEX `fk_class_course1_idx` (`IdCourse` ASC) VISIBLE,
  CONSTRAINT `fk_class_course1`
    FOREIGN KEY (`IdCourse`)
    REFERENCES `studentmanagement`.`course` (`Id`),
  CONSTRAINT `fk_class_schedule1`
    FOREIGN KEY (`IdSchedule`)
    REFERENCES `studentmanagement`.`schedule` (`Id`),
  CONSTRAINT `fk_class_teacher`
    FOREIGN KEY (`IdTeacher`)
    REFERENCES `studentmanagement`.`teacher` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`student` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`student` (
  `Id` VARCHAR(20) NOT NULL,
  `DiscountStatus` TINYINT(1) NOT NULL,
  `IdProfile` VARCHAR(20) NOT NULL,
  `Cost` DOUBLE NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_student_profile1_idx` (`IdProfile` ASC) VISIBLE,
  CONSTRAINT `fk_student_profile1`
    FOREIGN KEY (`IdProfile`)
    REFERENCES `studentmanagement`.`profile` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`register`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`register` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`register` (
  `State` VARCHAR(50) NOT NULL,
  `TypeOfRegister` VARCHAR(50) NOT NULL,
  `IdStudent` VARCHAR(20) NOT NULL,
  INDEX `fk_register_student_idx` (`IdStudent` ASC) VISIBLE,
  CONSTRAINT `fk_register_student`
    FOREIGN KEY (`IdStudent`)
    REFERENCES `studentmanagement`.`student` (`Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`result`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`result` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`result` (
  `IdStudent` VARCHAR(20) NOT NULL,
  `IdClass` VARCHAR(20) NOT NULL,
  `StudyMark` DOUBLE NOT NULL,
  `RewardMark` DOUBLE NOT NULL,
  `DisciplineMark` DOUBLE NOT NULL,
  `MoneyPaid` DOUBLE NOT NULL,
  PRIMARY KEY (`IdStudent`, `IdClass`),
  INDEX `fk_student_has_class_class1_idx` (`IdClass` ASC) VISIBLE,
  INDEX `fk_student_has_class_student1_idx` (`IdStudent` ASC) VISIBLE,
  CONSTRAINT `fk_student_has_class_class1`
    FOREIGN KEY (`IdClass`)
    REFERENCES `studentmanagement`.`class` (`Id`),
  CONSTRAINT `fk_student_has_class_student1`
    FOREIGN KEY (`IdStudent`)
    REFERENCES `studentmanagement`.`student` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`timekeeping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`timekeeping` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`timekeeping` (
  `TeachingHours` INT(11) NOT NULL,
  `RewardLevel` INT(11) NOT NULL,
  `DisciplineLevel` INT(11) NOT NULL,
  `IdTeacher` VARCHAR(20) NOT NULL,
  INDEX `fk_timekeeping_teacher1_idx` (`IdTeacher` ASC) VISIBLE,
  CONSTRAINT `fk_timekeeping_teacher1`
    FOREIGN KEY (`IdTeacher`)
    REFERENCES `studentmanagement`.`teacher` (`Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
