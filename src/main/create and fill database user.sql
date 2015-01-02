DROP DATABASE IF EXISTS TEST;
CREATE DATABASE TEST;
USE TEST;
DROP TABLE IF EXISTS `test`.`user`;
CREATE TABLE USER
        (
          id int(8) unsigned NOT NULL AUTO_INCREMENT,
          name varchar(25) NOT NULL,
          age int(3)unsigned DEFAULT NULL,
          isAdmin boolean DEFAULT FALSE,
          createdDate timestamp DEFAULT NULL,
          PRIMARY KEY (id)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO USER(id,name,age,isAdmin,createdDate) VALUES(1,'Иванов Иван',30,true, 20150101),(2,'Петров Пётр',40,false,20150101),(3,'Сидоров Сидор',50,true,20150101),(4,'Семёнов Семён',60,false,20150101),(5,'Никифоров Никофор',70,true,20150101),(6,'Краснов Александр',80,false,20150101),(7,'Щелчков Олег',90,true,20150101);