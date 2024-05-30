# Задание 7
CREATE DATABASE `Друзья человека`;

# Задание 8
USE `Друзья человека`;

CREATE TABLE Собаки
(
    id INT,
    Имя VARCHAR(45),
    Команды VARCHAR(45),
    `Дата Рождения` DATE
);

CREATE TABLE Кошки
(
    id INT,
    Имя VARCHAR(45),
    Команды VARCHAR(45),
    `Дата Рождения` DATE
);

CREATE TABLE Хомяки
(
    id INT,
    Имя VARCHAR(45),
    Команды VARCHAR(45),
    `Дата Рождения` DATE
);

CREATE TABLE Лошади
(
    id INT,
    Имя VARCHAR(45),
    Команды VARCHAR(45),
    `Дата Рождения` DATE
);

CREATE TABLE Верблюды
(
    id INT,
    Имя VARCHAR(45),
    Команды VARCHAR(45),
    `Дата Рождения` DATE
);

CREATE TABLE Ослы
(
    id INT,
    Имя VARCHAR(45),
    Команды VARCHAR(45),
    `Дата Рождения` DATE
);

# Задание 9

INSERT INTO Кошки (id, Имя, Команды, `Дата Рождения`)
VALUES(1,'Barsik', 'sit', date'2010-04-10'), (2,'Ryzhik', 'lie', date'2016-09-22'), (3,'Tom', 'voice', date'2019-08-01');

INSERT INTO Собаки (id, Имя, Команды, `Дата Рождения`)
VALUES(4,'Gerda', 'lie', date'2016-02-03'), (5, 'Rex', 'come here', date'2019-04-05'), (6,'Jack', 'bring', date'2020-06-07');

INSERT INTO Хомяки (id, Имя, Команды, `Дата Рождения`)
VALUES(7,'John', 'run', date'2021-08-09'), (8, 'Real', 'lie', date'2022-10-11'), (9, 'Barsa', 'lie', date'2019-12-13');

INSERT INTO Лошади (id, Имя, Команды, `Дата Рождения`)
VALUES(10,'Doom', 'stop', date'2017-01-02'), (11, 'Arsenal', 'come here', date'2019-03-04'), (12, 'Vindizel', 'galop', date'2014-05-06');

INSERT INTO Верблюды (id, Имя, Команды, `Дата Рождения`)
VALUES(13,'Kuzya', 'lie, stand up', date'2014-07-08'), (14, 'Alibaba', 'come here', date'2016-09-10');

INSERT INTO Ослы (id, Имя, Команды, `Дата Рождения`)
VALUES(15,'Vasya', 'run', date'2019-11-12'), (16, 'Artur', 'sit', date'2018-01-01');

#Задание 10
TRUNCATE TABLE Верблюды;

SELECT * FROM Лошади 
UNION SELECT * FROM Ослы
AS `Вьючные животные`;

#Задание 11

CREATE TABLE `Молодые животные`
SELECT id, Имя, Команды, `Дата Рождения`, 
(YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) AS Возраст
FROM Собаки
WHERE (YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) < 3 
AND (YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) > 1
UNION
SELECT id, Имя, Команды, `Дата Рождения`, 
(YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) AS Возраст
FROM Кошки
WHERE (YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) < 3 
AND (YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) > 1
UNION
SELECT id, Имя, Команды, `Дата Рождения`, 
(YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) AS Возраст
FROM Хомяки
WHERE (YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) < 3 
AND (YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) > 1
UNION
SELECT id, Имя, Команды, `Дата Рождения`, 
(YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) AS Возраст
FROM Лошади
WHERE (YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) < 3 
AND (YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) > 1
UNION
SELECT id, Имя, Команды, `Дата Рождения`, 
(YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) AS Возраст
FROM Верблюды
WHERE (YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) < 3 
AND (YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) > 1
UNION
SELECT id, Имя, Команды, `Дата Рождения`, 
(YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) AS Возраст
FROM Ослы
WHERE (YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) < 3 
AND (YEAR(CURRENT_DATE)-YEAR(`Дата Рождения`)) - (RIGHT(CURRENT_DATE,5)<RIGHT(`Дата Рождения`,5)) > 1
ORDER BY id;

ALTER TABLE `Молодые животные` ADD COLUMN `Точный возраст` VARCHAR (30);
UPDATE `Молодые животные` SET `Точный возраст` = (CONCAT(TIMESTAMPDIFF(YEAR, `Дата Рождения`, CURRENT_DATE),' года ', 
			TIMESTAMPDIFF(MONTH, `Дата Рождения`, CURRENT_DATE) % 12, ' месяцев '));


# Задание 12

CREATE TABLE `Все животные` (
	id INT,
	Имя VARCHAR(45),
    Команды VARCHAR(45),
    `Дата Рождения` DATE,
    `Название таблицы` ENUM('Кошки','Собаки','Хомяки', 'Лошади', 'Ослы', 'Верблюды') 
);

INSERT INTO `Все животные` (id, Имя, Команды, `Дата Рождения`, `Название таблицы`)
SELECT id, Имя, Команды, `Дата Рождения`, 'Кошки'
FROM Кошки;

INSERT INTO `Все животные` (id, Имя, Команды, `Дата Рождения`, `Название таблицы`)
SELECT id, Имя, Команды, `Дата Рождения`, 'Собаки'
FROM Собаки; 

INSERT INTO `Все животные` (id, Имя, Команды, `Дата Рождения`, `Название таблицы`)
SELECT id, Имя, Команды, `Дата Рождения`, 'Хомяки'
FROM Хомяки;

INSERT INTO `Все животные` (id, Имя, Команды, `Дата Рождения`, `Название таблицы`)
SELECT id, Имя, Команды, `Дата Рождения`, 'Лошади'
FROM Лошади;

INSERT INTO `Все животные` (id, Имя, Команды, `Дата Рождения`, `Название таблицы`)
SELECT id, Имя, Команды, `Дата Рождения`, 'Ослы'
FROM Ослы;

INSERT INTO `Все животные` (id, Имя, Команды, `Дата Рождения`, `Название таблицы`)
SELECT id, Имя, Команды, `Дата Рождения`, 'Верблюды'
FROM Верблюды;