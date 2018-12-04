--um para muchos
DROP DATABASE IF EXISTS DBPHRASE;
CREATE DATABASE DBPHRASE;
USE DBPHRASE;

CREATE TABLE PERSON (ID INT AUTO_INCREMENT, NAME VARCHAR(20) UNIQUE NOT NULL,
CONSTRAINT PK_PERSON PRIMARY KEY (ID));

CREATE TABLE PHRASE (ID INT AUTO_INCREMENT, PHRASE VARCHAR(20) UNIQUE NOT NULL, ID_PERSON INT NOT NULL,
CONSTRAINT PK_PHRASE PRIMARY KEY (ID),
CONSTRAINT FK_PHRASE FOREIGN KEY (ID_PERSON) REFERENCES PERSON(ID));

INSERT INTO PERSON VALUES (NULL, 'GABRIEL');
INSERT INTO PERSON VALUES (NULL, 'BELEM');

INSERT INTO PHRASE VALUES (NULL, 'TUTO BUIO', 1);
INSERT INTO PHRASE VALUES (NULL, 'TUTO BUIO', 2);
INSERT INTO PHRASE VALUES (NULL, 'TESTE', 1);