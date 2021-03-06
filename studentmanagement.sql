-- MySQL Script generated by MySQL Workbench
-- Sun Mar 15 10:15:27 2020
-- Model: New Model    Version: 1.0
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

-- -----------------------------------------------------
-- Schema studentmanagement
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `studentmanagement` DEFAULT CHARACTER SET utf8 ;
USE `studentmanagement` ;

-- -----------------------------------------------------
-- Table `studentmanagement`.`cost`
-- -----------------------------------------------------
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
CREATE TABLE IF NOT EXISTS `studentmanagement`.`course` (
  `Id` VARCHAR(20) NOT NULL,
  `Name` TEXT NOT NULL,
  `ClassQuantity` INT NOT NULL,
  `StartDay` DATE NOT NULL,
  `EndDay` DATE NOT NULL,
  `IdCost` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_course_cost1` (`IdCost` ASC) VISIBLE,
  CONSTRAINT `fk_course_cost1`
    FOREIGN KEY (`IdCost`)
    REFERENCES `studentmanagement`.`cost` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentmanagement`.`schedule` (
  `Id` VARCHAR(20) NOT NULL,
  `DaysOfWeek` INT NOT NULL,
  `StartTime` VARCHAR(8) NOT NULL,
  `EndTime` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`Id`, `DaysOfWeek`, `StartTime`, `EndTime`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`profile`
-- -----------------------------------------------------
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
CREATE TABLE IF NOT EXISTS `studentmanagement`.`teacher` (
  `Id` VARCHAR(20) NOT NULL,
  `Workplace` TEXT NOT NULL,
  `Salary` DOUBLE NOT NULL,
  `IdProfile` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_teacher_profile1` (`IdProfile` ASC) VISIBLE,
  CONSTRAINT `fk_teacher_profile1`
    FOREIGN KEY (`IdProfile`)
    REFERENCES `studentmanagement`.`profile` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentmanagement`.`class` (
  `Id` VARCHAR(20) NOT NULL,
  `Name` VARCHAR(50) NOT NULL,
  `StudentQuantity` INT NOT NULL,
  `IdTeacher` VARCHAR(20) NOT NULL,
  `IdSchedule` VARCHAR(20) NOT NULL,
  `IdCourse` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_class_course1` (`IdCourse` ASC) VISIBLE,
  INDEX `fk_class_schedule1` (`IdSchedule` ASC) VISIBLE,
  INDEX `fk_class_teacher` (`IdTeacher` ASC) VISIBLE,
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
-- Table `studentmanagement`.`register`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentmanagement`.`register` (
  `State` VARCHAR(50) NOT NULL,
  `TypeOfRegister` VARCHAR(50) NOT NULL,
  `Id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`result`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentmanagement`.`result` (
  `IdStudent` VARCHAR(20) NOT NULL,
  `IdClass` VARCHAR(20) NOT NULL,
  `StudyMark` DOUBLE NOT NULL,
  `RewardMark` DOUBLE NOT NULL,
  `DisciplineMark` DOUBLE NOT NULL,
  `MoneyPaid` DOUBLE NOT NULL,
  `NumberOfAbsences` INT NULL DEFAULT NULL,
  PRIMARY KEY (`IdStudent`, `IdClass`),
  INDEX `fk_student_has_class_class1` (`IdClass` ASC) VISIBLE,
  CONSTRAINT `fk_student_has_class_class1`
    FOREIGN KEY (`IdClass`)
    REFERENCES `studentmanagement`.`class` (`Id`),
  CONSTRAINT `fk_student_has_class_student1`
    FOREIGN KEY (`IdStudent`)
    REFERENCES `studentmanagement`.`student` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`studentofficial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentmanagement`.`studentofficial` (
  `IdStudent` VARCHAR(20) NOT NULL,
  `IdClass` VARCHAR(20) NOT NULL,
  `IdProfile` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`IdStudent`, `IdClass`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`studentunofficial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentmanagement`.`studentunofficial` (
  `Id` VARCHAR(20) NOT NULL,
  `DiscountStatus` TINYINT(1) NOT NULL,
  `IdProfile` VARCHAR(20) NOT NULL,
  `Cost` DOUBLE NOT NULL,
  `IdRegister` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_student_profile1` (`IdProfile` ASC) VISIBLE,
  INDEX `fk_student_register_idx` (`IdRegister` ASC) VISIBLE,
  CONSTRAINT `fk_student_profile1`
    FOREIGN KEY (`IdProfile`)
    REFERENCES `studentmanagement`.`profile` (`Id`),
  CONSTRAINT `fk_student_register`
    FOREIGN KEY (`IdRegister`)
    REFERENCES `studentmanagement`.`register` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`timekeeping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentmanagement`.`timekeeping` (
  `TeachingHours` DOUBLE NOT NULL,
  `RewardLevel` VARCHAR(20) NOT NULL,
  `DisciplineLevel` VARCHAR(20) NOT NULL,
  `IdTeacher` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`IdTeacher`),
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
